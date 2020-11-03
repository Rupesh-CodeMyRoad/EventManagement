package com.broadway.eventmanagement.service;

import com.broadway.eventmanagement.model.TeamMembers;
import com.broadway.eventmanagement.model.Teams;

import java.util.List;

public interface TeamMemberService {

    TeamMembers saveTeamMembers(TeamMembers teamMembers);
    void deleteTeamMembers(Integer id);
    List<TeamMembers> allTeamMembers();
    TeamMembers getSingleTeamMembers(Integer id);
}
