package repository;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
  List<User> getUsers();

  void createUser(String login, String password);

  Optional<User> getUser(String login);
}
