package com.broadway.eventmanagement.model;

import com.broadway.eventmanagement.enums.AuthorityType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "user_type")
public class UserType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


//    @Enumerated(EnumType.STRING)
//    private AuthorityType name;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "userTypes",cascade = CascadeType.ALL)
    private Set<EventUser> eventUserSet=new HashSet<>();

}
