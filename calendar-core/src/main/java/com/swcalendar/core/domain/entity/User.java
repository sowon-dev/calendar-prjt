package com.swcalendar.core.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User extends BaseEntity {
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
