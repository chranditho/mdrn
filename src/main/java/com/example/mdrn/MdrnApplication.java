package com.example.mdrn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.Modulithic;

@Modulithic(sharedModules = "shared")
@SpringBootApplication
public class MdrnApplication {

  public static void main(String[] args) {
    SpringApplication.run(MdrnApplication.class, args);
  }
}
