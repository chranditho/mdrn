package com.example.mdrn.fungi.domain.ports.in.in;

import com.example.mdrn.fungi.domain.model.Fungus;
import java.util.List;

public interface FungusPort {
  List<Fungus> getAllPoisonousFungi();
}
