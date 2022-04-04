package com.swcalendar.core.domain.entity;

import com.swcalendar.core.domain.Event;
import com.swcalendar.core.domain.Notification;
import com.swcalendar.core.domain.ScheduleType;
import com.swcalendar.core.domain.Task;
import java.time.LocalDate;
import java.time.Period;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder(access = AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "schedules")
public class Schedule extends BaseEntity {

  private LocalDateTime startAt;
  private LocalDateTime endAt;
  private String title;
  private String description;

  @JoinColumn(name = "writer_id")
  @ManyToOne
  private User writer;

  @Enumerated(EnumType.STRING)
  private ScheduleType scheduleType;

  public static Schedule event(String title,
      String description, LocalDateTime startAt,
      LocalDateTime endAt, User writer) {
    return Schedule.builder()
        .startAt(startAt)
        .endAt(endAt)
        .title(title)
        .description(description)
        .writer(writer)
        .scheduleType(ScheduleType.EVENT)
        .build();
  }

  public static Schedule task(String title, String description, LocalDateTime taskAt,
      User writer) {
    return Schedule.builder()
        .startAt(taskAt)
        .title(title)
        .description(description)
        .writer(writer)
        .scheduleType(ScheduleType.TASK)
        .build();
  }

  public static Schedule notification(String title, LocalDateTime notifyAt, User writer) {
    return Schedule.builder()
        .startAt(notifyAt)
        .title(title)
        .writer(writer)
        .scheduleType(ScheduleType.NOTIFICATION)
        .build();
  }

  public Task toTask() {
    return new Task(this);
  }

  public Event toEvent() {
    return new Event(this);
  }

  public Notification toNotification() {
    return new Notification(this);
  }

  @Override
  public String toString() {
    return "Schedule{" +
        "id=" + super.getId().toString() +
        ", startAt=" + startAt +
        ", endAt=" + endAt +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", writer=" + writer +
        ", scheduleType=" + scheduleType +
        '}';
  }
}
