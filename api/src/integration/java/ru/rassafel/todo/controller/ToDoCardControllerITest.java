package ru.rassafel.todo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.rassafel.todo.controller.message.CreateToDoCardRequest;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class ToDoCardControllerITest {
    @Autowired
    MockMvc mvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    void integrationTestCreateCards() throws Exception {
        mvc.perform(post(ToDoCardController.MAPPING)
                .content(mapper.writeValueAsString(Map.of(CreateToDoCardRequest.PROPERTY_SUMMARY, "summary",
                    CreateToDoCardRequest.PROPERTY_DESCRIPTION, "description")))
                .contentType(MediaType.APPLICATION_JSON))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}
