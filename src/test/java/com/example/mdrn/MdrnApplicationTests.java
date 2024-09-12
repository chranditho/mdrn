package com.example.mdrn;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class MdrnApplicationTests {

  @Test
  void writeDocumentationSnippets() {

    var modules = ApplicationModules.of(MdrnApplication.class).verify();

    new Documenter(modules).writeModulesAsPlantUml().writeIndividualModulesAsPlantUml();
  }
}
