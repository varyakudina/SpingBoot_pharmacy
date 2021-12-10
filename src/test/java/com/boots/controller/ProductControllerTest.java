package com.boots.controller;

import com.boots.dto.ProductDTO;
import com.boots.service.product.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.URI;

import static com.boots.product.ProductGetNewObject.getProduct;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductControllerTest {

    private MockMvc mockMvc;
    @Mock
    ProductService productService;
    @InjectMocks
    private ProductController productController;


    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void save() throws Exception {
        ProductDTO productDTO = getProduct();
        mockMvc.perform(MockMvcRequestBuilders.post(new URI("http://localhost:8080/product"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(productDTO))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        verify(productService, times(1)).saveProduct(productDTO);
        verifyNoMoreInteractions(productService);

    }


    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ProductDTO getProduct() {
        return new ProductDTO(1,"acc" , "price = 20", 10,20,15,3);
    }
}