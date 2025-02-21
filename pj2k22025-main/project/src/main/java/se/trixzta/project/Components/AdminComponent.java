package se.trixzta.project.Components;

import org.springframework.stereotype.Component;
import se.trixzta.project.model.AdminDoc;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminComponent {
    public  List<AdminDoc> getAdminDoc() {
        List<AdminDoc> docs = new ArrayList<>();
        docs.add(new AdminDoc("doc 1", "Meeting at 13.00"));
        docs.add(new AdminDoc("doc 2", "Meeting at 14.00"));
        docs.add(new AdminDoc("doc 3", "Meeting at 15.00"));
        return  docs;
    }
}