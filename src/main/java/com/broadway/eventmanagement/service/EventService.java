package com.broadway.eventmanagement.service;

import com.broadway.eventmanagement.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EventService {
    Event saveEvent(Event event);
    Event updateEvent(Event event);
    void deleteEvent(Integer id);
    List<Event> allEvent();
    Event getSingleEvent(Integer id);
}
