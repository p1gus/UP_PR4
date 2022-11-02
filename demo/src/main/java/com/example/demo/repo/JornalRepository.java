package com.example.demo.repo;
import com.example.demo.models.Jornalisti;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface JornalRepository extends CrudRepository<Jornalisti, Long> {
    List<Jornalisti> findByFam(String fam);
    List<Jornalisti> findByFamContains(String fam);
}
