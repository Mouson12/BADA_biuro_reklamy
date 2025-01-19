package bdbt_bada_project.SpringApplication.controllers;

import bdbt_bada_project.SpringApplication.dao.KampanieDAO;
import bdbt_bada_project.SpringApplication.models.Kampanie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KampaniaController {

    @Autowired
    private KampanieDAO kampanieDAO;

    @GetMapping("/all-campaigns")
    public String showAllCampaigns(Model model) {
        int id = 1;

        model.addAttribute("kampanie", kampanieDAO.getAllKampanieByKlientId(id));
        return "user/all_campaigns";
    }

    @GetMapping("/create-campaign")
    public String showCreateCampaignForm() {
        return "user/create_campaign";
    }

    @PostMapping("/create-campaign")
    public String createCampaign(@ModelAttribute Kampanie kampania) {
        int id = 1;
        kampania.setIdKlienta(id);
        kampania.setIdBiura(id);
        kampanieDAO.saveKampanie(kampania);
        return "redirect:/all-campaigns";
    }
}
