package pl.coderslab.dao;

import pl.coderslab.model.Comment;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;
import pl.coderslab.util.DBUtil;

import java.sql.*;
import java.util.Arrays;

public class CommentDao {

    private static final String CREATE_COMMENT_QUERY =
            "INSERT INTO comments(comment, users_id, solution_id) VALUES (?, ?, ?)";
    private static final String READ_COMMENT_QUERY =
            "SELECT * FROM comments where id = ?";
    private static final String UPDATE_COMMENT_QUERY =
            "UPDATE comments SET comment = ?, users_id = ?, solution_id = ? where id = ?";
    private static final String DELETE_COMMENT_QUERY =
            "DELETE FROM comments WHERE id = ?";
    private static final String FIND_ALL_COMMENTS_QUERY =
            "SELECT * FROM comments";


    public Comment create(Comment comment) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_COMMENT_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, comment.getComment());
            statement.setInt(2, comment.getUserId());
            statement.setInt(3, comment.getSolutionId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                comment.setId(resultSet.getInt(1));
            }
            return comment;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    public Comment read(int commentId) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_COMMENT_QUERY);
            statement.setInt(1, commentId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Comment comment = new Comment(
                        resultSet.getInt("id"),
                        resultSet.getInt("users_id"),
                        resultSet.getInt("solution_id"),
                        resultSet.getString("comment"));
                return comment;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void update(Comment comment) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_COMMENT_QUERY);
            statement.setString(1, comment.getComment());
            statement.setInt(2, comment.getUserId());
            statement.setInt(3, comment.getSolutionId());
            statement.setInt(4, comment.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(int commentId) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_COMMENT_QUERY);
            statement.setInt(1, commentId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Comment[] addToArray(Comment comment, Comment[] comments) {
        Comment[] tmpComments = Arrays.copyOf(comments, comments.length + 1);
        tmpComments[comments.length] = comment;
        return tmpComments;
    }


    public Comment[] findAll() {
        try (Connection conn = DBUtil.getConnection()) {
            Comment[] comments = new Comment[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_COMMENTS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment(
                        resultSet.getInt("id"),
                        resultSet.getInt("users_id"),
                        resultSet.getInt("solution_id"),
                        resultSet.getString("comment"));
                comments = addToArray(comment, comments);
            }
            return comments;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
