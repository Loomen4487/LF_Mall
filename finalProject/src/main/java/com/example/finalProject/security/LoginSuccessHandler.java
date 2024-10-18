package com.example.finalProject.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import java.io.IOException;

public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final HttpSessionRequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        session.setAttribute("id",principalDetails.getUsername());
        session.setAttribute("role",principalDetails.getDto().getRole());
        SavedRequest sr = requestCache.getRequest(request,response);
        if(sr!=null){
            response.sendRedirect(sr.getRedirectUrl());
        }else response.sendRedirect("/");
    }
}
