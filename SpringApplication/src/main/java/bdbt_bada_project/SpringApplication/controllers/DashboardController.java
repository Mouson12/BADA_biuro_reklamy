package bdbt_bada_project.SpringApplication.controllers;

import bdbt_bada_project.SpringApplication.dao.KlienciDAO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController
{
    private final KlienciDAO klienciDAO;

    public DashboardController(KlienciDAO klienciDAO) {
        this.klienciDAO = klienciDAO;
    }

    @RequestMapping("/main")
    public String defaultAfterLogin(HttpServletRequest request) {
        if(request.isUserInRole("ADMIN")) {
            return "redirect:/main_admin";
        } else if(request.isUserInRole("USER")) {
            return "redirect:/main_user";
        } else {
            return "redirect:/index";
        }
    }

    @RequestMapping("/main_admin")
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }

    @RequestMapping("/main_user")
    public String showUserPage(Model model) {
        model.addAttribute("klient", klienciDAO.getKlienciById(1));
        return "user/main_user";
    }
}
