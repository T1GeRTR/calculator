package com.t1gerok.calculator.exception;

import com.t1gerok.calculator.response.FailureResponse;
import com.t1gerok.calculator.response.FailuresResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestCookieException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    List<FailureResponse> errors = new ArrayList<>();

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<FailuresResponse> handleMissingParams(HttpMessageNotReadableException ex) {
        logger.debug(ex.getMessage());
        errors.add(new FailureResponse(new CalculatorException(ErrorCode.HTTP_MESSAGE_NOT_READBLE)));
        return ResponseEntity.status(400).body(new FailuresResponse(errors));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CalculatorException.class)
    public ResponseEntity<FailuresResponse> handleCalculatorException(CalculatorException ex) {
        logger.debug(ex.getMessage());
        errors.add(new FailureResponse(ex));
        return ResponseEntity.status(400).body(new FailuresResponse(errors));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<FailuresResponse> handleRestClientException(RestClientException ex) {
        logger.debug(ex.getMessage());
        errors.add(new FailureResponse(new CalculatorException(ErrorCode.REST_CLIENT_EXCEPTION, ex.getMessage())));
        return ResponseEntity.status(400).body(new FailuresResponse(errors));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<FailuresResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        logger.debug(ex.getMessage());
        errors.add(new FailureResponse(new CalculatorException(ErrorCode.WRONG_ARGUMENT_TYPE, ex.getMessage())));
        return ResponseEntity.status(400).body(new FailuresResponse(errors));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<FailuresResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.debug(ex.getMessage());
        errors.add(new FailureResponse(new CalculatorException(ErrorCode.WRONG_ARGUMENT_TYPE, ex.getMessage())));
        return ResponseEntity.status(400).body(new FailuresResponse(errors));
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<FailuresResponse> handleThrowable(Throwable ex) {
        logger.debug(ex.getMessage());
        errors.add(new FailureResponse(new CalculatorException(ErrorCode.INTERNAL_SERVER_ERROR)));
        return ResponseEntity.status(500).body(new FailuresResponse(errors));
    }
}
