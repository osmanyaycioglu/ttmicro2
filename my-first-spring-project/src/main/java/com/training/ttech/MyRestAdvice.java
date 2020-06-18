package com.training.ttech;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyRestAdvice {

    @ExceptionHandler(RestException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ErrorObj handle(final RestException re) {
        ErrorObj errorObjLoc = new ErrorObj("IT",
                                            "CRM",
                                            "XYZ",
                                            re.getMsg());
        return errorObjLoc;
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle2(final IllegalStateException re) {
        ErrorObj errorObjLoc = new ErrorObj("IT",
                                            "CRM",
                                            "XYZ",
                                            re.getMessage());
        return errorObjLoc;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorObj handle3(final IllegalStateException re) {
        ErrorObj errorObjLoc = new ErrorObj("IT",
                                            "CRM",
                                            "XYZ",
                                            re.getMessage());
        return errorObjLoc;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle4(final MethodArgumentNotValidException re) {
        ErrorObj errorObjLoc = new ErrorObj("IT",
                                            "CRM",
                                            "XYZ",
                                            "Validation Exception");
        BindingResult bindingResultLoc = re.getBindingResult();
        List<ObjectError> allErrorsLoc = bindingResultLoc.getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            ErrorObj innerErrorObjLoc = new ErrorObj("IT",
                                                     "CRM",
                                                     "XYZ",
                                                     objectErrorLoc.getCode()
                                                            + " : "
                                                            + objectErrorLoc.getDefaultMessage());
            errorObjLoc.addInnerError(innerErrorObjLoc);
        }
        return errorObjLoc;
    }

}
