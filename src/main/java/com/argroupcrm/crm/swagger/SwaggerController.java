package com.argroupcrm.crm.swagger;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/")
@CrossOrigin(origins ="*", allowedHeaders = "*")
public class SwaggerController {
    @GetMapping
    public void swagger(HttpServletResponse rsp) throws IOException {
        rsp.sendRedirect("swagger-ui/");
    }
}
