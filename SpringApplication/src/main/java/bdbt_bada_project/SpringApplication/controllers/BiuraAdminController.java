package bdbt_bada_project.SpringApplication.controllers;

import bdbt_bada_project.SpringApplication.dao.AdresyDAO;
import bdbt_bada_project.SpringApplication.dao.BiuraDAO;
import bdbt_bada_project.SpringApplication.models.Adresy;
import bdbt_bada_project.SpringApplication.models.Biura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/biura")
public class BiuraAdminController {

    @Autowired
    private BiuraDAO biuraDAO;

    @Autowired
    private AdresyDAO adresyDAO;

    @GetMapping
    public String viewAll(Model model) {
        model.addAttribute("biuro", biuraDAO.getAllBiura());
        return "admin/view_biura";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("biuro", new Biura());
        model.addAttribute("adres", new Adresy());
        model.addAttribute("action", "Add");
        model.addAttribute("function", "save");
        return "admin/add_edit_biura";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        Biura biura = biuraDAO.getBiuraById(id);
        Adresy adresy = adresyDAO.getAdresyById(biura.getIdAdresu());
        model.addAttribute("biuro", biura);
        model.addAttribute("adres", adresy);
        model.addAttribute("action", "Edit");
        model.addAttribute("function", "update");
        return "admin/add_edit_biura";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Biura biura, @ModelAttribute Adresy adresy) {
        int id = adresyDAO.saveAdresy(adresy);
        biura.setIdAdresu(id);
        biura.setIdPracownika(1);
        biuraDAO.saveBiura(biura);
        return "redirect:/admin/biura";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Biura biura, @ModelAttribute Adresy adresy) {
        biuraDAO.updateBiura(biura);
        adresyDAO.updateAdresy(adresy);
        return "redirect:/admin/biura";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        biuraDAO.deleteBiura(id);
        return "redirect:/admin/biura";
    }
}

