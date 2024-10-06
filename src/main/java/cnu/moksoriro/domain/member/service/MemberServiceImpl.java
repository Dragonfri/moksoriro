package cnu.moksoriro.domain.member.service;

import cnu.moksoriro.domain.member.Role;
import cnu.moksoriro.domain.member.RoleName;
import cnu.moksoriro.domain.member.controller.dto.request.RegisterDto;
import cnu.moksoriro.domain.member.repo.MemberRepository;
import cnu.moksoriro.domain.member.repo.RoleRepository;
import cnu.moksoriro.global.exception.ResponseEnum;
import cnu.moksoriro.global.exception.handler.CustomApiException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService{
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final static Logger log = LoggerFactory.getLogger(MemberServiceImpl.class)

    @Override
    public void register(RegisterDto registerDto){
        String encodedPw = passwordEncoder.encode(registerDto.getPassword());
        if (memberRepository.existsById(registerDtogetMemberId())) {
            throw new CustomApiException(ResponseEnum.USER_JOIN_DUPLICATE);
        }
        Role role = roleRepository.findByName(RoleName.ROLE_USER);
        memberRepository.save(registerDto.toMember(encodedPw, role));
    }

    @Override
    public void saveRole() {
        roleRepository.save(new Role(RoleName.ROLE_USER));
        roleRepository.save(new Role(RoleName.ROLE_ADMIN));
    }
}
