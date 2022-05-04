package com.tien.amall.product.exception;

import com.tien.common.exception.BizCodeEnume;
import com.tien.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
  *@ClassName: AmallExceptionControllerAdvice
  *@Author: Acme Tien
  *@Date: 2022/5/3 16:41
  *@Version: v1.0
  *@Description: 集中处理所有异常
**/
@Slf4j
//@ResponseBody
//@ControllerAdvice(basePackages = "com.tien.amall.product.controller")
@RestControllerAdvice(basePackages = "com.tien.amall.product.controller")
public class AmallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {

        log.error("数据校验出现问题{}，异常类型{}", e.getMessage(), e.getClass());
        BindingResult result = e.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return R.error(BizCodeEnume.VALID_EXCEPTION.getCode(), BizCodeEnume.VALID_EXCEPTION.getMsg()).put("data", errorMap);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable) {

        return R.error(BizCodeEnume.UNKNOWN_EXCEPTION.getCode(), BizCodeEnume.UNKNOWN_EXCEPTION.getMsg());
    }
}
