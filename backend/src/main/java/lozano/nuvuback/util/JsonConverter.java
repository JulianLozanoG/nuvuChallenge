package lozano.nuvuback.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lozano.nuvuback.exceptions.APIErrorException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class JsonConverter {

    public static String parseToJsonString(Object objectToParse) {
        ObjectMapper nonNullMapper = new ObjectMapper();
        nonNullMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        nonNullMapper.registerModule(new JavaTimeModule());
        nonNullMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            return nonNullMapper.writeValueAsString(objectToParse);
        } catch (JsonProcessingException e) {
            throw new APIErrorException(INTERNAL_SERVER_ERROR, "Json converter error", e.getCause(),null);
        }
    }

}
