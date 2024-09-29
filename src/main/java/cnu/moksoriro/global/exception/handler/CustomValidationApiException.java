package cnu.moksoriro.global.exception.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@RequiredArgsConstructor
public class CustomValidationApiException extends RuntimeException {
    //객채를 구분하기 위한 아이디
    private static final long serialVersionUID = 1L;

    private Map<String, String> errorMap;

    public CustomValidationApiException(String message){
        super(message);
    }

    public CustomValidationApiException(String message, Map<String, String> errorMap){
        super(message);
        this.errorMap = errorMap;
    }

}
