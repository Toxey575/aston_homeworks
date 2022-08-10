package com.roma.bfg.service.impl;

import com.roma.bfg.form.LogForm;
import com.roma.bfg.model.Log;
import com.roma.bfg.repository.LogRepository;
import com.roma.bfg.service.LogService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LogServiceImpl implements LogService {
    private final LogRepository logRepository;

    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public Log addLog(LogForm form) {

        Log log = Log.builder()
                .studentId(form.getStudentId())
                .date(form.getDate())
                .message(form.getMessage())
                .build();

        return logRepository.createLog(log);

    }

    @Override
    public Log getLogByStudentId(UUID id) {

        return logRepository.selectLogByStudentId(id);

    }

    @Override
    public Log updateLog(UUID id, LogForm form) {


        return logRepository.updateLog(id, form);

    }
}
