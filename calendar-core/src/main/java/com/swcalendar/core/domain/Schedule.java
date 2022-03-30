package com.swcalendar.core.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class Schedule {
  private LocalDateTime startAt;
  private LocalDateTime endAt;
  private String title;
  private String description;

  @JoinColumn(name = "writer_id")
  @ManyToOne
  private User writer;

  @Enumerated(EnumType.STRING)
  private ScheduleType scheduleType;

}
