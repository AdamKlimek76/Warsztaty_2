package pl.coderslab.model;


import java.sql.Timestamp;

public class Solution {

    private int id;
    private Timestamp created;
    private Timestamp updated;
    private String description;
    private int exerciseId;
    private int usersId;

    public Solution() {
        this.id = 0;
        this.created = null;
        this.updated = null;
        this.description = null;
        this.exerciseId = 0;
        this.usersId = 0;
    }

    public Solution(int id, Timestamp created, Timestamp updated,
                    String description, int exerciseId, int usersId) {
        this.id = id;
        this.created = created;
        this.updated = updated;
        this.description = description;
        this.exerciseId = exerciseId;
        this.usersId = usersId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public String toString() {
        return id + " " + created + " " + updated + " " + description + " " +
                exerciseId + " " + usersId;
    }
}
