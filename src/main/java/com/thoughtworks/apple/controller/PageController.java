package com.thoughtworks.apple.controller;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringWriter;
import java.util.Properties;

@RestController
public class PageController {

    static {
        Properties properties = new Properties();
        properties.setProperty("resource.loader", "class");
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(properties);
    }

    @RequestMapping("/page/employees.html")
    String getEmployeeListPage() {
        VelocityContext context = new VelocityContext();

        context.put("title", "员工列表");

        Template template = Velocity.getTemplate("pages/employee_list.vm");

        StringWriter sw = new StringWriter();

        template.merge(context, sw);

        return sw.getBuffer().toString();
    }
}
