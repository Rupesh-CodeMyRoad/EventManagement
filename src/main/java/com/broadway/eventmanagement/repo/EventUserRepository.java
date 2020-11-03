package com.broadway.eventmanagement.repo;


import com.broadway.eventmanagement.model.EventUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EventUserRepository extends JpaRepository<EventUser, Integer> {

}