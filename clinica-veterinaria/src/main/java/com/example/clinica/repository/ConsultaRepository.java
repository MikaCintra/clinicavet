
package com.example.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.clinica.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
