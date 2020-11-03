package com.broadway.eventmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "team_members")
@Entity
@Data
public class TeamMembers implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "teammember_name")
    private String teammemberName;


}
