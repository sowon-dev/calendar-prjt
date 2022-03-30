package com.swcalendar.core.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "engagements")
@Getter
@NoArgsConstructor
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JoinColumn(name = "schedule_id")
  @ManyToOne
  private Schedule schedule;

  @JoinColumn(name = "attendee_id")
  @ManyToOne
  private User attendee;

  @Enumerated(EnumType.STRING)
  private RequestStatus status;

  private LocalDateTime createdAt = LocalDateTime.now();
}
