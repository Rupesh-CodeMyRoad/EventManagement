package com.broadway.eventmanagement.service;

import com.broadway.eventmanagement.model.Event;
import com.broadway.eventmanagement.model.EventType;

import java.util.List;

public interface EventTypeService {
    List<EventType> getAllEventType();
    EventType getSingleEventType(Integer id);
}
