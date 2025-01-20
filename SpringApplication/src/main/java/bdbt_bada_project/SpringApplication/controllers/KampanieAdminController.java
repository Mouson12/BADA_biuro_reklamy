package bdbt_bada_project.SpringApplication.controllers;

import bdbt_bada_project.SpringApplication.dao.KampanieDAO;
import bdbt_bada_project.SpringApplication.models.Kampanie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/kampanie")
public class KampanieAdminController {

    @Autowired
    private KampanieDAO kampanieDAO;

    @GetMapping
    public String viewAll(Model model) {
        model.addAttribute("kampanie", kampanieDAO.getAllKampanie());
        return "admin/view_kampanie";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("kampania", new Kampanie());
        model.addAttribute("action", "Add");
        model.addAttribute("function", "save");
        return "admin/add_edit_kampanie";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        Kampanie kampanie = kampanieDAO.getKampanieById(id);
        model.addAttribute("kampania", kampanie);
        model.addAttribute("action", "Edit");
        model.addAttribute("function", "update");
        return "admin/add_edit_kampanie";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Kampanie kampanie) {
        kampanie.setIdBiura(1);
        kampanieDAO.saveKampanie(kampanie);
        return "redirect:/admin/kampanie";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Kampanie kampanie) {
        kampanieDAO.updateKampanie(kampanie);
        return "redirect:/admin/kampanie";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        kampanieDAO.deleteKampanie(id);
        return "redirect:/admin/kampanie";
    }
}
