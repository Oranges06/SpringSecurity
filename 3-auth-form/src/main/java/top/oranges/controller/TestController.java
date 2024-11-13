package top.oranges.controller;

/**
 * @author: orange
 * @projectName: 3-auth-form
 * @description:
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "Hello Spring Security";
    }
}