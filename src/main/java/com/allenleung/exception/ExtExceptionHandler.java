package com.allenleung.exception;

import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常统一处理
 * @author 890170
 * @date 2017-03-07 10:54
 */
public class ExtExceptionHandler implements HandlerExceptionResolver {
    private static final Logger log = Logger.getLogger(ExtExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ex", ex);

        log.info("产生异常名称: " + ex.getClass().getSimpleName());
//        String viewName = ClassUtils.getShortName(ex.getClass());
//        log.info("产生异常名称: " + ex.getClass().getName());
//        log.info("产生异常名称: " + viewName);

        // 根据不同错误转向不同页面
        return new ModelAndView("exception/" + ex.getClass().getSimpleName(), model);
        /*if (ex instanceof BusinessException) {
            return new ModelAndView("exception/exception-business", model);
        } else if (ex instanceof ParameterException) {
            return new ModelAndView("exception/exception-parameter", model);
        } else if( ex instanceof DataIntegrityViolationException) {
            return new ModelAndView("exception/exception-dataintegrityviolation", model);
        } else {
            return new ModelAndView("exception/exception", model);
        }*/
    }
}
