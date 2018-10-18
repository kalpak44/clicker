package com.hellokoding.auth.web;

import com.hellokoding.auth.service.scheduling.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.concurrent.TimeUnit;

@Controller
public class ScheduleController {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleController.class);
    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value = {"/scheduling"}, method = RequestMethod.GET)
    public String scheduling(Model model) {
        scheduleService.schedule(()->logger.info("test scheduling task"), 1, TimeUnit.SECONDS);
        return "scheduling";
    }
}
