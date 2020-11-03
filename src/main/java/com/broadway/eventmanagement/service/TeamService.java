package com.broadway.eventmanagement.service;

import com.broadway.eventmanagement.model.Event;
import com.broadway.eventmanagement.model.Teams;

import java.util.List;

public interface TeamService {

Teams saveTeams(Teams Teams);
    Teams updateTeams(Teams teams);
    void deleteTeams(Integer id);
    List<Teams> allTeams();
    Teams getSingleTeams(Integer id);
}
