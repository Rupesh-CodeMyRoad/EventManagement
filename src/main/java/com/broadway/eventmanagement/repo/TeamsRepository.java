package com.broadway.eventmanagement.repo;


import com.broadway.eventmanagement.model.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeamsRepository extends JpaRepository<Teams, Integer> {

}