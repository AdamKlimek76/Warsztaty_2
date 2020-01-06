package pl.coderslab.model;

public class Skill {

    private int id;
    private String skill;

    public Skill() {
        this.id = 0;
        this.skill = null;
    }

    public Skill(int id, String skill) {
        this.id = id;
        this.skill = skill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String toString() {
        return id + " " + skill;
    }
}
