package com.broadway.eventmanagement.service;

import com.broadway.eventmanagement.model.Event;
import com.broadway.eventmanagement.model.EventUser;

import java.util.List;

public interface EventUserService  {
    EventUser saveEventUser(EventUser eventUser);
    EventUser updateEventUser(EventUser eventUser);
    void deleteEventUser(Integer id);
    List<EventUser> allEventUser();
    EventUser getSingleEventUser(Integer id);
}
