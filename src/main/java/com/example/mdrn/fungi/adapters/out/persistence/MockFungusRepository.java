package com.example.mdrn.fungi.adapters.out.persistence;

import static java.util.UUID.randomUUID;

import com.example.mdrn.fungi.domain.model.Fungus;
import com.example.mdrn.fungi.domain.model.ToxicityLevel;
import com.example.mdrn.fungi.ports.out.FungusRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class MockFungusRepository implements FungusRepository {

  @Override
  public List<Fungus> findAll() {
    return List.of(
        new Fungus(
            randomUUID(),
            "Amanita muscaria",
            "Fly agaric",
            LocalDate.of(1753, 1, 1),
            ToxicityLevel.POISONOUS),
        new Fungus(
            randomUUID(),
            "Galerina marginata",
            "Funeral bell",
            LocalDate.of(1783, 1, 1),
            ToxicityLevel.POISONOUS));
  }
}
