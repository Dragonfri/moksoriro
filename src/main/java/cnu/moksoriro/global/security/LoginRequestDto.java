package cnu.moksoriro.global.security;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String memberId;
    private String password;
}
