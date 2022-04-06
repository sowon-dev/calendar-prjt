package com.swcalendar.api.service;

import com.swcalendar.api.dto.LoginReq;
import com.swcalendar.api.dto.SignUpReq;
import com.swcalendar.core.domain.entity.User;
import com.swcalendar.core.dto.UserCreateReq;
import com.swcalendar.core.service.UserService;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor //서비스만들때 항상 넣으면 소스코드가 깔끔해지는 효과가 있음
public class LoginService {
  public final static String LOGIN_SESSION_KEY = "USER_ID";
  private final UserService userService; //로그인서비스와 유저서비스는 기능적으로 분리되는게 맞음. 회원가입은 UserService에서 해야함

  @Transactional
  public void signUp(SignUpReq signUpReq, HttpSession session) {
        /*
         1. UserService 에 create 요청 (이미 존재하는 유저 검증은 UserService 담당)
         2. session 에 담고 리턴
         */
    // SignUpReq을 쓰는 게 아니라 UserCreateReq를 써야함 why? SignUp이란 개념을 UserService가 알 필요가 없음
    final User user = userService.create(new UserCreateReq(signUpReq.getName(), signUpReq.getEmail(), signUpReq.getPassword(), signUpReq.getBirthday()));
    session.setAttribute(LOGIN_SESSION_KEY, user.getId()); // 세션에 유저정보를 value에 담음
  }

  @Transactional
  public void login(LoginReq loginReq, HttpSession session) {
        /*
        세션 값이 있으면 리턴
        없으면 비밀번호 체크 후 로그인
         */
    final Long userId = (Long) session.getAttribute(LOGIN_SESSION_KEY);
    if (userId != null) {
      return;
    }
    final Optional<User> user = userService.findPwMatchUser(loginReq.getEmail(), loginReq.getPassword());
    if (user.isPresent()) {
      session.setAttribute(LOGIN_SESSION_KEY, user.get().getId());
    } else {
      throw new RuntimeException("password or email not match");
    }
  }

  public void logout(HttpSession session) {
        /*
        세션 제거
         */
    session.removeAttribute(LOGIN_SESSION_KEY);
  }

}
