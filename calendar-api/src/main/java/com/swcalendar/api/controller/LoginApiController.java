package com.swcalendar.api.controller;

import com.swcalendar.api.dto.LoginReq;
import com.swcalendar.api.dto.SignUpReq;
import com.swcalendar.api.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class LoginApiController {
  private final LoginService loginService;

  // HttpSession은 프레임워크가 자동으로 가지고온다.

  @PostMapping("/api/sign-up")
  public ResponseEntity<Void> login(@RequestBody SignUpReq signUpReq, HttpSession httpSession) {
    loginService.signUp(signUpReq, httpSession);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/api/login")
  public ResponseEntity<Void> login(@RequestBody LoginReq loginReq, HttpSession httpSession) {
    loginService.login(loginReq, httpSession);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/api/logout")
  public ResponseEntity<Void> logout(HttpSession httpSession) {
    loginService.logout(httpSession);
    return ResponseEntity.ok().build();
  }
}
