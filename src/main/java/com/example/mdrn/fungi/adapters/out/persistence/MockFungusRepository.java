package com.example.mdrn.fungi.adapters.out.persistence;

import static com.example.mdrn.fungi.domain.model.FungusMockFactory.createDeathCap;

import com.example.mdrn.fungi.domain.model.Fungus;
import com.example.mdrn.fungi.domain.model.FungusMockFactory;
import com.example.mdrn.fungi.ports.out.FungusRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class MockFungusRepository implements FungusRepository {

  @Override
  public List<Fungus> findAll() {
    Fungus deathCap = createDeathCap();
    Fungus shiitake = FungusMockFactory.createShiitake();

    return List.of(deathCap, shiitake);
  }
}
