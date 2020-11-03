package com.broadway.eventmanagement.repo;


import com.broadway.eventmanagement.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Integer>{
    @Query(value = "insert into events (name,date,description,location) values (?1,?2,?3,?4)",nativeQuery = true)
void insert(String name,String date,String Description,String Location);

    @Query(value = "insert into team_members(event_id,teams_id) values (?1,?2))", nativeQuery = true)
    void insertEventAndTeam(Integer eventId,Integer teamsId);
}