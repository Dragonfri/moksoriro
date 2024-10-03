package cnu.moksoriro.global.security.auth;

import cnu.moksoriro.domain.member.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {

    private Member user;

    public PrincipalDetails(Member user){
        this.user = user;
    }

    public Member getUser(){
        return user;
    }

    @Override
    public String getPassword(){
        return user.getPassword();
    }

    @Override
    public String getUsername(){
        return user.getMemberId();
    }
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new
                ArrayList<GrantedAuthority>();
        user.getRoles().forEach(r -> {
            authorities.add(() ->{return String.valueOf(r);});
        });
        return authorities;
    }
}
