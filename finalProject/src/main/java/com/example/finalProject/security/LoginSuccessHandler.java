package com.example.finalProject.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Objects;

public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    public LoginSuccessHandler() {
        setUseReferer(true);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        session.setAttribute("id",principalDetails.getUsername());
        session.setAttribute("role",principalDetails.getDto().getRole());
//        if(request.getSession().getAttribute("prevPage")==null)response.sendRedirect("/");
//        response.sendRedirect(request.getSession().getAttribute("prevPage").toString());
        response.sendRedirect("/");
    }
}
