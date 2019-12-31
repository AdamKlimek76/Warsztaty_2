package pl.coderslab.dao;

import pl.coderslab.model.Skill;
import pl.coderslab.model.UserGroup;
import pl.coderslab.util.DBUtil;

import java.sql.*;
import java.util.Arrays;

public class SkillDao {

    private static final String CREATE_SKILL_QUERY =
            "INSERT INTO skills(skill) VALUES (?)";
    private static final String READ_SKILL_QUERY =
            "SELECT * FROM skills where id = ?";
    private static final String UPDATE_SKILL_QUERY =
            "UPDATE skills SET skill = ? where id = ?";
    private static final String DELETE_SKILL_QUERY =
            "DELETE FROM skills WHERE id = ?";
    private static final String FIND_ALL_SKILLS_QUERY =
            "SELECT * FROM skills";


    public Skill create(Skill skill) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_SKILL_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, skill.getSkill());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                skill.setId(resultSet.getInt(1));
            }
            return skill;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    public Skill read(int skillId) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_SKILL_QUERY);
            statement.setInt(1, skillId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Skill skill = new Skill(
                        resultSet.getInt("id"),
                        resultSet.getString("skill"));
                return skill;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void update(Skill skill) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_SKILL_QUERY);
            statement.setString(1, skill.getSkill());
            statement.setInt(2, skill.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(int skillId) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_SKILL_QUERY);
            statement.setInt(1, skillId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Skill[] addToArray(Skill skill, Skill[] skills) {
        Skill[] tmpSkills = Arrays.copyOf(skills, skills.length + 1);
        tmpSkills[skills.length] = skill;
        return tmpSkills;
    }


    public Skill[] findAll() {
        try (Connection conn = DBUtil.getConnection()) {
            Skill[] skills = new Skill[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_SKILLS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Skill skill = new Skill(
                        resultSet.getInt("id"),
                        resultSet.getString("skill"));
                skills = addToArray(skill, skills);
            }
            return skills;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
