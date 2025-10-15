package com.example.JPA.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.JPA.entity.DegreeWork;

// Cliente Feign para comunicarse con el microservicio de notificaciones
@FeignClient(name = "notification-microservice", url = "http://localhost:8082/api/notifications")
public interface NotificationServiceClient {
    @PostMapping("/degreework")
    void sendDegreeWork(@RequestBody DegreeWork degreeWork);
}