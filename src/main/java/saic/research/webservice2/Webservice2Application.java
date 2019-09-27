package saic.research.webservice2;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import saic.research.webservice2.util.webservice2Properties;


@ComponentScan(basePackages = { "saic.research.webservice2" })
@SpringBootApplication
@EnableAsync
@EnableConfigurationProperties({
	webservice2Properties.class
})
public class Webservice2Application {
   
	public static void main(String[] args) {
		SpringApplication.run(Webservice2Application.class, args);
	}

@Bean
public Executor asyncExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(2);
    executor.setMaxPoolSize(2);
    executor.setQueueCapacity(500);
    executor.setThreadNamePrefix("SAFERUploadMicroService-");
    executor.initialize();
    return executor;
}

}
