package pl.coderslab.dao;

import pl.coderslab.model.User;
import pl.coderslab.model.UserGroup;
import pl.coderslab.util.DBUtil;

import java.sql.*;
import java.util.Arrays;

public class UserGroupDao {
    private static final String CREATE_USER_GROUP_QUERY =
            "INSERT INTO user_group(name) VALUES (?)";
    private static final String READ_USER_GROUP_QUERY =
            "SELECT * FROM user_group where id = ?";
    private static final String UPDATE_USER_GROUP_QUERY =
            "UPDATE user_group SET name = ? where id = ?";
    private static final String DELETE_USER_GROUP_QUERY =
            "DELETE FROM user_group WHERE id = ?";
    private static final String FIND_ALL_USER_GROUPS_QUERY =
            "SELECT * FROM user_group";


    public UserGroup create(UserGroup userGroup) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_GROUP_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, userGroup.getName());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                userGroup.setId(resultSet.getInt(1));
            }
            return userGroup;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    public UserGroup read(int userGroupId) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_USER_GROUP_QUERY);
            statement.setInt(1, userGroupId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                UserGroup userGroup = new UserGroup(
                        resultSet.getInt("id"),
                        resultSet.getString("name"));
                return userGroup;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void update(UserGroup userGroup) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_USER_GROUP_QUERY);
            statement.setString(1, userGroup.getName());
            statement.setInt(2, userGroup.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(int userGroupId) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_USER_GROUP_QUERY);
            statement.setInt(1, userGroupId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private UserGroup[] addToArray(UserGroup userGroup, UserGroup[] userGroups) {
        UserGroup[] tmpUserGroups = Arrays.copyOf(userGroups, userGroups.length + 1);
        tmpUserGroups[userGroups.length] = userGroup;
        return tmpUserGroups;
    }


    public UserGroup[] findAll() {
        try (Connection conn = DBUtil.getConnection()) {
            UserGroup[] userGroups = new UserGroup[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_USER_GROUPS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserGroup userGroup = new UserGroup(
                        resultSet.getInt("id"),
                        resultSet.getString("name"));
                userGroups = addToArray(userGroup, userGroups);
            }
            return userGroups;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
