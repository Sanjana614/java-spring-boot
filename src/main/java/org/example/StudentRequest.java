package org.example;

import lombok.Data;
import org.example.annotation.AllNotNull;

import java.io.Serializable;

@Data
public class StudentRequest implements Serializable {
    private String name;
    private Integer age;
    private Address address;
}
