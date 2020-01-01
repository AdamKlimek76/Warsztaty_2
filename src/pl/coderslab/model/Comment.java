package pl.coderslab.model;

public class Comment {

    private int id;
    private int userId;
    private int solutionId;
    private String comment;

    public Comment() {
        this.id=0;
        this.userId=0;
        this.solutionId=0;
        this.comment=null;
    }

    public Comment(int id, int userId, int solutionId, String comment) {
        this.id = id;
        this.userId = userId;
        this.solutionId = solutionId;
        this.comment = comment;
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

    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int solutionId) {
        this.solutionId = solutionId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String toString(){
        return id + " userId " + userId + " solutionId " + solutionId + " " + comment;
    }
}
