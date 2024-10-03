package cnu.moksoriro.global.security.auth;


import cnu.moksoriro.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {

        Member member = memberRepository.findByMemberId(username);

        return new PrincipalDetails(member);
    }
}
