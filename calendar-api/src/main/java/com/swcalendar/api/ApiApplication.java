package com.swcalendar.api;

import com.swcalendar.core.SimpleEntity;
import com.swcalendar.core.SimpleEntityRepository;
import java.util.List;
import javassist.Loader.Simple;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableJpaAuditing
@EntityScan("com.swcalendar.core")
@EnableJpaRepositories("com.swcalendar.core")
@RestController
@SpringBootApplication(scanBasePackages = "com.swcalendar.core")
public class ApiApplication {
  private final SimpleEntityRepository repo;

  public ApiApplication(SimpleEntityRepository repo) {
    this.repo = repo;
  }

/*  @GetMapping
  public List<SimpleEntity> finaAll(){
    return repo.findAll();
  }*/

  @PostMapping("/save")
  public SimpleEntity saveTest(){
    final SimpleEntity e = new SimpleEntity();
    e.setName("나혜석");
    return repo.save(e);
  }

  public static void main(String[] args) {
    SpringApplication.run(ApiApplication.class, args);
  }
}
