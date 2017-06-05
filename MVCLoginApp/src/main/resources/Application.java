package hom.spring.boot;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import hom.controller.prctc.GreetingController;

@SpringBootApplication
@ComponentScan("hom.controller.prctc")

//OR
/*
@EnableAutoConfiguration
@ComponentScan */
public class Application {

	public static void bootstrap(){
		
		int port = (int) (Math.random()*10000);
		String url = "http://localhost:"+port+"/";
		System.out.println("URL => " + "\n"+  url);
	    
		HashMap<String, Object> props = new HashMap<String, Object>();
		props.put("server.port", port);
		
		Object[] sources = new Object[2];
        sources[0] = Application.class;
        sources[1] = GreetingController.class;

		try {
			new SpringApplicationBuilder()
			    .sources(Application.class)                
			    .properties(props)
			    .run();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
       // SpringApplication.run(Application.class, args);
    }

	public static void main(String[] args) throws IOException {
			bootstrap();
}
}