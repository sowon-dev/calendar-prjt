package com.swcalendar.api.service;
import com.swcalendar.api.dto.AuthUser;
import com.swcalendar.api.dto.TaskCreateReq;
import com.swcalendar.core.domain.entity.Schedule;
import com.swcalendar.core.domain.entity.repository.ScheduleRepository;
import com.swcalendar.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TaskService {
  private final UserService userService;
  private final ScheduleRepository scheduleRepository;

  @Transactional
  public void create(TaskCreateReq req, AuthUser authUser) {
    final Schedule taskSchedule = Schedule.task(req.getTitle(), req.getDescription(), req.getTaskAt(), userService.getOrThrowById(authUser.getId()));
    scheduleRepository.save(taskSchedule);
  }

}
