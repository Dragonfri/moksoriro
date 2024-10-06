package cnu.moksoriro.global.security;


import cnu.moksoriro.domain.member.repo.MemberRepository;
import cnu.moksoriro.global.security.jwt.JwtAuthenticationFilter;
import cnu.moksoriro.global.security.jwt.JwtAuthorizationFilter;
import cnu.moksoriro.global.security.jwt.JwtConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity //시큐리티 활성화 -> 기본 스프링 필터체인에 등록
@EnableConfigurationProperties(JwtConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MemberRepository memberRepository;
    private final CorsConfig corsConfig;
    private final JwtConfig jwtConfig;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public SecurityConfig(MemberRepository memberRepository, CorsConfig corsConfig,
                          JwtConfig jwtConfig, UserDetailsService userDetailsService) {
        this.memberRepository = memberRepository;
        this.corsConfig = corsConfig;
        this.jwtConfig = jwtConfig;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter customAuthenticationFilter = new
                JwtAuthenticationFilter(authenticationManager(),
                jwtConfig);
        customAuthenticationFilter.setUsernameParameter("memberId");
        customAuthenticationFilter.setPasswordParameter("password");
        customAuthenticationFilter.setFilterProcessUrl("/api/login");

        http
                .addFilter(corsConfig.corsFilter())
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .addFilter(customAuthenticationFilter)
                .addFilter(new
                        JwtAuthorizationFilter(authenticationManager(), memberRepository,
                        jwtConfig))
                .authorizeRequests()
                .antMatchers("/api/mvp/user/**")
                .access("hasRole('ROLE_USER')")
                .anyRequest().permitAll();
    }
}
