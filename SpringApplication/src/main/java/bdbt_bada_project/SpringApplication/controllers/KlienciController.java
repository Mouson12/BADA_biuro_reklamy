package bdbt_bada_project.SpringApplication.controllers;

import bdbt_bada_project.SpringApplication.dao.KlienciDAO;
import bdbt_bada_project.SpringApplication.models.Klienci;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/klienci")
public class KlienciController {

    @Autowired
    private KlienciDAO klienciDAO;

    @GetMapping
    public List<Klienci> getAllKlienci() {
        return klienciDAO.getAllKlienci();
    }

    @GetMapping("/{id}")
    public Klienci getKlienciById(@PathVariable Integer id) {
        return klienciDAO.getKlienciById(id);
    }

    @PostMapping
    public void addKlienci(@RequestBody Klienci klienci) {
        klienciDAO.saveKlienci(klienci);
    }


    @DeleteMapping("/{id}")
    public void deleteKlienci(@PathVariable Integer id) {
        klienciDAO.deleteKlienci(id);
    }
}

