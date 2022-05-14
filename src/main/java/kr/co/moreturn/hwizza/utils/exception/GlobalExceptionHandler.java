package kr.co.moreturn.hwizza.utils.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/** 
* @packageName : kr.co.moreturn.hwizza.utils.exception 
* @fileName : GlobalExceptionHandler.java 
* @author : Gyuna Kim 
* @date : 2021.09.21 
* @description : 에러 감지를 위한 에러 핸들러
* =========================================================== 
* DATE              AUTHOR             NOTE
* ----------------------------------------------------------- 
* 2021.09.21        Gyuna Kim          최초 생성 
*/

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { HwizzaException.class })
    protected ResponseEntity<ErrorResponse> handleHwizzaException(HwizzaException e) {
        log.error("handleHwizzaException throw Exception : {}", e.getErrorCode());
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }
}
