package com.swcalendar.core.service;

import com.swcalendar.core.domain.entity.User;
import com.swcalendar.core.domain.entity.repository.UserRepository;
import com.swcalendar.core.dto.UserCreateReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  @Transactional
  public User create(UserCreateReq req) {

    return userRepository.save(User.builder()
        .name(req.getName())
        .password(req.getPassword())
        .email(req.getEmail())
        .birthday(req.getBirthday())
        .build());
  }

  @Transactional
  public Optional<User> findPwMatchUser(String email, String password) {
    return null;
  }
}
