package lozano.nuvuback.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {
    private Integer errorCode;
    private String message;
    private HttpStatus status;
    private String description;
    private List<String> details;

    public ApiError() {this(0, "Default message - Internal server error", INTERNAL_SERVER_ERROR);}

    public ApiError(Integer errorCode, String message, HttpStatus status) {
        this.errorCode = errorCode;
        this.message = message;
        this.status = status;
    }
}
