package com.shopme.service;

import com.shopme.Exception.UserNotFoundException;
import com.shopme.entity.Role;
import com.shopme.entity.User;

import com.shopme.userrepository.RoleRepository;
import com.shopme.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> listAll(){
        return (List<User>) userRepository.findAll();
    }

    public List<Role> listRoles(){
        return (List<Role>) roleRepository.findAll();
    }

    public User saverUser(User user){
        boolean isUpdatingUser = (user.getId() != null);

        if (isUpdatingUser){
            User existingUser = userRepository.findById(user.getId()).get();

            if (user.getPassword().isEmpty()){
                user.setPassword(existingUser.getPassword());
            }
        } else{
            encodePassword(user);
        }
        return userRepository.save(user);
    }

    public void encodePassword(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }

    public boolean isEmailUnique(Integer id, String email){
        User userByEmail = userRepository.getUserByEmail(email);
        if (userByEmail == null){
            return true;
        }

        boolean isCreatingNew = (id == null);

        if (isCreatingNew){
            if (userByEmail != null){
                return false;
            } else {
                if (userByEmail.getId() != id){
                    return false;
                }
            }
        }
        return true;
    }

    public User getById(Integer id) throws UserNotFoundException {
        try{
            return userRepository.findById(id).get();
        } catch (NoSuchElementException ex){
            throw new UserNotFoundException("Could not find the user with user ID: " + id);
        }

    }

    public void deleteUserById(Integer id) throws UserNotFoundException {
        Long countById = userRepository.countById(id);
        if (countById == null || countById == 0){
            throw new UserNotFoundException("Could not find the user with user ID: " + id);
        }
        userRepository.deleteById(id);
    }

    public void updateUserEnabledStatus(Integer id, boolean enabled){
        userRepository.enableStatus(id, enabled);
    }
}
