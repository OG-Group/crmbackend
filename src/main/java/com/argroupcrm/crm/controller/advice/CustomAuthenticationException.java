package com.argroupcrm.crm.controller.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author ogbozoyan
 * @date 18.02.2023
 */
public class CustomAuthenticationException implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException, ServletException {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                403,
                new Date(),
                "Authentication error",
                "Need to authorize"
        );
        res.setContentType("application/json;charset=UTF-8");
        res.setStatus(403);
        res.getWriter().write(
                new ObjectMapper().
                        writer().
                        withDefaultPrettyPrinter().
                        writeValueAsString(errorMessage)
        );

    }
}
