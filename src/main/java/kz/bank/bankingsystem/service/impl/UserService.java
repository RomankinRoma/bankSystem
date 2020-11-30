package kz.bank.bankingsystem.service.impl;

import kz.bank.bankingsystem.model.User;
import kz.bank.bankingsystem.repository.UserRepo;
import kz.bank.bankingsystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepo.getById(id);
    }

    @Override
    public User createUser(User user) {
        user.setCreatedDate(new Date());
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        user.setCreatedDate(getUserById(user.getId()).getCreatedDate());
        return userRepo.save(user);
    }
}
