package cnu.moksoriro.global.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;

/*Spring Security의 User 클래스를 상속받아서 사용
* 가장 기본적인 username, password, authority를 받도록 설계
* CustomUser 클래스를 이용하여 로그인된 사용자의 추가정보 관리에 용이
* */
public class CustomUser extends User {
    private String memberName;

    public CustomUser(String username, String password,
                      Collection<? extends GrantedAuthority> authorities,
                      String memberName){
        super(username, password, authorities);
        this.memberName = memberName;
    }

    public String getMemberName(){
        return memberName;
    }
}
