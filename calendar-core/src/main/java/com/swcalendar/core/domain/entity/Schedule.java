package com.swcalendar.core.domain.entity;

import com.swcalendar.core.domain.Event;
import com.swcalendar.core.domain.Notification;
import com.swcalendar.core.domain.ScheduleType;
import com.swcalendar.core.domain.Task;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder(access = AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@Table(name = "schedules")
@Entity
public class Schedule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDateTime startAt;
  private LocalDateTime endAt;
  private String title;
  private String description;

  @JoinColumn(name = "writer_id")
  @ManyToOne
  private User writer;

  // OnnToMany 속성은 잘 사용하지않음
  @Enumerated(EnumType.STRING)
  private ScheduleType scheduleType;

  public static Schedule event(Long id, LocalDateTime startAt, LocalDateTime endAt, String title, String description, User writer, ScheduleType scheduleType){
    return Schedule.builder()
        .description(description)
        .scheduleType(scheduleType.EVENT)
        .title(title)
        .endAt(endAt)
        .startAt(startAt)
        .writer(writer)
        .build();
  }

//  public Task toTask(){
//    return new Task(this);
//  }

  public Event toEvent(){
    return new Event(this);
  }

  public Notification toNotification(){
    return new Notification(this);
  }

}
