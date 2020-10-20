package com.smarttimesheet.smarttimesheetmainservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-server")
public interface UserServerClinet {
    @GetMapping("/login")
    boolean authenticateUser(@RequestParam String email, @RequestParam String password);
}
