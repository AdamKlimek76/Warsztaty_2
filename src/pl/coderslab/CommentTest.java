package pl.coderslab;

import pl.coderslab.dao.CommentDao;
import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.model.Comment;
import pl.coderslab.model.Exercise;

public class CommentTest {

    public static void main(String[] args) {

        Comment comment = new Comment(1, 10, 3, "Takie sobie rozwiązanie");
        CommentDao commentDao = new CommentDao();

        //commentDao.update(comment);
        //commentDao.create(comment);
        commentDao.delete(4);
        Comment[] comments = commentDao.findAll();
        try {
            int i = 0;
            while (comments[i] != null) {
                System.out.println(comments[i]);
                i++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("");
        }

        System.out.println(commentDao.read(4));
    }


}
