package green.belka.backend.controller;

import green.belka.backend.model.ResponseData;
import green.belka.backend.model.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    ResponseData handleException(RuntimeException e){
        log.error("", e.getMessage());
        return new ResponseData<>(ResultCode.ERROR, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseData handleException(Exception e){
        log.error("", e.getMessage());
        return new ResponseData<>(ResultCode.ERROR, e.getMessage());
    }
}
