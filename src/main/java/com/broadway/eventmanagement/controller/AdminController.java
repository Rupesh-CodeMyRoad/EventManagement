package com.broadway.eventmanagement.controller;

import com.broadway.eventmanagement.model.Event;
import com.broadway.eventmanagement.model.EventType;
import com.broadway.eventmanagement.model.Teams;
import com.broadway.eventmanagement.pojo.EventPojo;
import com.broadway.eventmanagement.service.EventService;
import com.broadway.eventmanagement.service.EventTypeService;
import com.broadway.eventmanagement.service.TeamMemberService;
import com.broadway.eventmanagement.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @Autowired
    EventService eventService;
    @Autowired
    EventTypeService eventTypeService;

    @Autowired
    TeamService teamService;

    @Autowired
    TeamMemberService teamMemberService;

    @GetMapping("/index")
    public String indexPage() {
        return "admin/index";
    }

    @GetMapping("/addevent")
    public String addEvents(Model model) {
        model.addAttribute("eventType",eventTypeService.getAllEventType());
        System.out.println(eventTypeService.getAllEventType().size());
        return "admin/addevent";
    }

    @GetMapping("/viewevent")
    public String viewEvents(Model model) {
        model.addAttribute("eventList",eventService.allEvent());
        return "admin/viewevent";
    }

    @GetMapping("/viewteam")
    public String viewTeam(Model model)
    {
        model.addAttribute("teamList",teamMemberService.allTeamMembers());
        return "admin/viewteam";
    }

    @GetMapping("/editteam")
    public String editTeam()
    {

        return "admin/editteam";
    }

    @GetMapping("/edit/event/{id}")
    public String editEvent(@PathVariable("id") Integer id,Model model)
    {
        model.addAttribute("singleEvent",eventService.getSingleEvent(id));
        model.addAttribute("eventType",eventTypeService.getAllEventType());
        return "/admin/addevent";
    }
    @GetMapping("/delete/event/{id}")
    public String deleteEvent(@PathVariable("id") Integer id,Model model    )
    {
        model.addAttribute("eventList",eventService.allEvent());
        eventService.deleteEvent(id);
        return "admin/viewevent";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "admin/login";
    }




    //For Template
    @PostMapping("/addeventdata")
    public String addEventData(@ModelAttribute EventPojo eventPojo, Model model,@RequestParam Integer id)

    {

        log.info(eventPojo.toString());

        Teams teams =new Teams();
        teams.setTeamName(null);
         List<Teams> team=new ArrayList<>();
        team.add(teams);

//        EventType eventType=new EventType();
//        eventType.setEventType(null);


        EventType eventType=eventTypeService.getSingleEventType(id);
      Event event1=new Event(eventPojo.getEventId(),eventPojo.getEventName(),eventPojo.getEventDate(),eventPojo.getEventDescription(),eventPojo.getEventLocation(),team,eventType);

        if(eventService.saveEvent(event1)!=null)
        {

            model.addAttribute("message","data saved successfully");
        }
        else
        {
            model.addAttribute("message","failed to save data");
        }

        return "redirect:/admin/viewevent";
    }



}
