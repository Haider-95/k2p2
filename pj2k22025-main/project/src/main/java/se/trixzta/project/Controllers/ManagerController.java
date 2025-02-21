package se.trixzta.project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.trixzta.project.Components.ManagerComponent;
import se.trixzta.project.model.ManagerInfo;

import java.util.List;

@Controller
public class ManagerController {
    private final ManagerComponent managerComponent;

    public ManagerController(ManagerComponent managerComponent) {
        this.managerComponent = managerComponent;
    }

    @GetMapping("/manager")
    public String adminPage(Model model) {
        List<ManagerInfo> mdocs = managerComponent.getManagerComponents();
        model.addAttribute("managerInfoList", mdocs);
        return "manager";
    }
}