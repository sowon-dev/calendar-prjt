package com.swcalendar.core.domain.entity.repository;

import com.swcalendar.core.domain.entity.Schedule;
import com.swcalendar.core.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
