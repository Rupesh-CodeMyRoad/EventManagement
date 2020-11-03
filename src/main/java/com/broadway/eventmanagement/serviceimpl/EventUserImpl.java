package com.broadway.eventmanagement.serviceimpl;

import com.broadway.eventmanagement.model.Event;
import com.broadway.eventmanagement.model.EventUser;
import com.broadway.eventmanagement.model.UserType;
import com.broadway.eventmanagement.repo.EventRepository;
import com.broadway.eventmanagement.repo.EventUserRepository;
import com.broadway.eventmanagement.repo.UserTypeRepository;
import com.broadway.eventmanagement.service.EventUserService;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EventUserImpl implements EventUserService {
    @Autowired
    EventUserRepository eventUserRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    UserTypeRepository userTypeRepository;

    @Override
    public EventUser saveEventUser(EventUser eventUser) {
        //for eventuser
      Iterable<UserType> yt=userTypeRepository.saveAll(eventUser.getUserTypes());
        Set<UserType> ytype= Sets.newHashSet(yt);
        eventUser.setUserTypes(ytype);

        //for eventlist
        Iterable<Event> event=eventRepository.saveAll(eventUser.getEventList());
        List<Event> eventList= Lists.newArrayList(event);
        eventUser.setEventList(eventList);
        return  eventUserRepository.save(eventUser);
    }

    @Override
    public EventUser updateEventUser(EventUser eventUser) {
        return eventUserRepository.save(eventUser);


    }

    @Override
    public void deleteEventUser(Integer id) {
        EventUser eventUser=new EventUser();
        eventUser.setId(id);
        eventUserRepository.delete(eventUser);
    }

    @Override
    public List<EventUser> allEventUser() {
        return eventUserRepository.findAll();
    }

    @Override
    public EventUser getSingleEventUser(Integer id) {
        return eventUserRepository.getOne(id);
    }
}
