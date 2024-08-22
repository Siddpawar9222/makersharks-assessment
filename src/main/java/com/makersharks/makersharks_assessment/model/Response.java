package com.makersharks.makersharks_assessment.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class Response {

    private String message;
    private Object data;
    private Integer resultCode;
    private Date timestamp = new Date();

}
