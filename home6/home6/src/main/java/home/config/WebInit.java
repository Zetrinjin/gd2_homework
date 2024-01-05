package home.config;

import jakarta.servlet.*;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Set;

public class WebInit implements ServletContainerInitializer{
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext ctx) throws ServletException {
        // Init Spring context
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);


        // Init servlet for Spring MVC
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        // Register servlet in Tomcat context
        final ServletRegistration.Dynamic servletRegistration =
                ctx.addServlet("dispatcherServlet", dispatcherServlet);
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");

        long maxSize = 16L * 1024 * 1024;
        servletRegistration.setMultipartConfig(
                new MultipartConfigElement(null, maxSize, maxSize, 0));
    }

}
