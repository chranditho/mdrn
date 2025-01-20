package com.example.mdrn.animals.adapters.in;

import static com.example.mdrn.animals.domain.model.Diet.CARNIVORE;
import static com.example.mdrn.animals.domain.model.Diet.HERBIVORE;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.mdrn.animals.domain.model.Animal;
import com.example.mdrn.animals.ports.out.AnimalRepository;
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
class AnimalIntegrationTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private AnimalRepository animalRepository;

  @BeforeEach
  void setUp() {
    Animal herbivor =
        new Animal(
            UUID.fromString("8d20ce80-d160-41c5-8c87-f422d749fb8f"),
            "Beaver",
            "genus",
            "species",
            HERBIVORE,
            LocalDate.of(2021, 9, 13));

    Animal carnivore =
        new Animal(
            UUID.fromString("aab176a4-ef26-4bfa-ab14-5bef5ddbb372"),
            "Lion",
            "genus",
            "species",
            CARNIVORE,
            LocalDate.of(2021, 9, 13));
    List<Animal> animals = List.of(herbivor, carnivore);
    given(animalRepository.findAll()).willReturn(animals);
  }

  @Test
  void getAllHerbivores() throws Exception {
    mockMvc
        .perform(get("/herbivores"))
        .andExpect(status().isOk())
        .andExpect(
            content()
                .json(
                    """
                            [
                            {
                            "id":"8d20ce80-d160-41c5-8c87-f422d749fb8f",
                            "name":"Beaver",
                            "genus":"genus",
                            "species":"species",
                            "diet":"HERBIVORE",
                            "discoveredDate":"2021-09-13"
                            }
                            ]
                            """));
  }

  @Test
  void getAllCarnivores() throws Exception {
    mockMvc
        .perform(get("/carnivores"))
        .andExpect(status().isOk())
        .andExpect(
            content()
                .json(
                    """
                            [
                            {
                            "id": "aab176a4-ef26-4bfa-ab14-5bef5ddbb372",
                            "name":"Lion",
                            "genus":"genus",
                            "species":"species",
                            "discoveredDate":"2021-09-13"
                            }
                            ]
                            """));
  }
}
