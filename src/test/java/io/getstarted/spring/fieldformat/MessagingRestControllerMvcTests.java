package io.getstarted.spring.fieldformat;

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

@WebMvcTest(controllers = {MessagingRestController.class})
class MessagingRestControllerMvcTests {

  @SpringBootApplication
  static class LocalConfiguration {}

  @Autowired private MockMvc mvc;

  @Test
  void getMessage() throws Exception {
    final ResultActions result =
        mvc.perform(get("/field-format/message").contentType(MediaType.APPLICATION_JSON));
    result
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.text", is("Hello")))
        .andExpect(jsonPath("$.date", is("31/12/2019")))
        .andExpect(jsonPath("$.time", is("11:59:59 PM")))
        .andExpect(jsonPath("$.timestamp", is("31/12/2019 11:59:59 PM")));
  }
}
