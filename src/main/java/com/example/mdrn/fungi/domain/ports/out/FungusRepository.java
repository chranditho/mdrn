package com.example.mdrn.fungi.domain.ports.out;

import com.example.mdrn.fungi.domain.model.Fungus;
import java.util.List;

public interface FungusRepository {
  List<Fungus> findAll();
}
