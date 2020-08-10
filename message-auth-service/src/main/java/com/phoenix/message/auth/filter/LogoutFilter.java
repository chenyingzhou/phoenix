package com.phoenix.message.auth.filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutFilter extends org.springframework.security.web.authentication.logout.LogoutFilter {
    public LogoutFilter() {
        super(new LogoutSuccessHandler(), new LogoutHandler());
    }

    private static class LogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {
        @Override
        public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        }
    }

    private static class LogoutHandler implements org.springframework.security.web.authentication.logout.LogoutHandler {
        @Override
        public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
            HttpSession session = httpServletRequest.getSession();
            if (session != null) {
                session.invalidate();
            }
        }
    }
}
