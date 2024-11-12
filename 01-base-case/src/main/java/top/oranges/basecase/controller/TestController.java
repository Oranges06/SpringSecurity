package top.oranges.basecase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: orange
 * @projectName: 01-base-case
 * @description:
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public Object test() {
        return "Hello World!";
    }
}