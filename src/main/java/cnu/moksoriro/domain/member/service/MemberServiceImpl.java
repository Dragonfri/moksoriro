package cnu.moksoriro.domain.member.service;

import cnu.moksoriro.domain.member.Role;
import cnu.moksoriro.domain.member.RoleName;
import cnu.moksoriro.domain.member.controller.dto.request.RegisterDto;
import cnu.moksoriro.domain.member.repo.MemberRepository;
import cnu.moksoriro.domain.member.repo.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService{
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;

    @Override
    public void register(RegisterDto registerDto){
        String encodedPw = passwordEncoder.encode(registerDto.getPassword());
        Role role = roleRepository.findByName(RoleName.ROLE_USER);

        memberRepository.save(registerDto.toMember(encodedPw, role));
    }
}
