package com.example.SpringBootValidation.serviece;

import com.example.SpringBootValidation.dto.UserDto;
import com.example.SpringBootValidation.entity.User;
import com.example.SpringBootValidation.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);

    }

//    @Transactional
//    public User saveUser(UserDto userDto) {
//        User user=new User();
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        return userRepository.save(user);
//   }

}
