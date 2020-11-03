package com.broadway.eventmanagement.serviceimpl;

import com.broadway.eventmanagement.model.Event;
import com.broadway.eventmanagement.model.EventType;
import com.broadway.eventmanagement.repo.EventTypeRepo;
import com.broadway.eventmanagement.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EventTypeServiceImpl implements EventTypeService {
    @Autowired
    EventTypeRepo eventTypeRepo;

    @Override
    public List<EventType> getAllEventType() {
        return eventTypeRepo.findAll();
    }

    @Override
    public EventType getSingleEventType(Integer id) {
       return eventTypeRepo.getOne(id);
    }
}
