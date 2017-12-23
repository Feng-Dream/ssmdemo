package com.zking.ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义全局异常处理器
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    /**
     * @param request  请求
     * @param response 响应
     * @param handler  handler就是处理器适配器执行Handler对象(只有method)
     * @param ex       系统抛出的异常
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        //解析出异常类型

        //如果该异常类型是系统自定义的异常，直接取出异常信息，在错误页面展示
//        String message = null;
//        if (ex instanceof CustomException) {
//            message = ((CustomException) ex).getMessage();
//        } else {
//            //如果该异常类型不是系统自定义的异常，构造一个自定义的异常类型（信息为"信息为未知错误"）
//            message = "未知错误";
//        }

        //上边代码变为
        CustomException customException = null;
        if (ex instanceof CustomException) {
            customException = (CustomException) ex;
        } else {
            customException = new CustomException("未知错误");
        }
        //错误信息
        String message = customException.getMessage();

        ModelAndView modelAndView = new ModelAndView();
        //将错误信息传到页面
        modelAndView.addObject("message", message);
        //指向错误页面
        modelAndView.setViewName("common/error");
        return modelAndView;
    }
}
