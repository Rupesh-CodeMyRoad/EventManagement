package com.broadway.eventmanagement.serviceimpl;

import com.broadway.eventmanagement.model.Event;
import com.broadway.eventmanagement.model.EventType;
import com.broadway.eventmanagement.model.Teams;
import com.broadway.eventmanagement.repo.EventRepository;
import com.broadway.eventmanagement.repo.EventTypeRepo;
import com.broadway.eventmanagement.repo.TeamsRepository;
import com.broadway.eventmanagement.service.EventService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    TeamsRepository teamsRepository;
    @Autowired
    EventTypeRepo eventTypeRepo;

    @Override
        public Event saveEvent(Event event) {
            Iterable<Teams> tms=teamsRepository.saveAll(event.getTeams());
            List<Teams> teams= Lists.newArrayList(tms);
            event.setTeams(teams);
            EventType eventType=eventTypeRepo.save(event.getEventType());
            event.setEventType(eventType);

//            eventRepository.insert(event.getEventName(),event.getEventDate(),event.getEventDescription(),event.getEventLocation());
//            return new Event();
        return eventRepository.save(event);
        }

    @Override
    public Event updateEvent(Event event) {
        EventType eventType=eventTypeRepo.save(event.getEventType());
        event.setEventType(eventType);

        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Integer id) {
        Event event =new Event();
        event.setId(id);
        eventRepository.delete(event);
    }

    @Override
    public List<Event> allEvent() {
        return eventRepository.findAll();

    }

    @Override
    public Event getSingleEvent(Integer id) {
        return eventRepository.getOne(id);
    }
}

