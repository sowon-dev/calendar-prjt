package core.util;

import com.swcalendar.core.util.BCryptEncryptor;
import com.swcalendar.core.util.Encryptor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BCryptEncryptorTest {

  @Test
  void test(){
    final String oriPwd = "origin";
    final Encryptor encryptor = new BCryptEncryptor();
    final String hash = encryptor.encrypt(oriPwd);

    assertTrue(encryptor.isMatch(oriPwd, hash));

    final String oriPwd2 = "origin2";
    assertFalse(encryptor.isMatch(oriPwd2, hash));
  }
}
