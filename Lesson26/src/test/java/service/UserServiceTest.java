package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.UserRepository;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserService sut;

  @Test
  void shouldCreateUserWhenUserNotExist() {
    final String login = "any_name";
    final String password = "any_password";

    given(userRepository.getUser(login)).willReturn(Optional.empty());

    sut.createUser(login, password);

    then(userRepository)
        .should()
        .createUser(login, password);
  }
}
