package com.jsh.pass.passweb.controller.pass;

import com.jsh.pass.passweb.service.pass.Pass;
import com.jsh.pass.passweb.service.pass.PassService;
import com.jsh.pass.passweb.service.user.User;
import com.jsh.pass.passweb.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/passes")
public class PassViewController {
    private final UserService userService;
    private final PassService passService;

    public PassViewController(UserService userService, PassService passService) {
        this.userService = userService;
        this.passService = passService;
    }

    @GetMapping
    public ModelAndView getPasses(@RequestParam("userId") String userId) {
        ModelAndView modelAndView = new ModelAndView();

        final List<Pass> passes = passService.getPasses(userId);
        final User user = userService.getUser(userId);
        log.info("조회된 유저 : {}", user.getUserName());
        int idx = 0;
        for(Pass pass : passes){
            log.info("[{}] packageName:{}",++idx,pass.getPackageName());
        }
        modelAndView.addObject("passes", passes);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("pass/index");

        return modelAndView;
    }

}