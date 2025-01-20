package bdbt_bada_project.SpringApplication.controllers;

import bdbt_bada_project.SpringApplication.dao.AdresyDAO;
import bdbt_bada_project.SpringApplication.dao.KlienciDAO;
import bdbt_bada_project.SpringApplication.models.Adresy;
import bdbt_bada_project.SpringApplication.models.Klienci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/klienci")
public class KlienciAdminController {

    @Autowired
    private KlienciDAO klienciDAO;

    @Autowired
    private AdresyDAO adresyDAO;

    @GetMapping
    public String viewAll(Model model) {
        model.addAttribute("klienci", klienciDAO.getAllKlienci());
        return "admin/view_klienci";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("klient", new Klienci());
        model.addAttribute("adres", new Adresy());
        model.addAttribute("action", "Add");
        model.addAttribute("function", "save");
        return "admin/add_edit_klienci";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        Klienci klienci = klienciDAO.getKlienciById(id);
        Adresy adresy = adresyDAO.getAdresyById(klienci.getIdAdresu());
        model.addAttribute("klient", klienci);
        model.addAttribute("adres", adresy);
        model.addAttribute("action", "Edit");
        model.addAttribute("function", "update");
        return "admin/add_edit_klienci";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Klienci klienci, @ModelAttribute Adresy adresy) {
        int id = adresyDAO.saveAdresy(adresy);
        klienci.setIdAdresu(id);
        klienci.setIdBiura(1);
        klienciDAO.saveKlienci(klienci);
        return "redirect:/admin/klienci";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Klienci klienci, @ModelAttribute Adresy adresy) {
        klienciDAO.updateKlienci(klienci);
        adresyDAO.updateAdresy(adresy);
        return "redirect:/admin/klienci";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        klienciDAO.deleteKlienci(id);
        return "redirect:/admin/klienci";
    }
}
