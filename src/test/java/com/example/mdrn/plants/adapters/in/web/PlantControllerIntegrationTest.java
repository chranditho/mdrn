package com.example.mdrn.plants.adapters.in.web;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.mdrn.plants.domain.model.Plant;
import com.example.mdrn.plants.ports.out.PlantRepository;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PlantControllerIntegrationTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private PlantRepository plantRepository;

  @BeforeEach
  void setUp() {
    Plant maturePlant = new Plant(1L, "Mature Rose", "Rosa", LocalDate.now().minusYears(2));

    List<Plant> maturePlants = List.of(maturePlant);
    given(plantRepository.findAll()).willReturn(maturePlants);
  }

  @Test
  void testGetAllMaturePlants() throws Exception {
    mockMvc
        .perform(get("/plants/mature"))
        .andExpect(status().isOk())
        .andExpect(
            content()
                .json(
                    """
                                                    [
                                                      {
                                                        "id": 1,
                                                        "name": "Mature Rose",
                                                        "species": "Rosa",
                                                        "plantedDate":"2022-09-12",
                                                        "mature":true}
                                                    ]
                            """));
  }
}
