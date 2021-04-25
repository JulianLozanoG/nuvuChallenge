package lozano.nuvuback.util;

import lombok.experimental.UtilityClass;
import lozano.nuvuback.controllers.domain.ClientResponse;
import lozano.nuvuback.entities.Client;

@UtilityClass
public final class Utilities {

    public static final int ONCE = 1;
    public static final Integer CLIENT_ID = 12345678;
    public static final String FIRST_NAME = "JULIAN";
    public static final String LASTNAME = "LOZANO";
    public static final String IDENTIFICATION = "101845637";
    public static final String EMAIL = "jalozanog93@hotmail.com";

    public static final class FakeClient {
        public static Client get() {
            Client client = new Client();
            client.setId(CLIENT_ID);
            client.setFirstName(FIRST_NAME);
            client.setLastName(LASTNAME);
            client.setCreditCards(null);
            client.setIdentification(IDENTIFICATION);
            client.setEmail(EMAIL);

            return client;
        }
    }

    public static final class FakeClientResponse {
        public static ClientResponse get() {return new ClientResponse(FakeClient.get());}
    }
}
