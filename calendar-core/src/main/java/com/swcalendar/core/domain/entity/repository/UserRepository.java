package com.swcalendar.core.domain.entity.repository;

import com.swcalendar.core.domain.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  // 쿼리메서드: JPA에서 컨벤션에 맞춰 메서드명을 작성하면 실제로 여기에 맞는 쿼리를 자동으로 만들어준다.
  Optional<User> findByEmail(String email);
}
