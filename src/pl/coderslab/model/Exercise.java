package pl.coderslab.model;

public class Exercise {

    private int id;
    private String title;
    private String description;

    public Exercise() {
        this.id = 0;
        this.title = null;
        this.description = null;
    }

    public Exercise(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return id + " " + title + " " + description;
    }

    public boolean equals(Exercise exercise) {
        if (this.id == exercise.id) {
            return true;
        } else {
            return false;
        }
    }
}
