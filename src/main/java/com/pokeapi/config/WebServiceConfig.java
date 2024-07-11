package com.pokeapi.config;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.List;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

	private final IpAddressInterceptor ipAddressInterceptor;

	public WebServiceConfig(IpAddressInterceptor ipAddressInterceptor) {
		this.ipAddressInterceptor = ipAddressInterceptor;
	}

	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		interceptors.add(ipAddressInterceptor);
	}

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	/*@Bean("exampleService")
	public DefaultWsdl11Definition exampleServiceWsdl(XsdSchema exampleServiceSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ExampleServicePort");
		wsdl11Definition.setTargetNamespace("http://pokeapi.com/gen");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setSchema(exampleServiceSchema);
		return wsdl11Definition;
	}*/

	@Bean("pokeSoapService")
	public DefaultWsdl11Definition pokeSoaServiceWsdl(XsdSchema pokeSoapServiceSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ExampleServicePort");
		wsdl11Definition.setTargetNamespace("http://pokeapi.com/gen");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setSchema(pokeSoapServiceSchema);
		return wsdl11Definition;
	}

	/*@Bean
	public XsdSchema exampleServiceSchema() {
		return new SimpleXsdSchema(new ClassPathResource("exampleService.xsd"));
	}*/

	@Bean
	public XsdSchema pokeSoapServiceSchema() {
		return new SimpleXsdSchema(new ClassPathResource("pokeSoapService.xsd"));
	}


}
