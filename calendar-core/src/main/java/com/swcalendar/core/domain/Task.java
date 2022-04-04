package com.swcalendar.core.domain;
import com.swcalendar.core.domain.entity.Schedule;
import com.swcalendar.core.domain.entity.User;

public class Task {

  private Schedule schedule;

  public Task (Schedule schedule) {
    this.schedule = schedule;
  }

  public User getWriter() {
    return this.schedule.getWriter();
  }
}