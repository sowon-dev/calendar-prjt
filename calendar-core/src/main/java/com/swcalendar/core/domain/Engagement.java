package com.swcalendar.core.domain;

import lombok.Getter;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
public class Engagement {
  @JoinColumn(name = "schedule_id")
  @ManyToOne
  private Schedule schedule;

  @JoinColumn(name = "attendee_id")
  @ManyToOne
  private User attendee;

  @Enumerated(EnumType.STRING)
  private RequestStatus requestStatus;

  public Engagement(Schedule eventSchedule, User attendee) {
    assert eventSchedule.getScheduleType() == ScheduleType.EVENT;
    this.schedule = eventSchedule;
    this.requestStatus = RequestStatus.REQUESTED;
    this.attendee = attendee;
  }
}
