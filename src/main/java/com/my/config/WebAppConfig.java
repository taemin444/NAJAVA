package com.my.config;

import com.my.config.RootContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

// 톰캣 web.xml 과 동일
public class WebAppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootContext.class}; // root-context.xml 과 동일
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletContext.class}; // servlet-context.xml (디스패처서블릿용) 과 동일
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};// DispatcherServlet에 대한 url pattern 지정
    }

    @Override
    protected Filter[] getServletFilters() {        // 인코딩 설정
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("utf-8");
        return new Filter[]{encodingFilter};
    }
}
