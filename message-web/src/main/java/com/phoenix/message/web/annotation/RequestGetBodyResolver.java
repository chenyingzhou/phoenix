package com.phoenix.message.web.annotation;

import com.phoenix.message.common.util.JacksonUtil;
import org.springframework.core.MethodParameter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
public class RequestGetBodyResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(RequestGetBody.class) != null;
    }

    @Override
    public Object resolveArgument(@NonNull MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) {
        final HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();
        final Map<String, String> queryMap = new HashMap<>();
        String[] queryKeyValues = URLDecoder.decode(request.getQueryString(), StandardCharsets.UTF_8).split("&");
        for (String queryKeyValue : queryKeyValues) {
            String[] keyValue = queryKeyValue.split("=");
            if (keyValue.length == 2) {
                queryMap.put(toUnderline(keyValue[0]), keyValue[1]);
            }
        }
        return JacksonUtil.toObject(JacksonUtil.toJson(queryMap), methodParameter.getParameterType());
    }

    private String toUnderline(String source) {
        if (source == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            char ch = source.charAt(i);
            ch = ch != '-' ? ch : '_';
            if (Character.isUpperCase(ch) && i != 0) {
                sb.append('_');
            }
            sb.append(ch);
        }
        return sb.toString().toLowerCase();
    }

}
