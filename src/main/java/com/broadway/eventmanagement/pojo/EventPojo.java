package com.broadway.eventmanagement.pojo;

import com.broadway.eventmanagement.model.EventType;
import com.broadway.eventmanagement.model.Teams;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventPojo {

    private  int eventId;
private String eventName;
  private String eventDate;
 private String eventLocation;
private String eventDescription;
private EventType eventType;

}
