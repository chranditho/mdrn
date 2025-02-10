package com.example.mdrn.fungi.domain.web;

import com.example.mdrn.fungi.domain.model.Fungus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FungusMapper {

  @Mapping(target = "discoveredDate", source = "discoveredDate.value")
  @Mapping(target = "name", source = "name.value")
  @Mapping(target = "species", source = "species.value")
  FungusDto fungusToFungusDto(Fungus fungus);
}
