package br.com.socialmeli.dtos;

import br.com.socialmeli.exceptions.AbstractGeneralException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class ErrorInfoDTO {

    public final String url;

    public final String message;

    public final long timeStamp;

    public final String httpMethod;

    @JsonIgnore
    public HttpStatus statusCode;

    public Object body;

    public ErrorInfoDTO(String url, String message, long timeStamp, String httpMethod, Object request, HttpStatus statusCode) {
        this.url = url;
        this.message = message;
        this.timeStamp = timeStamp;
        this.httpMethod = httpMethod;
        this.body = request;
        this.statusCode = statusCode;
    }

    private ErrorInfoDTO(HttpServletRequest req, Exception ex) {
        this.url = req.getRequestURI();
        this.httpMethod = req.getMethod();
        this.message = ex.getMessage();
        this.timeStamp = new Date().getTime();
    }

    public void setObject(Object request) {
        this.body = request;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public static ErrorInfoDTO create(HttpServletRequest req, Exception ex) {
        ErrorInfoDTO errorInfo = new ErrorInfoDTO(req, ex);

        if (ex instanceof AbstractGeneralException) {
            errorInfo.setObject(((AbstractGeneralException) ex).requestData);
            errorInfo.setStatusCode(((AbstractGeneralException) ex).httpStatus);
        }

        return errorInfo;
    }

}
