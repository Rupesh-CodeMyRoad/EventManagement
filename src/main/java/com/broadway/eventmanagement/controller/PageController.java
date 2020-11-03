package com.broadway.eventmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController  {


    @GetMapping("/index")
    public String indexPage()
    {
        return "index";
    }

    @GetMapping("/events")
    public String eventPage()
    {
        return "events";
    }
    @GetMapping("/contact")
    public String contactPage()
    {
        return "contact";
    }
    @GetMapping("/speakers")
    public String speakersPage()
    {
        return "speakers";
    }
    @GetMapping("/news")
    public String newsPage()
    {
        return "newspage";
    }


}
