package com.consumer.comsumerService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author prade on 31-05-2023
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private long id;
    private String name;
    private long age;
    private String company;
    private long salary;
}
