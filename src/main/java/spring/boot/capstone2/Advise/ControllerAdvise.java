package spring.boot.capstone2.Advise;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import spring.boot.capstone2.Api.ApiException;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity handleApiException(ApiException e) {
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    // Example: Adding a unique user that already exists.
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
//    //Validation failed
     // Example: using an invalid email format.
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
//    // Example: Trying to POST data to an endpoint that only supports GET requests.
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
//    // Example: Sending an incorrectly formatted JSON body.Like send "balance":"hi"
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
//    // Example: Passing a string instead of an integer in the request when the method expects an integer.
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    // Example : No static resource api/RentalTransaction/delete/3." ( not found 404)
    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity NoResourceFoundException(NoResourceFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }
    //Example // passing JSON but request when the method expects a Params
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity MissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }
}

