package com.broadway.eventmanagement.controller;


import com.broadway.eventmanagement.model.Event;
import com.broadway.eventmanagement.model.EventUser;
import com.broadway.eventmanagement.model.Teams;
import com.broadway.eventmanagement.pojo.EventUserPojo;
import com.broadway.eventmanagement.pojo.Response;
import com.broadway.eventmanagement.service.EventService;
import com.broadway.eventmanagement.service.EventUserService;
import com.broadway.eventmanagement.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.TabExpander;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/v1")

public class AllRestController {
    @Autowired
    EventUserService eventUserService;
    @Autowired
    EventService eventService;
    @Autowired
    TeamService teamService;

    @PostMapping ("/addeventuser")
    public ResponseEntity<?> addEventUser(@RequestBody EventUser eventUser)
    {

        if(eventUserService.saveEventUser(eventUser)!=null)
        {
            Response response=new Response(HttpStatus.OK.value(),"saved",new Date(),eventUser);
            return new ResponseEntity<>(response,null, HttpStatus.OK);
        }
        else
        {
            {
                Response response=new Response(HttpStatus.OK.value(),"failed",new Date(),eventUser);
                return new ResponseEntity<>(response,null, HttpStatus.OK);
            }
        }
    }
    @GetMapping("/geteventuser")
    public ResponseEntity<?> getEventUser()
    {
        List<EventUser> eventUsers=eventUserService.allEventUser();
        if(eventUsers!=null)
        {
            Response response=new Response(HttpStatus.OK.value(),"saved",new Date(),eventUsers);
            return new ResponseEntity<>(response,null, HttpStatus.OK);
        }
        else
        {
            {
                Response response=new Response(HttpStatus.OK.value(),"failed",new Date(),"empty");
                return new ResponseEntity<>(response,null, HttpStatus.OK);
            }
        }
    }
    @GetMapping("/geteventuser/{id}")
    public ResponseEntity<?> getSingleEventUser(@PathVariable("id") Integer id)
    {
        EventUser eventUsers=eventUserService.getSingleEventUser(id);
        if(eventUsers!=null)
        {
            Response response=new Response(HttpStatus.OK.value(),"saved",new Date(),eventUsers);
            return new ResponseEntity<>(response,null, HttpStatus.OK);
        }
        else
        {
            {
                Response response=new Response(HttpStatus.OK.value(),"failed",new Date(),eventUsers);
                return new ResponseEntity<>(response,null, HttpStatus.OK);
            }
        }
    }

    @DeleteMapping("/delete-eventuser/{id}")
    public ResponseEntity<?> deleteEventUser(@PathVariable("id") Integer id)
    {
        String message="";
      try
        {
            eventUserService.deleteEventUser(id);
            message="Successfully Deleted";
        }
      catch(Exception e)
      {
          message="failed to delete please check the error"+e;
      }
        Response response=new Response(HttpStatus.OK.value(),"Status: ",new Date(),message);
      return new ResponseEntity<>(response,null,HttpStatus.OK);
    }


    @PutMapping("/update-eventuser")
    public ResponseEntity<?> updateEventUser(@RequestBody EventUser eventUser)
    {

        if(eventUserService.saveEventUser(eventUser)!=null)
        {
            Response response=new Response(HttpStatus.OK.value(),"Updated",new Date(),eventUser);
            return new ResponseEntity<>(response,null, HttpStatus.OK);
        }
        else
        {
            {
                Response response=new Response(HttpStatus.OK.value(),"failed to update",new Date(),eventUser);
                return new ResponseEntity<>(response,null, HttpStatus.OK);
            }
        }
    }

    //for event

    @PostMapping ("/addevent")
    public ResponseEntity<?> addEvent(@RequestBody Event event)
    {

        if(eventService.saveEvent(event)!=null)
        {
            Response response=new Response(HttpStatus.OK.value(),"saved",new Date(),event);
            return new ResponseEntity<>(response,null, HttpStatus.OK);
        }
        else
        {
            {
                Response response=new Response(HttpStatus.OK.value(),"saved",new Date(),event);
                return new ResponseEntity<>(response,null, HttpStatus.OK);
            }
        }
    }
    @GetMapping("/getevent")
    public ResponseEntity<?> getEvent()
    {
        List<Event> events=eventService.allEvent();
        if(events!=null)
        {
            Response response=new Response(HttpStatus.OK.value(),"Successfully loaded",new Date(),events);
            return new ResponseEntity<>(response,null, HttpStatus.OK);
        }
        else
        {
            {
                Response response=new Response(HttpStatus.OK.value(),"faield",new Date(),events);
                return new ResponseEntity<>(response,null, HttpStatus.OK);
            }
        }
    }
    @GetMapping("/getsingleevent/{id}")
    public ResponseEntity<?> getSingleEvent(@PathVariable("id") Integer id)
    {
        Event event=eventService.getSingleEvent(id);
        if(event!=null)
        {
            Response response=new Response(HttpStatus.OK.value(),"saved",new Date(),event);
            return new ResponseEntity<>(response,null, HttpStatus.OK);
        }
        else
        {
            {
                Response response=new Response(HttpStatus.OK.value(),"saved",new Date(),event);
                return new ResponseEntity<>(response,null, HttpStatus.OK);
            }
        }
    }

