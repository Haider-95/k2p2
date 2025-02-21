package se.trixzta.project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import se.trixzta.project.Components.AdminComponent;
import se.trixzta.project.model.AdminDoc;

import java.util.List;


@Controller
public class AdminController {
    private final AdminComponent adminComponent;

    public AdminController(AdminComponent adminComponent) {
        this.adminComponent = adminComponent;
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        List<AdminDoc> docs = adminComponent.getAdminDoc();
        model.addAttribute("docs",docs);
        return "admin";
    }
}