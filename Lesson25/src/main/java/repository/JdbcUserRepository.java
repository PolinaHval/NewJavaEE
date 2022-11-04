package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcUserRepository implements UserRepository {

  private final Connection connection;

  public JdbcUserRepository(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<User> findUsers() {
    try {
      Statement statement = connection.createStatement();
      String sql = "select login, password from users";
      ResultSet rs = statement.executeQuery(sql);
      final List<User> users = new ArrayList<>();
      while (rs.next()) {
        final User user = new User(rs.getString("login"), rs.getString("password"));
        users.add(user);
      }
      return users;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void createUser(String login, String password) {
    try {
      String sql = "insert into users (login, password) values (?, ?)";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, login);
      statement.setString(2, password);
      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public User build(ResultSet resultSet) throws SQLException {
    return new User(resultSet.getString("login"), resultSet.getString("password"));
  }

  @Override
  public Optional<User> getUser(String login) {
    String sql = "select login, password from users where login = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setString(1, login);
      ResultSet rs = statement.executeQuery();
      if (rs.next()) {
        return Optional.of(build(rs));
      }
      return Optional.empty();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
