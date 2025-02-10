package com.example.mdrn.plants.adapters.in.web;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.mdrn.plants.domain.model.Plant;
import com.example.mdrn.plants.domain.ports.out.PlantRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.web.servlet.MockMvc;

@ApplicationModuleTest
@AutoConfigureMockMvc
public class PlantModuleIntegrationTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private PlantRepository plantRepository;

  @BeforeEach
  void setUp() {
    Plant maturePlant =
        new Plant(
            UUID.fromString("07b5c71b-f97e-4a6a-a214-40c2615998da"),
            "Mature Rose",
            "Rosa",
            LocalDate.of(2022, 9, 13));
    Plant immaturePlant =
        new Plant(
            UUID.fromString("07b5c71b-f97e-4a6a-a214-40c2615998db"),
            "Immature Rose",
            "Rosa",
            LocalDate.now());
    List<Plant> plants = List.of(maturePlant, immaturePlant);
    given(plantRepository.findAll()).willReturn(plants);
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
                                                        "id": "07b5c71b-f97e-4a6a-a214-40c2615998da",
                                                        "name": "Mature Rose",
                                                        "species": "Rosa",
                                                        "plantedDate":"2022-09-13",
                                                        "mature":true}
                                                    ]
                            """));
  }

  @Test
  void getAllMaturePlants_returnsEmptyListWhenAllPlantsAreImmature() throws Exception {
    Plant immaturePlant1 =
        new Plant(
            UUID.fromString("07b5c71b-f97e-4a6a-a214-40c2615998dc"),
            "Immature Rose 1",
            "Rosa",
            LocalDate.now());
    Plant immaturePlant2 =
        new Plant(
            UUID.fromString("07b5c71b-f97e-4a6a-a214-40c2615998dd"),
            "Immature Rose 2",
            "Rosa",
            LocalDate.now());
    List<Plant> plants = List.of(immaturePlant1, immaturePlant2);
    given(plantRepository.findAll()).willReturn(plants);

    mockMvc
        .perform(get("/plants/mature"))
        .andExpect(status().isOk())
        .andExpect(content().json("[]"));
  }
}
