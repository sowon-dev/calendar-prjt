package com.swcalendar.core.domain.entity;

import com.swcalendar.core.domain.RequestStatus;
import com.swcalendar.core.domain.ScheduleType;
import lombok.Getter;
import javax.persistence.*;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "engagements")
@Entity
public class Engagement extends BaseEntity {

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
