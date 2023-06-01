package com.consumer.comsumerService.controller;

import com.consumer.comsumerService.client.ConsumerClient;
import com.consumer.comsumerService.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author prade on 01-06-2023
 */
@RestController
@AllArgsConstructor
@RequestMapping("consumerService")
public class Consumercontroller {
    private ConsumerClient client;

    @GetMapping("getAllEmployee")
    public List<Employee> getAllEmployees(@RequestParam List<Integer> ids){
        return client.getEmployees(ids);
    }
}
