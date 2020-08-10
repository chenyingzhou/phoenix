package com.phoenix.message.auth.filter;

import javax.servlet.http.HttpSession;

public class LogoutFilter extends org.springframework.security.web.authentication.logout.LogoutFilter {
    public LogoutFilter() {
        super((httpServletRequest, httpServletResponse, authentication) -> {
        }, (httpServletRequest, httpServletResponse, authentication) -> {
            HttpSession session = httpServletRequest.getSession();
            if (session != null) {
                session.invalidate();
            }
        });
    }
}
