package com.broadway.eventmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "event_user")
@Data
public class EventUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String fullName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(targetEntity = Event.class,orphanRemoval = true,cascade = CascadeType.ALL)
    @JoinColumn(name="event_userId",referencedColumnName = "id")
    private List<Event> eventList=new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name="user_usertype",joinColumns = {@JoinColumn(name="event_userId")},inverseJoinColumns = {@JoinColumn(name="userTypeId")})
    private Set<UserType> userTypes=new HashSet<>();





}
