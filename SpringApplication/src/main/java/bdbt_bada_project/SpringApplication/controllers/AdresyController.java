package bdbt_bada_project.SpringApplication.controllers;

import bdbt_bada_project.SpringApplication.dao.AdresyDAO;
import bdbt_bada_project.SpringApplication.models.Adresy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adresy")
public class AdresyController {

    @Autowired
    private AdresyDAO adresyDAO;

    @GetMapping
    public List<Adresy> getAllAdresy() {
        return adresyDAO.getAllAdresy();
    }

    @GetMapping("/{id}")
    public Adresy getAdresyById(@PathVariable Integer id) {
        return adresyDAO.getAdresyById(id);
    }

    @PostMapping
    public void addAdresy(@RequestBody Adresy adresy) {
        adresyDAO.saveAdresy(adresy);
    }

    @PutMapping("/{id}")
    public void updateAdresy(@PathVariable Integer id, @RequestBody Adresy adresy) {
        adresy.setIdAdresu(id);
        adresyDAO.updateAdresy(adresy);
    }

    @DeleteMapping("/{id}")
    public void deleteAdresy(@PathVariable Integer id) {
        adresyDAO.deleteAdresy(id);
    }
}

