package com.broadway.eventmanagement.pojo;

import com.broadway.eventmanagement.model.Event;
import com.broadway.eventmanagement.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventUserPojo {
    private String uName;
    private String uUsername;
    private String uPassword;
    private List<Event> eventList=new ArrayList<>();
    private Set<UserType> userTypes=new HashSet<>();
}
