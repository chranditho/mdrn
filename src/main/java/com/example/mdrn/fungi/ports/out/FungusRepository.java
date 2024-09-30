package com.example.mdrn.fungi.ports.out;

import com.example.mdrn.fungi.domain.model.Fungus;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface FungusRepository {
  List<Fungus> findAll();
}
