package pl.coderslab.tests;

import pl.coderslab.dao.CommentDao;
import pl.coderslab.model.Comment;

public class CommentTest {

    public static void main(String[] args) {

        Comment comment = new Comment(1, 10, 3, "Takie sobie rozwiązanie");
        CommentDao commentDao = new CommentDao();

        //commentDao.update(comment);
        //commentDao.create(comment);
        commentDao.delete(4);
        Comment[] comments = commentDao.findAll();
        for (int i = 0; i < comments.length; i++) {
            System.out.println(comments[i]);
        }

        System.out.println(commentDao.read(4));
    }

}
