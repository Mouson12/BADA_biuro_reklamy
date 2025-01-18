package bdbt_bada_project.SpringApplication.controllers;


import bdbt_bada_project.SpringApplication.dao.PracownicyDAO;
import bdbt_bada_project.SpringApplication.models.Pracownicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pracownicy")
public class PracownicyController {

    @Autowired
    private PracownicyDAO pracownicyDAO;

    // Get all Pracownicy
    @GetMapping
    public List<Pracownicy> getAllPracownicy() {
        return pracownicyDAO.getAllPracownicy();
    }

    // Get a single Pracownik by ID
    @GetMapping("/{id}")
    public Pracownicy getPracownikById(@PathVariable Integer id) {
        return pracownicyDAO.getPracownikById(id);
    }

    // Add a new Pracownik
    @PostMapping
    public void addPracownik(@RequestBody Pracownicy pracownik) {
        pracownicyDAO.savePracownik(pracownik);
    }

    // Update an existing Pracownik
    @PutMapping("/{id}")
    public void updatePracownik(@PathVariable Integer id, @RequestBody Pracownicy pracownik) {
        pracownik.setIdPracownika(id);
        pracownicyDAO.updatePracownik(pracownik);
    }

    // Delete a Pracownik by ID
    @DeleteMapping("/{id}")
    public void deletePracownik(@PathVariable Integer id) {
        pracownicyDAO.deletePracownik(id);
    }
}

