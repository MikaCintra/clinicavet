
package com.example.clinica.controller;

import com.example.clinica.model.Consulta;
import com.example.clinica.repository.ConsultaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaRepository consultaRepository;

    public ConsultaController(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @GetMapping
    public List<Consulta> listar() {
        return consultaRepository.findAll();
    }

    @PostMapping
    public Consulta criar(@RequestBody Consulta consulta) {
        return consultaRepository.save(consulta);
    }
}
