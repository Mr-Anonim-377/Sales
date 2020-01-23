package com.Sales.SalesWeb.controller.handlers;

import com.Sales.SalesWeb.controller.exception.BadParamForRequest;
import com.Sales.SalesWeb.controller.exception.InternalServerExeption;
import com.Sales.SalesWeb.controller.exception.NoSuchObject;
import com.Sales.SalesWeb.controller.exception.ShoppingProductNotSuch;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class AwesomeExceptionHandler extends ResponseEntityExceptionHandler {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LL-yyyy/HH:mm:ss");

    @ExceptionHandler(NoSuchObject.class)
    protected ResponseEntity<ExceptionResponse> handleThereIsNoSuchUserException() {
        return new ResponseEntity<>(new ExceptionResponse(LocalDateTime.now().format(formatter), "No such object in db", "NoSuchObj"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ExceptionResponse> handleNoHttpValidationParametrs() {
        return new ResponseEntity<>(new ExceptionResponse(LocalDateTime.now().format(formatter), "No Valid request param", "ArgumentTypeMismatch"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerExeption.class)
    protected ResponseEntity<ExceptionResponse> handleIntermalServerError(Exception exc) {
        return new ResponseEntity<>(new ExceptionResponse(LocalDateTime.now().format(formatter), "Server Error", exc.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadParamForRequest.class)
    protected ResponseEntity<ExceptionResponse> handleBadParamForReqest(Exception exc) {
        return new ResponseEntity<>(new ExceptionResponse(LocalDateTime.now().format(formatter), "Bad param for request", "BadParamForRequest"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ShoppingProductNotSuch.class)
    protected ResponseEntity<ExceptionResponse> handleShoppingProductNotSuch(Exception exc) {
        return new ResponseEntity<>(new ExceptionResponse(LocalDateTime.now().format(formatter), "Shopping product not such", "BadParamForRequest"), HttpStatus.BAD_REQUEST);
    }


    @Data
    @AllArgsConstructor
    private static class ExceptionResponse {
        private String dateTime;
        private String message;
        private String type;
    }


}
