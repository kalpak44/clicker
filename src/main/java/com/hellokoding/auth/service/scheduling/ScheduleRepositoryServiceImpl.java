package com.hellokoding.auth.service.scheduling;

import com.hellokoding.auth.model.Schedule;
import com.hellokoding.auth.model.User;
import com.hellokoding.auth.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ScheduleRepositoryServiceImpl implements ScheduleRepositoryService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> searchUserSchedules(User user) {
        List<Schedule> userSchedules = scheduleRepository.findByUser(user);
        return userSchedules.isEmpty() ? Collections.emptyList() : userSchedules;
    }
}
