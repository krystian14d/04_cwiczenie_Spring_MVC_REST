package pl.javastart.equipy.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    List<UserDto> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    List<UserDto> findUserByLastName(String lastName) {
        return userRepository.findAllByLastNameContainingIgnoreCase(lastName)
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    UserDto saveUser(UserDto user) {
        Optional<User> userByPesel = userRepository.findByPesel(user.getPesel());
        userByPesel.ifPresent(u -> {
            throw new DuplicatePeselException();
        });
        return saveAndMapUser(user);
    }

    UserDto updateUser(UserDto user) {
        Optional<User> userByPesel = userRepository.findByPesel(user.getPesel());
        userByPesel.ifPresent(u -> {
            throw new DuplicatePeselException();
        });
        return saveAndMapUser(user);
    }

    private UserDto saveAndMapUser(UserDto user) {
        User userEntity = UserMapper.toEntity(user);
        User savedUser = userRepository.save(userEntity);
        return UserMapper.toDto(savedUser);
    }

    Optional<UserDto> findUserById(Long id) {
        return userRepository.findById(id).map(UserMapper::toDto);
    }

    List<UserAssigmentDto> getUserAssigments(Long userId){
        return userRepository.findById(userId)
                .map(User::getAssigments)
                .orElseThrow(UserNotFoundException::new)
                .stream()
                .map(UserAssigmentMapper::toDto)
                .collect(Collectors.toList());
    }
}
