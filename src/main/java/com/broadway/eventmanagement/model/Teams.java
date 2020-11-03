package com.broadway.eventmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
@Data
public class Teams implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "team_motto")
    private String teamMotto;

    @OneToMany(targetEntity = TeamMembers.class,orphanRemoval = true,cascade = CascadeType.ALL)
    @JoinColumn(name="teams_id",referencedColumnName ="id" )
    private List<TeamMembers> teamMembersList;

    @ManyToMany(fetch=FetchType.LAZY,mappedBy = "teams",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Event> eventList=new ArrayList<>();
}
