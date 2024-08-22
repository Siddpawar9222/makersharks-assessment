package com.makersharks.makersharks_assessment.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.makersharks.makersharks_assessment.model.Response;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthenticationEntryPointJWT implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper ;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException authException) throws IOException, ServletException {
        this.handleException(response, "Access Denied. Bearer token is missing or invalid.", HttpServletResponse.SC_FORBIDDEN);
    }

    private void handleException(HttpServletResponse response, String message, int status) throws IOException {
        Response customResponse = new Response();
        customResponse.setMessage(message);
        customResponse.setResultCode(status);

        response.setStatus(status);
        response.setContentType("application/json");
        response.getWriter().write(convertObjectToJson(customResponse));
    }

    private String convertObjectToJson(Object object) {
        try {
            //ObjectMapper objectMapper = new ObjectMapper();
            return this.objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}