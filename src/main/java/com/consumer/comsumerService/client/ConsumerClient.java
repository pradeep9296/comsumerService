package com.consumer.comsumerService.client;

import com.consumer.comsumerService.config.Configuration;
import com.consumer.comsumerService.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

/**
 * @author prade on 01-06-2023
 */
@Service
@AllArgsConstructor
public class ConsumerClient {

    private RestTemplate restTemplate;
    private Configuration config;
    private Executor executor;

    public List<Employee> getEmployees(List<Integer> empIds){
        var futureEmployee = empIds.stream().map(id -> CompletableFuture.supplyAsync(() -> getEmployeeById(id), executor))
                .collect(Collectors.toList());
        return futureEmployee.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    private Employee getEmployeeById(long id){
        try {
            return restTemplate.getForObject(config.getUrl(), Employee.class, id);
        }catch (Exception e){

        }
        return null;
    }
}
