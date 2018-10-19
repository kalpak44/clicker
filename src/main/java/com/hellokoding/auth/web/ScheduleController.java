package com.hellokoding.auth.web;

import com.hellokoding.auth.model.Schedule;
import com.hellokoding.auth.model.User;
import com.hellokoding.auth.repository.ScheduleRepository;
import com.hellokoding.auth.service.SecurityService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.service.scheduling.ScheduleRepositoryService;
import com.hellokoding.auth.service.scheduling.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class ScheduleController {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleController.class);
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ScheduleRepositoryService scheduleRepositoryService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/scheduling"}, method = RequestMethod.GET)
    public String scheduling(Model model) {
        String loggedInUsername = securityService.findLoggedInUsername();
        if(loggedInUsername != null){
            User currentUser = userService.findByUsername(loggedInUsername);
            if(currentUser != null){
                List<Schedule> schedules = scheduleRepositoryService.searchUserSchedules(currentUser);
                model.addAttribute("schedules", schedules);
            }
        }
        scheduleService.schedule(()->logger.info("test scheduling task"), 1, TimeUnit.SECONDS);
        return "scheduling";
    }

    @RequestMapping(value = {"/scheduling"}, method = RequestMethod.POST)
    public String create(@ModelAttribute Schedule schedule) {
        logger.info(schedule.getName());
        return "scheduling";
    }
}
