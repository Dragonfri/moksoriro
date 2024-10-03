package cnu.moksoriro.global.security;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String username;
    private String password;
}
