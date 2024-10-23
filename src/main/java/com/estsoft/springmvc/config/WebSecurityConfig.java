package com.estsoft.springmvc.config;

import com.estsoft.springmvc.Service.UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration//스프링 시큐리티 설정
public class WebSecurityConfig {

    private UserDetailService userDetailService;

    public WebSecurityConfig (UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }
    //ignore처리. bean으로 설정하지 않고 class하나ㅏ 생성해서 작성할 수 도 있음.
    @Bean
    public  WebSecurityCustomizer ignore(){
        return webSecurity -> webSecurity.ignoring()
                //.requestMatchers(toH2Console())
                .requestMatchers("/static/**","/swagger_ui/**", "v3/api-docs/**","/swagger-ui.html");
    }
    //패스워드 암호화 방식
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                custom -> custom.requestMatchers("/login","/signup","/user").permitAll()
                        //.requestMatchers("/articles/**").hasAuthority("ADMIN")//Role_admin
                        .anyRequest().permitAll()
                        //.anyRequest().authenticated()
                )
                //인증,인가 설정부분
                //.requestMatchers("/login","signup","/user").permitAll()
                //.requestMatchers("/api/external").hasRole("admin")
                //.anyRequest().authenticated()
                //form 기반 로그인 설정.
                .formLogin(custom -> custom.loginPage("/login")
                        .defaultSuccessUrl("/articles",true))//로그인 설정
                //.loginPage("/login")
                //.defaultSuccessUrl("/articles")
                .logout(custom -> custom.logoutSuccessUrl("/login").invalidateHttpSession(true))//로그아웃 설정
                //.logoutSuccessUrl("/login")
                //.invalidateHttpSession(true)
                .csrf(custom -> custom.disable())
                //.disable()//csrf비활성화
                .build();
    }

/*    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailService)  // 8) 사용자 정보 서비스 설정
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .build();
    }*/
}
