package lozano.nuvuback.controllers;

import lozano.nuvuback.entities.Client;
import lozano.nuvuback.services.ClientService;
import lozano.nuvuback.util.JsonConverter;
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
import static lozano.nuvuback.util.Utilities.FakeClientResponse;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ClientPostControllerTest {

    private static final String URI_POST_CLIENT = "/client";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService mockClientService;

    @Test
    void post_client_should_return_200_when_creates_successfully() throws Exception {
        //ClientResponse fakeClientResponse = FakeClientResponse.get().getClient();

        when(mockClientService.createClient(any(Client.class))).thenReturn(FakeClientResponse.get().getClient());

        mockMvc.perform(post(URI_POST_CLIENT)
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .content(JsonConverter.parseToJsonString(FakeClient.get())))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.client.client_id", is(CLIENT_ID)))
                .andExpect(jsonPath("$.client.first_name", is(FIRST_NAME)))
                .andExpect(jsonPath("$.client.lastname", is(LASTNAME)))
                .andExpect(jsonPath("$.client.identification", is(IDENTIFICATION)))
                .andExpect(jsonPath("$.client.email", is(EMAIL)));

        verify(mockClientService, times(ONCE)).createClient(any(Client.class));
    }
}

