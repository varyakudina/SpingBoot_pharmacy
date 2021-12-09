package com.boots.service.user;

import com.boots.dto.UserDTO;
import com.boots.entity.User;
import com.boots.exception.ValidationException;
import com.boots.repository.UserRepository;
import com.boots.converter.UserConverter;

//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultUserService implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserConverter userConverter;


    @Override
    public UserDTO saveUser(UserDTO userDTO) throws ValidationException {
        validateUserDto(userDTO);
        User savedUser = userRepository.save(userConverter.fromUserDTOToUser(userDTO));
        return userConverter.fromUserToUserDTO(savedUser);
    }

    private void validateUserDto(UserDTO userDTO) throws ValidationException {
        if (isNull(userDTO)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(userDTO.getPassword()) || userDTO.getPassword().isEmpty()) {
            throw new ValidationException("Password is empty");
        }
    }

    @Override
    public void deleteUser(Integer user_id) {
        userRepository.deleteById(user_id);
    }


    @Override
    public UserDTO findByLogin(String login) {
        User user =  userRepository.findByLogin(login);
        return userConverter.fromUserToUserDTO(user);
    }
    @Override
    public UserDTO findByPassword(String password) {
        User user = userRepository.findByPassword(password);
        if (user != null) {
            if(passwordEncoder.matches(password, user.getPassword()))
            return userConverter.fromUserToUserDTO(user);
        }
        return null;
    }

    @Override
    public void updateUser(UserDTO userDTO) {


    }

    @Override
    public List<UserDTO> findAllUser() {
        return userRepository.findAll()
                .stream()
                .map(userConverter::fromUserToUserDTO)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<UserDTO> getAll(Integer numberOfSeats, Integer page, Integer size) {
//        Specification<User> specification = Specification.where(numberOfSeats == null ? null : userSpecification.numberOfSeatsC());
//        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.Direction.ASC, "id");
//        return UserRepository.findAll(specification, pageRequest)
//                .stream()
//                .map(userConverter::fromUserToUserDTO)
//                .collect(Collectors.toList());
//    }

}

