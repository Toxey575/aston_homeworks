package com.roma.bfg.repository;

import com.roma.bfg.form.LogForm;
import com.roma.bfg.model.Log;

import java.util.UUID;

public interface LogRepository {

    Log createLog(Log log);

    Log selectLogByStudentId(UUID id);

    Log updateLog(UUID id, LogForm form);

}
