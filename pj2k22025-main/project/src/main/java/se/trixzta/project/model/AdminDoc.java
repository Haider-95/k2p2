package se.trixzta.project.model;

public class AdminDoc {

    private String title;
    private String description;

    public AdminDoc() {}

    public AdminDoc(String title, String description) {
        this.title = title;
        this.description = description;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
