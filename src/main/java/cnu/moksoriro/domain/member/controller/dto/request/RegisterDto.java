package cnu.moksoriro.domain.member.controller.dto.request;

import cnu.moksoriro.domain.member.Member;
import cnu.moksoriro.domain.member.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String memberId;
    private String password;
    private String memberName;
    public Member toMember(String password, Role role){
        return Member.builder()
                .memberId(memberId)
                .memberName(memberName)
                .password(password)
                .roles(List.of(role))
                .build();
    }
}
