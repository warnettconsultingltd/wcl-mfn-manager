package org.wcl.mfn.api.exceptionhandler;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.wcl.mfn.exceptions.validation.InvalidParameterException;

@RestControllerAdvice
public class MFNExceptionHandler {

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<ExceptionResponse> handleApiException(final String errorId,
                                                                final InvalidParameterException ex) {
        return new ResponseEntity<>(new ExceptionResponse(errorId,ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
