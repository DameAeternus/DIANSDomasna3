package com.example.demo.config;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class webshopAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        // add your custom logic here
        // for example, you can redirect the user to a different page based on their role
        String role = authentication.getAuthorities().iterator().next().getAuthority(); // get user role
        String targetUrl = "/view1.html"; // default target URL
        if (role.equals("ROLE_ADMIN")) {
            targetUrl = "/admin.html"; // admin target URL
        }
        redirectStrategy.sendRedirect(request, response, targetUrl); // redirect the user
    }
}

