package bdbt_bada_project.SpringApplication.controllers;

import bdbt_bada_project.SpringApplication.dao.BiuraDAO;
import bdbt_bada_project.SpringApplication.models.Biura;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biura")
public class BiuraController {

    @Autowired
    private BiuraDAO biuraDAO;

    @GetMapping
    public List<Biura> getAllBiura() {
        return biuraDAO.getAllBiura();
    }

    @GetMapping("/{id}")
    public Biura getBiuraById(@PathVariable Integer id) {
        return biuraDAO.getBiuraById(id);
    }

    @PostMapping
    public void addBiura(@RequestBody Biura biura) {
        biuraDAO.saveBiura(biura);
    }


    @DeleteMapping("/{id}")
    public void deleteBiura(@PathVariable Integer id) {
        biuraDAO.deleteBiura(id);
    }
}

