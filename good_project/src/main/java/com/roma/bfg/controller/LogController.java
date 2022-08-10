package com.roma.bfg.controller;

import com.roma.bfg.form.LogForm;
import com.roma.bfg.model.Log;
import com.roma.bfg.service.LogService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/logs")
public class LogController {
    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public Log addLog(@RequestBody LogForm form) {

        return logService.addLog(form);

    }

    @GetMapping("/{student-id}")
    public Log getLogByStudentId(@PathVariable("student-id") UUID id) {

        return logService.getLogByStudentId(id);

    }

    @PutMapping("/{log-id}")
    public Log updateLog(@PathVariable("log-id") UUID id, LogForm form) {

        return logService.updateLog(id, form);

    }

}
