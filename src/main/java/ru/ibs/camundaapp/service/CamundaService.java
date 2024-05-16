package ru.ibs.camundaapp.service;

import org.camunda.bpm.engine.rest.dto.runtime.ProcessInstanceDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class CamundaService {

    @Value("${camunda.bpm.client.base-url}")
    private String camundaRestApiUrl;

    public String startProcessInstance(String processDefinitionKey) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>("", headers);
        String url = camundaRestApiUrl + "/process-definition/key/" + processDefinitionKey + "/start";

        ResponseEntity<ProcessInstanceDto> response = restTemplate.exchange(url, HttpMethod.POST, entity, ProcessInstanceDto.class);
        return Objects.requireNonNull(response.getBody()).getId();
    }

}
