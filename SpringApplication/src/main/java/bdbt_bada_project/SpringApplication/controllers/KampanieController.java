package bdbt_bada_project.SpringApplication.controllers;

import bdbt_bada_project.SpringApplication.dao.KampanieDAO;
import bdbt_bada_project.SpringApplication.models.Kampanie;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kampanie")
public class KampanieController {

    @Autowired
    private KampanieDAO kampanieDAO;

    @GetMapping
    public List<Kampanie> getAllKampanie() {
        return kampanieDAO.getAllKampanie();
    }

    @GetMapping("/{id}")
    public Kampanie getKampanieById(@PathVariable Integer id) {
        return kampanieDAO.getKampanieById(id);
    }

    @PostMapping
    public void addKampanie(@RequestBody Kampanie kampanie) {
        kampanieDAO.saveKampanie(kampanie);
    }

    @PutMapping("/{id}")
    public void updateKampanie(@PathVariable Integer id, @RequestBody Kampanie kampanie) {
        kampanie.setIdKampanii(id);
        kampanieDAO.updateKampanie(kampanie);
    }

    @DeleteMapping("/{id}")
    public void deleteKampanie(@PathVariable Integer id) {
        kampanieDAO.deleteKampanie(id);
    }
}

