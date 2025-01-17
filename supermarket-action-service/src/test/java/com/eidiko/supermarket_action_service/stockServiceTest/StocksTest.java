package com.eidiko.supermarket_action_service.stockServiceTest;

import com.eidiko.supermarket_action_service.controller.StocksController;
import com.eidiko.supermarket_action_service.model.Stock;
import com.eidiko.supermarket_action_service.services.StocksService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(StocksController.class)
public class StocksTest {

    @Mock
    private StocksService stocksService;  // Mock the service

    @InjectMocks
    private StocksController stocksController;  // Inject the mocked service into the controller

    private MockMvc mockMvc;  // Use MockMvc for simulating HTTP requests

    public StocksTest() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(stocksController).build();  // Set up MockMvc for controller testing
    }

    @Test
    public void testAddStocks() throws Exception {
        // Arrange: Create a mock Stock object
        Stock mockStock = new Stock(4, "AAPL", 100, 150);

        // Mock the behavior of the StocksService (simulate adding a stock)
        when(stocksService.addStocks(mockStock)).thenReturn(mockStock);

        // Act: Simulate an HTTP POST request to /stocks
        mockMvc.perform(post("/stocks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":4,\"name\": \"AAPL\", \"quantity\": 100, \"price\": 150.0}"))

                // Assert: Check that the response is OK (HTTP 200) and contains the expected message
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Stock added successfully"));

        // Verify that the addStocks method of the service was called with the correct argument
        verify(stocksService, times(1)).addStocks(mockStock);
    }
}
