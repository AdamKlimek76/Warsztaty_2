package pl.coderslab.dao;

import pl.coderslab.model.Comment;
import pl.coderslab.model.Level;
import pl.coderslab.util.DBUtil;

import java.sql.*;
import java.util.Arrays;

public class LevelDao {

    private static final String CREATE_LEVEL_QUERY =
            "INSERT INTO levels(level) VALUES (?)";
    private static final String READ_LEVEL_QUERY =
            "SELECT * FROM levels where id = ?";
    private static final String UPDATE_LEVEL_QUERY =
            "UPDATE levels SET level = ? where id = ?";
    private static final String DELETE_LEVEL_QUERY =
            "DELETE FROM levels WHERE id = ?";
    private static final String FIND_ALL_LEVELS_QUERY =
            "SELECT * FROM levels";


    public Level create(Level level) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_LEVEL_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, level.getLevel());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                level.setId(resultSet.getInt(1));
            }
            return level;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    public Level read(int levelId) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_LEVEL_QUERY);
            statement.setInt(1, levelId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Level level = new Level(
                        resultSet.getInt("id"),
                        resultSet.getInt("level"));
                return level;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void update(Level level) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_LEVEL_QUERY);
            statement.setInt(1, level.getLevel());
            statement.setInt(2, level.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(int levelId) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_LEVEL_QUERY);
            statement.setInt(1, levelId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Level[] addToArray(Level level, Level[] levels) {
        Level[] tmpLevels = Arrays.copyOf(levels, levels.length + 1);
        tmpLevels[levels.length] = level;
        return tmpLevels;
    }


    public Level[] findAll() {
        try (Connection conn = DBUtil.getConnection()) {
            Level[] levels = new Level[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_LEVELS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Level level = new Level(
                        resultSet.getInt("id"),
                        resultSet.getInt("level"));
                levels = addToArray(level, levels);
            }
            return levels;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

