package com.example.demo.service;

import com.example.demo.model.Users;
import com.example.demo.persistence.UserRepository;
import com.example.demo.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    @PersistenceContext
    private EntityManager em;
    private final UserRepository userRepository;

    @Override
    public boolean saveUser(Users user) {
        Users userFromDB = userRepository.findByUsername(user.getUsername());

        if(userFromDB != null) {
            return false;
        }
        user.setRole("USER");
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean deleteUser(String userId) {
        if(userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public List<Users> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Users> usergtList(String idMin){
        return em.createQuery("SELECT u FROM Users u WHERE u.id > :paramID", Users.class)
                .setParameter("paramID",idMin).getResultList();
    }

    @Override
    public Users findUser(String username) {
        return userRepository.findByUsername(username);
    }

    public Users findUserById(String userId){
        Optional<Users> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new Users());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        System.out.println("check");

        if (user == null){
            throw new UsernameNotFoundException("user not found");
        }

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
