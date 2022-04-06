package com.swcalendar.core.domain.entity.repository;

import com.swcalendar.core.domain.entity.Engagement;
import com.swcalendar.core.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngagementRepository  extends JpaRepository<Engagement, Long> {

}
