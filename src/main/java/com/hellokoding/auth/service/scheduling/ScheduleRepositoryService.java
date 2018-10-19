package com.hellokoding.auth.service.scheduling;

import com.hellokoding.auth.model.Schedule;
import com.hellokoding.auth.model.User;

import java.util.List;

public interface ScheduleRepositoryService {
    List<Schedule> searchUserSchedules(User user);
}
