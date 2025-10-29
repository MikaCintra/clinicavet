
package com.example.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.clinica.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
