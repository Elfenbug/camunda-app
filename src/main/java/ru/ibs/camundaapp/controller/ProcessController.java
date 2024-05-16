package ru.ibs.camundaapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ibs.camundaapp.service.CamundaService;

@RestController
public class ProcessController {
    private final CamundaService camundaService;

    public ProcessController(CamundaService camundaService) {
        this.camundaService = camundaService;
    }

    @PostMapping("/start-process")
    public String startProcess(@RequestParam String processDefinitionKey) {
        return camundaService.startProcessInstance(processDefinitionKey);
    }
}
