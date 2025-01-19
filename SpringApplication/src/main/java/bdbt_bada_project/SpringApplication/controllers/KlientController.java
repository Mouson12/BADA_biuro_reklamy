package bdbt_bada_project.SpringApplication.controllers;

import bdbt_bada_project.SpringApplication.dao.KlienciDAO;
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
    KlienciDAO klienciDAO;

    @GetMapping("/update-user")
    public String showUpdateUserForm(Model model) {
        // Add existing user's data into the model
        model.addAttribute("klient", klienciDAO.getKlienciById(1));
        return "user/update_user";
    }

    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute Klienci klienci) {
    klienciDAO.saveKlienci(klienci);
        return "redirect:/main_user";
    }
}
