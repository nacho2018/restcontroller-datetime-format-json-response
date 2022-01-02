package io.getstarted.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"io.getstarted.spring.defaultformat",
    "io.getstarted.spring.fieldformat", "io.getstarted.spring.globalformat"})
public class DateTimeFormatJsonResponseApplication {

  public static void main(String[] args) {
    SpringApplication.run(DateTimeFormatJsonResponseApplication.class, args);
  }
}
