package com.roma.bfg.service;

import com.roma.bfg.form.LogForm;
import com.roma.bfg.model.Log;

import java.util.UUID;

public interface LogService {

    Log addLog(LogForm form);

    Log getLogByStudentId(UUID id);

    Log updateLog(UUID id, LogForm form);

}
