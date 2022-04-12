package com.swcalendar.core.service;

import com.swcalendar.core.domain.entity.User;
import com.swcalendar.core.domain.entity.repository.UserRepository;
import com.swcalendar.core.dto.UserCreateReq;
import com.swcalendar.core.util.Encryptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final Encryptor bcryptEncryptor;
  private final UserRepository userRepository;

  @Transactional
  public User create(UserCreateReq req) {
    userRepository.findByEmail(req.getEmail())
        .ifPresent(u -> {
          throw new RuntimeException("cannot find user");
        });
    return userRepository.save(User.builder()
        .name(req.getName())
        .password(bcryptEncryptor.encrypt(req.getPassword()))
        .email(req.getEmail())
        .birthday(req.getBirthday())
        .build());
  }

  @Transactional
  public Optional<User> findPwMatchUser(String email, String password) {
/*
    return userRepository.findByEmail(email)
        .map(u -> bcryptEncryptor.isMatch(u.getPassword(), password) ? u : null);
*/
    // 위를 Strategy 패턴 사용해서 -> 객체지향스럽게 바꿔보자 + 유저테스트도 용이해짐
    return userRepository.findByEmail(email).map(u -> u.isMatch(bcryptEncryptor, password)? u : null);
  }

  public User getOrThrowById(Long id) {
    return userRepository.findById(id).orElseThrow(() -> new RuntimeException("no user."));
  }
}
