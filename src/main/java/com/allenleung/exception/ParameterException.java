package com.allenleung.exception;

/**
 * 参数异常
 * @author 890170
 * @date 2017-03-07 10:57
 */
public class ParameterException extends RuntimeException {

    /** serialVersionUID */
    private static final long serialVersionUID = 6417641452178955756L;

    public ParameterException() {
        super();
    }

    public ParameterException(String message) {
        super(message);
    }

    public ParameterException(Throwable cause) {
        super(cause);
    }

    public ParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
