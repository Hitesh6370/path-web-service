package com.transportsystem.pathwebservice;

import com.transportsystem.pathwebservice.service.PathService;
import com.transportsystem.soap.PathDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * The type Application tests.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private
    PathService pathService;

    /**
     * Finds task by id.
     *
     * @throws Exception the exception
     */
    @Test
    void findsTaskById() throws Exception {

        PathDetails pathDetails = new PathDetails();
        pathDetails.setSource("Earth");
        pathDetails.setDestination("Moon");
        pathDetails.setDuration(50.50);
        pathDetails.setDelay(10.00);

        when(pathService.shortestPath("Moon","Earth")).thenReturn(pathDetails);
        mockMvc.perform(post("/api/path"))
                .andDo(print());
    }

}
