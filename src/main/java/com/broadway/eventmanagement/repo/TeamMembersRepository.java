package com.broadway.eventmanagement.repo;


import com.broadway.eventmanagement.model.TeamMembers;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeamMembersRepository extends JpaRepository<TeamMembers, Integer> {

}