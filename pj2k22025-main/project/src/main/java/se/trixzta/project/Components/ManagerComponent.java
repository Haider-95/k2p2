package se.trixzta.project.Components;

import org.springframework.stereotype.Component;
import se.trixzta.project.model.ManagerInfo;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManagerComponent {
    public List<ManagerInfo> getManagerComponents(){
        List<ManagerInfo> Mdocs = new ArrayList<>();
        Mdocs.add(new ManagerInfo("doc1", "im dia1 MR"));
        Mdocs.add(new ManagerInfo("doc2", "i like manga/manhwa"));
        Mdocs.add(new ManagerInfo("doc3", "what is you want from life ?"));
        return Mdocs;
    }
}