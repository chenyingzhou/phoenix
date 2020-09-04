package com.phoenix.message.auth.filter;

import com.phoenix.message.common.util.JacksonUtil;
import lombok.Getter;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthLogoutFilter extends org.springframework.security.web.authentication.logout.LogoutFilter {
    public AuthLogoutFilter() {
        super((request, response, authentication) -> {
        }, (request, response, authentication) -> {
            HttpSession session = request.getSession();
            if (session != null) {
                session.invalidate();
            }
            response.setHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=utf-8");
            try {
                response.getWriter().write(new Response(0, "退出成功", null).toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        this.setFilterProcessesUrl("/auth/logout");
    }

    @Getter
    private static class Response {
        private final Integer code;
        private final String msg;
        private final Object data;

        private Response(Integer code, String msg, Object data) {
            this.code = code;
            this.msg = msg;
            this.data = data;
        }

        public String toString() {
            return JacksonUtil.toJson(this);
        }
    }
}
