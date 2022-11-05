package service;

import model.User;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> findUsers() {
    return userRepository.findUsers();
  }

  public void createUser(String login, String password) {
    userRepository.createUser(login, password);
  }

  public Optional<User> getUser(String login) {
    return userRepository.getUser(login);
  }
}
