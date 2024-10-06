package cnu.moksoriro.global.security;

import cnu.moksoriro.domain.member.Member;
import cnu.moksoriro.domain.member.repo.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {
    private final MemberRepository memberRepository;

    private final Logger logger =
            LoggerFactory.getLogger(UserDetailServiceImpl.class);

    @Override
    public CustomUser loadUserByUsername(String memberId) throws
            UsernameNotFoundException {
        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(() -> new UsernameNotFoundException("해당 ID를 가진 회원은 DB에 존재하지 않음"));
        logger.info("멤버가 존재함: {}", member.getMemberId());
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        member.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName().name()));
        });

        return new CustomUser(member.getMemberId(), member.getPassword(),
                authorities, member.getMemberName());
    }
}
