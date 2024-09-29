package cnu.moksoriro.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
* 각종 에러코드 및 메세지 관리용
* */
@Getter
@AllArgsConstructor
public enum ResponseEnum {
    USER_JOIN_SUCCESS(200, "회원가입에 성공하였습니다."),
    USER_JOIN_FAIL(400, "다시 시도해주세요.");

    private final int code;
    private final String message;
}
