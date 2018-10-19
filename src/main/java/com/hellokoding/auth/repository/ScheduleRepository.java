package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.Schedule;
import com.hellokoding.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByUser(User user);
}
