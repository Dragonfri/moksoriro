package cnu.moksoriro.domain.member.controller;

import cnu.moksoriro.domain.member.controller.dto.request.RegisterDto;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cnu.moksoriro.domain.member.controller.MemberController.REST_URL_MEMBER;

@RequiredArgsConstructor
@RestController
@RequestMapping(REST_URL_MEMBER)
public class MemberController {
    public  static final String REST_URL_MEMBER = "api/mvp/member";

    @PostMapping("/register")
    @ApiOperation(value = "회원가입")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberId", value = "member 고유한 id"),
            @ApiImplicitParam(name = "memberName", value = "member 닉네임")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "success"),
            @ApiResponse(code = 400, message = "wrong request"),
            @ApiResponse(code = 500, message = "server error")
    })
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto){
        return null;
    }
}
