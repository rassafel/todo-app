package ru.rassafel.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.Clock;

@SpringBootApplication
public class ToDoApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ToDoApplication.class);
        ConfigurableApplicationContext context = application.run(args);
    }

    /**
     * Override this clock for testing
     *
     * @return system clock
     */
    @Bean
    Clock systemClock() {
        return Clock.systemDefaultZone();
    }
}
