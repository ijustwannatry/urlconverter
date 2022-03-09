package task.urlconverter.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotValidUrlException.class)
    protected ResponseEntity<Object> handle(NotValidUrlException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(),
                                       new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(KeyNotFoundException.class)
    protected ResponseEntity<Object> handle(KeyNotFoundException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(),
                                       new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
