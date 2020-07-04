package io.getstarted.spring.fieldformat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/field-format")
public class MessagingRestController {

  @GetMapping(path = "/message")
  public Message getMessage() {
    final Message message = new Message();
    message.setText("Hello");
    message.setDate(LocalDate.parse("2019-12-31"));
    message.setTime(LocalTime.parse("23:59:59"));
    message.setTimestamp(LocalDateTime.parse("2019-12-31T23:59:59"));
    return message;
  }
}
