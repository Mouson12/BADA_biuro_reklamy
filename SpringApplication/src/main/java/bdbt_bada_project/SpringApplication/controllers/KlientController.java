package bdbt_bada_project.SpringApplication.controllers;

import bdbt_bada_project.SpringApplication.dao.KlienciDAO;
import bdbt_bada_project.SpringApplication.models.Adresy;
import bdbt_bada_project.SpringApplication.models.Biura;
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
//    @GetMapping("/klienci/{id}")
//    public String viewClientDetails(@PathVariable int id, Model model) {
//        Klienci klient = klienciDAO.getKlienciById(id);
//        model.addAttribute("klient", klient);
//        return "client-details"; // Points to client-details.html in the templates folder
//    }
    @GetMapping("/profile")
    public String viewClientDetails(Model model) {
        Klienci klient = klienciDAO.getKlienciById(1); // Fetch client with ID 1
        Adresy adresy = klienciDAO.getAdresById(klient.getIdAdresu());
        Biura biura = klienciDAO.getBiuroById(klient.getIdBiura());

        model.addAttribute("klient", klient);
        model.addAttribute("adres", adresy);
        model.addAttribute("biuro", biura);
        return "user/client-details"; // Maps to client-details.html
    }

    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute Klienci klienci) {
    klienciDAO.saveKlienci(klienci);
        return "redirect:/main_user";
    }
}
