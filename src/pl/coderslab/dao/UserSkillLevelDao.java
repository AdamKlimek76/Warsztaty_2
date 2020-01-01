package pl.coderslab.dao;

import pl.coderslab.model.Comment;
import pl.coderslab.model.User;
import pl.coderslab.model.UserSkillLevel;
import pl.coderslab.util.DBUtil;

import java.sql.*;
import java.util.Arrays;

public class UserSkillLevelDao {

    private static final String CREATE_USER_SKILL_LEVEL_QUERY =
            "INSERT INTO users_skills_levels(users_id, skills_id, levels_id) VALUES (?, ?, ?)";
    private static final String READ_USER_SKILL_LEVEL_QUERY =
            "SELECT * FROM users_skills_levels where id = ?";
    private static final String UPDATE_USER_SKILL_LEVEL_QUERY =
            "UPDATE users_skills_levels SET users_id = ?, skills_id = ?, levels_id = ? where id = ?";
    private static final String DELETE_USER_SKILL_LEVEL_QUERY =
            "DELETE FROM users_skills_levels WHERE id = ?";
    private static final String FIND_ALL_USERS_SKILLS_LEVELS_QUERY =
            "SELECT * FROM users_skills_levels";


    public UserSkillLevel create(UserSkillLevel userSkillLevel) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_SKILL_LEVEL_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, userSkillLevel.getUserId());
            statement.setInt(2, userSkillLevel.getSkillId());
            statement.setInt(3, userSkillLevel.getLevelId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                userSkillLevel.setId(resultSet.getInt(1));
            }
            return userSkillLevel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    public UserSkillLevel read(int userSkillLevelId) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_USER_SKILL_LEVEL_QUERY);
            statement.setInt(1, userSkillLevelId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                UserSkillLevel userSkillLevel = new UserSkillLevel(
                        resultSet.getInt("id"),
                        resultSet.getInt("users_id"),
                        resultSet.getInt("skills_id"),
                        resultSet.getInt("levels_id"));
                return userSkillLevel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void update(UserSkillLevel userSkillLevel) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_USER_SKILL_LEVEL_QUERY);
            statement.setInt(1, userSkillLevel.getUserId());
            statement.setInt(2, userSkillLevel.getSkillId());
            statement.setInt(3, userSkillLevel.getLevelId());
            statement.setInt(4, userSkillLevel.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(int userSkillLevelId) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_USER_SKILL_LEVEL_QUERY);
            statement.setInt(1, userSkillLevelId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private UserSkillLevel[] addToArray(UserSkillLevel userSkillLevel, UserSkillLevel[] userSkillLevels) {
        UserSkillLevel[] tmpUserSkillLevels = Arrays.copyOf(userSkillLevels, userSkillLevels.length + 1);
        tmpUserSkillLevels[userSkillLevels.length] = userSkillLevel;
        return tmpUserSkillLevels;
    }


    public UserSkillLevel[] findAll() {
        try (Connection conn = DBUtil.getConnection()) {
            UserSkillLevel[] userSkillLevels = new UserSkillLevel[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_USERS_SKILLS_LEVELS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserSkillLevel userSkillLevel = new UserSkillLevel(
                        resultSet.getInt("id"),
                        resultSet.getInt("users_id"),
                        resultSet.getInt("skills_id"),
                        resultSet.getInt("levels_id"));
                userSkillLevels = addToArray(userSkillLevel, userSkillLevels);
            }
            return userSkillLevels;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

