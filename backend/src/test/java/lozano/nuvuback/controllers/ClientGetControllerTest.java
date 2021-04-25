package lozano.nuvuback.controllers;

import lozano.nuvuback.services.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static lozano.nuvuback.util.Utilities.CLIENT_ID;
import static lozano.nuvuback.util.Utilities.FIRST_NAME;
import static lozano.nuvuback.util.Utilities.LASTNAME;
import static lozano.nuvuback.util.Utilities.IDENTIFICATION;
import static lozano.nuvuback.util.Utilities.EMAIL;
import static lozano.nuvuback.util.Utilities.ONCE;
import static lozano.nuvuback.util.Utilities.FakeClient;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientGetControllerTest {

    private static final String URI_GET_CLIENT = "/client/{clientId}";
    private static final String ID_INVALID = "12345A7891";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService mockClientService;

    @Test
    void get_client_should_return_200_when_client_exists() throws Exception {
        when(mockClientService.getClient(eq(CLIENT_ID))).thenReturn(FakeClient.get());

        mockMvc.perform(get(URI_GET_CLIENT,CLIENT_ID)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.client.client_id", is(CLIENT_ID)))
                .andExpect(jsonPath("$.client.first_name", is(FIRST_NAME)))
                .andExpect(jsonPath("$.client.lastname", is(LASTNAME)))
                .andExpect(jsonPath("$.client.identification", is(IDENTIFICATION)))
                .andExpect(jsonPath("$.client.email", is(EMAIL)))
                .andDo(print());

        verify(mockClientService, times(ONCE)).getClient(eq(CLIENT_ID));
    }

    /*@Test
    void get_client_should_return_404_when_client_is_not_found() throws Exception {
        when(mockClientService.getClient(eq(CLIENT_ID))).thenReturn(null);

        mockMvc.perform(get(URI_GET_CLIENT,CLIENT_ID)
                .accept(APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", is("Client does not exists.")))
                .andExpect(jsonPath("$.status", is(HttpStatus.NOT_FOUND.name())))
                .andDo(print());

        verify(mockClientService, times(ONCE)).getClient(eq(CLIENT_ID));
    }*/

    @Test
    void get_client_should_return_400_when_client_is_invalid() throws Exception {

        mockMvc.perform(get(URI_GET_CLIENT,ID_INVALID)
                .accept(APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(print());

        verify(mockClientService, never()).getClient(anyInt());
    }
}
