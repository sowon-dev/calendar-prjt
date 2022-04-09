package core;

import com.swcalendar.core.domain.entity.User;
import com.swcalendar.core.util.Encryptor;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class UserTest {

  private final Encryptor alwayMatchEncryptor =  new Encryptor() {
    @Override
    public String encrypt(String origin) {
      return origin;
    }

    @Override
    public boolean isMatch(String origin, String hashed) {
      return true;
    }
  };

  @Test
  void isMatchTest(){
    final User u1 = new User("writer1", "test1@gmail", "1111", LocalDate.now());
    assertEquals(true, u1.isMatch(alwayMatchEncryptor, "aaaa"));

  }
}
