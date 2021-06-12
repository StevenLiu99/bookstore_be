package com.lwt.bookstore_be.handler;

import com.lwt.bookstore_be.entity.ResultBean;
import com.lwt.bookstore_be.exception.MyException;
import net.sf.json.JSONException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.ParseException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
    public ResultBean handleMyException(MyException e){
        return ResultBean.error(e.getCode(),e.getMsg());
    }

    @ExceptionHandler
    public ResultBean handleParseException(ParseException e){
        return ResultBean.error(2,"日期格式错误");
    }

    @ExceptionHandler
    public ResultBean handleNumberFormatException(NumberFormatException e){
        return ResultBean.error(3,"参数错误");
    }

    @ExceptionHandler
    public ResultBean handleMissingServletRequestParameterException(MissingServletRequestParameterException e){
        return ResultBean.error(1,"缺少参数");
    }//
    @ExceptionHandler
    public ResultBean handleJSONException(JSONException e){
        return ResultBean.error(8,"body格式错误");
    }
    @ExceptionHandler
    public ResultBean handleNullPointerException(NullPointerException e){
        return ResultBean.error(9,"null错误");
    }
    @ExceptionHandler
    public ResultBean handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        return ResultBean.error(11,"请求方法错误");
    }
}
