package com.transportsystem.pathwebservice.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * The type Web service config.
 */
@EnableWs
@Configuration
class WebServiceConfig {

    /**
     * Message dispatcher servlet servlet registration bean.
     *
     * @param context the context
     * @return the servlet registration bean
     */
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }

    /**
     * Default wsdl 11 definition default wsdl 11 definition.
     *
     * @param pathDetailsSchema the path details schema
     * @return the default wsdl 11 definition
     */
    @Bean(name = "soap")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema pathDetailsSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("PathPort");
        definition.setTargetNamespace("http://transportsystem.com/soap");
        definition.setLocationUri("/ws/paths");
        definition.setSchema(pathDetailsSchema);
        return definition;
    }

    /**
     * Path details schema xsd schema.
     *
     * @return the xsd schema
     */
    @Bean
    public XsdSchema pathDetailsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("path-details.xsd"));
    }

    /**
     * Cors filter filter registration bean.
     *
     * @return the filter registration bean
     */
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}
