package com.broadway.eventmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "event")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_date")
    private String eventDate;

    @Column(name = "event_location")
    private String eventLocation;

    @Column(name="event_description")
    private String eventDescription;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "event_and_teams",joinColumns = {@JoinColumn(name="event_id")},inverseJoinColumns = {@JoinColumn(name = "team_id")})
    private List<Teams> teams=new ArrayList<>();
    @OneToOne
    private EventType eventType;

}
