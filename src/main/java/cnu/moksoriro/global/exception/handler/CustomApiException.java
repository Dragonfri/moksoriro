package cnu.moksoriro.global.exception.handler;

import cnu.moksoriro.global.exception.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomApiException extends RuntimeException{
    private final ResponseEnum responseEnum;
}
