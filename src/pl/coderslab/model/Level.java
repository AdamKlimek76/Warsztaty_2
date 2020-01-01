package pl.coderslab.model;

public class Level {

    private int id;
    private int level;

    public Level() {
        this.id=0;
        this.level=0;
    }

    public Level(int id, int level) {
        this.id = id;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String toString(){
        return id + " level " + level;
    }
}
