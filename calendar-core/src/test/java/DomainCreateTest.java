import com.swcalendar.core.domain.Event;
import com.swcalendar.core.domain.Schedule;
import com.swcalendar.core.domain.ScheduleType;
import com.swcalendar.core.domain.User;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DomainCreateTest {

  @Test
  void eventCreate(){
    final User u1 = new User("writer1", "test1@gmail", "1111", LocalDate.now());
    final User u2 = new User("reader1", "test2@gmail", "1111", LocalDate.now());
    final Event e = new Event(new Schedule(LocalDateTime.now(), LocalDateTime.now(), "제목", "설명", u1, ScheduleType.EVENT));
    assertEquals(e.getSchedule().getWriter().getName(), "writer1");
  }

}
