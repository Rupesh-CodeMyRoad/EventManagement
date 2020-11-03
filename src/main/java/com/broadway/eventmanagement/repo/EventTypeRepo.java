package com.broadway.eventmanagement.repo;

import com.broadway.eventmanagement.model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepo extends JpaRepository<EventType ,Integer> {
}
