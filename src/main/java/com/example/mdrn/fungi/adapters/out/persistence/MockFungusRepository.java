package com.example.mdrn.fungi.adapters.out.persistence;

import static com.example.mdrn.fungi.domain.model.FungusMockFactory.createDeathCap;
import static com.example.mdrn.fungi.domain.model.FungusMockFactory.createShiitake;

import com.example.mdrn.fungi.domain.model.Fungus;
import com.example.mdrn.fungi.ports.out.FungusRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class MockFungusRepository implements FungusRepository {

  @Override
  public List<Fungus> findAll() {
    return List.of(createDeathCap(), createShiitake());
  }
}
