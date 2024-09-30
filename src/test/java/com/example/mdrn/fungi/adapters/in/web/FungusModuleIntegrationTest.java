package com.example.mdrn.fungi.adapters.in.web;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.mdrn.fungi.domain.model.Fungus;
import com.example.mdrn.fungi.domain.model.ToxicityLevel;
import com.example.mdrn.fungi.ports.out.FungusRepository;
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
class FungusModuleIntegrationTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private FungusRepository fungusRepository;

  @BeforeEach
  void setUp() {
    Fungus deathCap =
        new Fungus(
            UUID.fromString("123e4567-e89b-12d3-a456-426614174000"),
            "Death Cap",
            "Amanita phalloides",
            LocalDate.of(2022, 9, 13),
            ToxicityLevel.DEADLY);

    Fungus shiitake =
        new Fungus(
            UUID.fromString("223e4567-e89b-12d3-a456-426614174001"),
            "Shiitake",
            "Lentinula edodes",
            LocalDate.of(2021, 5, 20),
            ToxicityLevel.EDIBLE);

    List<Fungus> allFungi = List.of(deathCap, shiitake);
    given(fungusRepository.findAll()).willReturn(allFungi);
  }

  @Test
  void testGetAllPoisonousFungi() throws Exception {
    mockMvc
        .perform(get("/fungi/poisonous"))
        .andExpect(status().isOk())
        .andExpect(
            content()
                .json(
                    """
                            [
                              {
                                "id": "123e4567-e89b-12d3-a456-426614174000",
                                "name": "Death Cap",
                                "species": "Amanita phalloides",
                                "discoveredDate": "2022-09-13",
                                "toxicityLevel": "DEADLY",
                                "poisonous": true
                              }
                            ]
                            """));
  }
}
