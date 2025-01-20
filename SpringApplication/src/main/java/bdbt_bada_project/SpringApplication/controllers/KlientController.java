package bdbt_bada_project.SpringApplication.controllers;

import bdbt_bada_project.SpringApplication.dao.AdresyDAO;
import bdbt_bada_project.SpringApplication.dao.KlienciDAO;
import bdbt_bada_project.SpringApplication.models.Adresy;
import bdbt_bada_project.SpringApplication.models.Klienci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class KlientController {

    @Autowired
    private KlienciDAO klienciDAO;

    @Autowired
    private AdresyDAO adresyDAO;

    @GetMapping("/update-user")
    public String showUpdateUserForm(Model model) {
        Klienci klienci = klienciDAO.getKlienciById(1);
        Adresy adresy = adresyDAO.getAdresyById(klienci.getIdAdresu());
        model.addAttribute("klient", klienci);
        model.addAttribute("adres", adresy);
        return "user/update_user";
    }

    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute Klienci klienci, @ModelAttribute Adresy adresy) {
    klienciDAO.updateKlienci(klienci);
    adresyDAO.updateAdresy(adresy);
    return "redirect:/main_user";
    }
}
