package br.com.livelo.login.exceptions;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import br.com.livelo.login.constants.*;
import lombok.Getter;

@Getter
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1101390528006902187L;
	
	private String code;
    private String message;
    private String originalError;
    private List<String> details;
    
    public ExceptionResponse(ErrorCodes errorCode, String details) {
        this.code = errorCode.name();
        this.message = errorCode.getMessage();
        this.details = Collections.singletonList(details);
    }

    public ExceptionResponse(ErrorCodes errorCode, List<String> details) {
        this.code = errorCode.name();
        this.message = errorCode.getMessage();
        this.details = details;
    }
}

