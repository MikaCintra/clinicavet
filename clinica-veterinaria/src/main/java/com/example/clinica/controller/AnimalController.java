
package com.example.clinica.controller;

import com.example.clinica.model.Animal;
import com.example.clinica.repository.AnimalRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping
    public List<Animal> listar() {
        return animalRepository.findAll();
    }

    @PostMapping
    public Animal criar(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    @PutMapping("/{id}")
    public Animal atualizar(@PathVariable Long id, @RequestBody Animal novoAnimal) {
        return animalRepository.findById(id).map(animal -> {
            animal.setNome(novoAnimal.getNome());
            animal.setEspecie(novoAnimal.getEspecie());
            animal.setIdade(novoAnimal.getIdade());
            return animalRepository.save(animal);
        }).orElseGet(() -> {
            novoAnimal.setId(id);
            return animalRepository.save(novoAnimal);
        });
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        animalRepository.deleteById(id);
    }
}
