package com.swcalendar.core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {
  private final Schedule schedule;

  public Event(Schedule schedule) {
    this.schedule = schedule;
  }
}
