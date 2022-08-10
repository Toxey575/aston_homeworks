package com.roma.bfg.form;

import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Data
public class LogForm {
    private UUID studentId;
    private Date date;
    private String message;
}
