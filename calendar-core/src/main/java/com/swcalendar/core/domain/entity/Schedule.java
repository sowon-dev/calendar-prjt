package com.swcalendar.core.domain.entity;

import com.swcalendar.core.domain.ScheduleType;
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

}
