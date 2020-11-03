package com.broadway.eventmanagement.serviceimpl;


import com.broadway.eventmanagement.model.TeamMembers;
import com.broadway.eventmanagement.model.Teams;
import com.broadway.eventmanagement.repo.TeamMembersRepository;
import com.broadway.eventmanagement.repo.TeamsRepository;
import com.broadway.eventmanagement.service.TeamService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    @Autowired
    TeamsRepository teamsRepository;
    @Autowired
    TeamMembersRepository teamMembersRepository;


    @Override
    public Teams saveTeams(Teams teams) {
      Iterable<TeamMembers> teamMembers=teamMembersRepository.saveAll(teams.getTeamMembersList());
        List<TeamMembers> teamMembers1= Lists.newArrayList(teamMembers);
        teams.setTeamMembersList(teamMembers1);
        return teamsRepository.save(teams);
    }

    @Override
    public Teams updateTeams(Teams teams) {
        Iterable<TeamMembers> teamMembers=teamMembersRepository.saveAll(teams.getTeamMembersList());
        List<TeamMembers> teamMembers1= Lists.newArrayList(teamMembers);
        teams.setTeamMembersList(teamMembers1);
        return teamsRepository.save(teams);
    }

    @Override
    public void deleteTeams(Integer id) {
        Teams teams=new Teams();
        teams.setId(id);
        teamsRepository.delete(teams);
    }

    @Override
    public List<Teams> allTeams() {
      return teamsRepository.findAll();
    }

    @Override
    public Teams getSingleTeams(Integer id) {
        return teamsRepository.getOne(id);
    }
}