    @DeleteMapping("/delete-event/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable("id") Integer id)
    {
        String message="";
        try
        {
            eventService.deleteEvent(id);
            message="Successfully Deleted";
        }
        catch(Exception e)
        {
            message="failed to delete please check the error"+e;
        }
        Response response=new Response(HttpStatus.OK.value(),"Status: ",new Date(),message);
        return new ResponseEntity<>(response,null,HttpStatus.OK);
    }


    @PutMapping("/update-event")
    public ResponseEntity<?> updateEventUser(@RequestBody Event event)
    {

        if(eventService.updateEvent(event)!=null)
        {
            Response response=new Response(HttpStatus.OK.value(),"Updated",new Date(),event);
            return new ResponseEntity<>(response,null, HttpStatus.OK);
        }
        else
        {
            {
                Response response=new Response(HttpStatus.OK.value(),"failed",new Date(),event);
                return new ResponseEntity<>(response,null, HttpStatus.OK);
            }
        }
    }


    //for teams
    @PostMapping ("/addteams")
    public ResponseEntity<?> addTeams(@RequestBody Teams teams)
    {

        if(teamService.saveTeams(teams)!=null)
        {
            Response response=new Response(HttpStatus.OK.value(),"saved",new Date(),teams);
            return new ResponseEntity<>(response,null, HttpStatus.OK);
        }
        else
        {
            {
                Response response=new Response(HttpStatus.OK.value(),"Failed to save",new Date(),teams);
                return new ResponseEntity<>(response,null, HttpStatus.OK);
            }
        }
    }
    @GetMapping("/getteams")
    public ResponseEntity<?> getTeams()
    {
        List<Teams> teamsList=teamService.allTeams();
        if(teamsList!=null)
        {
            Response response=new Response(HttpStatus.OK.value(),"saved",new Date(),teamsList);
            return new ResponseEntity<>(response,null, HttpStatus.OK);
        }
        else
        {
            {
                Response response=new Response(HttpStatus.OK.value(),"failed",new Date(),"Empty");
                return new ResponseEntity<>(response,null, HttpStatus.OK);
            }
        }
    }
    @GetMapping("/getsingleteam/{id}")
    public ResponseEntity<?> getSingleTeam(@PathVariable("id") Integer id)
    {
        Teams teams=teamService.getSingleTeams(id);
        if(teams!=null)
        {
            Response response=new Response(HttpStatus.OK.value(),"loaded",new Date(),teams);
            return new ResponseEntity<>(response,null, HttpStatus.OK);
        }
        else
        {
            {
                Response response=new Response(HttpStatus.OK.value(),"failed",new Date(),teams);
                return new ResponseEntity<>(response,null, HttpStatus.OK);
            }
        }
    }

    @DeleteMapping("/delete-teams/{id}")
    public ResponseEntity<?> deleteTeams(@PathVariable("id") Integer id)
    {
        String message="";
        try
        {
            teamService.deleteTeams(id);
            message="Successfully Deleted";
        }
        catch(Exception e)
        {
            message="failed to delete please check the error"+e;
        }
        Response response=new Response(HttpStatus.OK.value(),"status: ",new Date(),message);
        return new ResponseEntity<>(response,null,HttpStatus.OK);
    }


    @PutMapping("/update-teams")
    public ResponseEntity<?> updateTeams(@RequestBody Teams teams)
    {

        if(teamService.updateTeams(teams)!=null)
        {
            Response response=new Response(HttpStatus.OK.value(),"updated",new Date(),teams);
            return new ResponseEntity<>(response,null, HttpStatus.OK);
        }
        else
        {
            {
                Response response=new Response(HttpStatus.OK.value(),"failed",new Date(),teams);
                return new ResponseEntity<>(response,null, HttpStatus.OK);
            }
        }
    }





}
