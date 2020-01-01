package pl.coderslab.model;

public class UserSkillLevel {

    private int id;
    private int userId;
    private int skillId;
    private int levelId;

    public UserSkillLevel() {
        this.id=0;
        this.userId=0;
        this.skillId=0;
        this.levelId=0;
    }

    public UserSkillLevel(int id, int userId, int skillId, int levelId) {
        this.id = id;
        this.userId = userId;
        this.skillId = skillId;
        this.levelId = levelId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String toString(){
        return id + " userId=" + userId + " skillId=" + skillId + " levelId=" + levelId;
    }
}
