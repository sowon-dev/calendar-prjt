package com.swcalendar.core.domain;

public class Notification {
  private Schedule schedule;

  public Notification(Schedule schedule) {
    this.schedule = schedule;
  }

  public User getWriter() {
    return this.schedule.getWriter();
  }
}
