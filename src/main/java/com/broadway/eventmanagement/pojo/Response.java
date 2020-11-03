package com.broadway.eventmanagement.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    Integer status;
    String message;
    Date timestamp;
    Object data;
}



