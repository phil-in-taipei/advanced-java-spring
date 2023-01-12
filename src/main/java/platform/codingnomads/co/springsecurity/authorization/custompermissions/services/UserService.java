package platform.codingnomads.co.springsecurity.authorization.custompermissions.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.codingnomads.co.springsecurity.authorization.custompermissions.models.User;
import platform.codingnomads.co.springsecurity.authorization.custompermissions.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    //public User getUser(String username) {
     //   return userRepository.findByUsername(username);
    //}


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public void updateUser(User updatedUser) {
        if (updatedUser != null) {
            userRepository.save(updatedUser);
        }
    }

    //public User findById(Long id) {
    //    return userRepository.findById(id);
    //}
}
