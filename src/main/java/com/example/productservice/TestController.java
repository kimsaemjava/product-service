package com.example.productservice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//@RequestMapping("/product")
public class TestController {

    private String port;
    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        log.info("port:{}",request.getServerPort());
        return "product service test~~~~~~~^^99!!!$!!!!";
    }
}
