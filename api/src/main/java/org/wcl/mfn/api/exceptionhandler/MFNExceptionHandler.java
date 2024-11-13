package org.wcl.mfn.api.exceptionhandler;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.wcl.mfn.exceptions.validation.InvalidParameterException;

@RestControllerAdvice
public class MFNExceptionHandler {

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<String> handleApiException(final String errorId,
                                                                final InvalidParameterException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("%s : %s", errorId, ex.getMessage()));
    }
}
