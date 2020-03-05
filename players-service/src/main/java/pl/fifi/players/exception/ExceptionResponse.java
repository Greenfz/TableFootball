package pl.fifi.players.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ExceptionResponse {

    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final Date date;

}