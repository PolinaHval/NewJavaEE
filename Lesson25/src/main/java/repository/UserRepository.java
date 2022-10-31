package repository;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findUsers();
    void createUser(String login, String password);
    Optional<User> getUser(String login);
}
