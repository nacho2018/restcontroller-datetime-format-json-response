package io.getstarted.spring.defaultformat;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(controllers = {MessagingRestDefaultController.class})
class MessagingRestControllerMvcTests {

  @SpringBootApplication
  static class LocalConfiguration {}

  @Autowired private MockMvc mvc;

  @Test
  void getMessage() throws Exception {
    final ResultActions result =
        mvc.perform(get("/default-format/message").contentType(MediaType.APPLICATION_JSON));
    result
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.text", is("Hello")))
        .andExpect(jsonPath("$.date", is("2019-12-31")))
        .andExpect(jsonPath("$.time", is("23:59:59")))
        .andExpect(jsonPath("$.timestamp", is("2019-12-31T23:59:59")));
  }
}
