package com.example.mdrn.fungi.domain.application;

import com.example.mdrn.fungi.domain.model.Fungus;
import com.example.mdrn.fungi.domain.ports.in.FungusPort;
import com.example.mdrn.fungi.domain.ports.out.FungusRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FungusUseCase implements FungusPort {

  private final FungusRepository fungusRepository;

  @Override
  public List<Fungus> getAllPoisonousFungi() {
    return this.fungusRepository.findAll().stream().filter(Fungus::isPoisonous).toList();
  }
}
