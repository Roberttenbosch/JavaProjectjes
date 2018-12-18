package com.simple.appbackend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandlingControllerAdvice
{
    protected Logger logger;

    public GlobalExceptionHandlingControllerAdvice() {
        logger = LoggerFactory.getLogger(getClass());
    }

    /**
     * Demonstrates how to take total control - setup a com.simple.appbackend.model, add useful
     * information and return the "support" view name. This method explicitly
     * creates and returns
     *
     * @param req
     *            Current HTTP request.
     * @param exception
     *            The com.simple.appbackend.exception thrown - always {@link SupportInfoException}.
     * @return The com.simple.appbackend.model and view used by the DispatcherServlet to generate
     *         output.
     * @throws Exception
     */
    @ExceptionHandler(SupportInfoException.class)
    public ModelAndView handleSupportInfoError(HttpServletRequest req, Exception exception)
            throws Exception {

        // Rethrow annotated exceptions or they will be processed here instead.
        if (AnnotationUtils.findAnnotation(exception.getClass(),
                ResponseStatus.class) != null)
            throw exception;

        logger.error("Request: " + req.getRequestURI() + " raised " + exception);

        ModelAndView mav = new ModelAndView();
        mav.addObject("ex", exception);
        mav.addObject("url", req.getRequestURL());
        mav.addObject("timestamp", new Date().toString());
        mav.addObject("status", 500);
        mav.addObject("stacktrace", exception.getStackTrace());

        mav.setViewName("support");
        return mav;
    }

    @ExceptionHandler(NullPointerException.class)
    public ModelAndView handleError(HttpServletRequest req, Exception exception)
            throws Exception {

        // Rethrow annotated exceptions or they will be processed here instead.
        if (AnnotationUtils.findAnnotation(exception.getClass(),
                ResponseStatus.class) != null)
            throw exception;

        logger.error("Request: " + req.getRequestURI() + " raised " + exception);

        ModelAndView mav = new ModelAndView();
        mav.addObject("ex", exception);
        mav.addObject("url", req.getRequestURL());
        mav.addObject("timestamp", new Date().toString());
        mav.addObject("status", 500);
        mav.addObject("stacktrace", exception.getStackTrace());
        mav.addObject("stacktrace1", exception.toString());
        mav.setViewName("error");
        return mav;
    }
}
