package com.broadway.eventmanagement.serviceimpl;


import com.broadway.eventmanagement.model.EventType;
import com.broadway.eventmanagement.model.TeamMembers;
import com.broadway.eventmanagement.repo.TeamMembersRepository;
import com.broadway.eventmanagement.repo.TeamsRepository;
import com.broadway.eventmanagement.service.TeamMemberService;
import com.broadway.eventmanagement.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamMemberServiceImpl implements TeamMemberService {

    @Autowired
    TeamMembersRepository teamMembersRepository;

    @Autowired
    TeamsRepository teamsRepository;

    @Override
    public TeamMembers saveTeamMembers(TeamMembers teamMembers) {
       return teamMembersRepository.save(teamMembers);
    }

    @Override
    public void deleteTeamMembers(Integer id) {
        TeamMembers teamMembers = new TeamMembers();
        teamMembers.setId(id);
        teamMembersRepository.delete(teamMembers);
    }

    @Override
    public List<TeamMembers> allTeamMembers() {
        return teamMembersRepository.findAll();
    }

    @Override
    public TeamMembers getSingleTeamMembers(Integer id) {
        return teamMembersRepository.getOne(id);
    }

}
