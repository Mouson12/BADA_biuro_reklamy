package bdbt_bada_project.SpringApplication.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController
{
    @RequestMapping
            ("/main"
            )
    public String defaultAfterLogin
            (HttpServletRequest request) {
        if
        (request.isUserInRole
                ("ADMIN")) {
            return "redirect:/main_admin";
        }
        else if
        (request.isUserInRole
                        ("USER")) {
            return "redirect:/main_user";
        }
        else
        {
            return "redirect:/index";
        }
    }

    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }
    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }
}
