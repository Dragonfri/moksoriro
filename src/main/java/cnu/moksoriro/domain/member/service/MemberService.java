package cnu.moksoriro.domain.member.service;

import cnu.moksoriro.domain.member.controller.dto.request.RegisterDto;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    void register(RegisterDto registerDto);

    void saveRole();
}
