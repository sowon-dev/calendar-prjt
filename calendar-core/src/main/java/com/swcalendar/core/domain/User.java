package com.swcalendar.core.domain;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class User {
  private String name;
  private String email;
  private String password; // hashed
  private LocalDate birthday;

  @Builder
  public User(String name, String email, String password, LocalDate birthday) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.birthday = birthday;
  }
}
