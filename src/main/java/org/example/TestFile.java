package org.example;


import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

public class TestFile {

    public static void main(String[] args) {
        StudentRequest request = new StudentRequest();
        request.setAge(18);
        request.setName("Vikash");
        Address address = new Address("Gurugram", "122011", "Haryana");
        request.setAddress(address);
        StudentRequest request1 = new StudentRequest();
        BeanUtils.copyProperties(request, request1);
        System.out.println(request);
        System.out.println(request1);
    }
}
