package com.broadway.eventmanagement.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;


@Controller
public class EventAndTeamController {

    @GetMapping("/saveteamevent/{eventId}")
    public String saveteamevent(@PathVariable Integer eventId){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        Principal principal = (Principal) authentication.getPrincipal();
        principal.getName();


    }
    //TODO Get User ID and Drop Down selected while editing team.
}
