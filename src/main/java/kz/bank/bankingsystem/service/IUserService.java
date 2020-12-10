package kz.bank.bankingsystem.service;

import kz.bank.bankingsystem.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(User user);

    User getUserByPhoneNumber(String phoneNumber);

    void deleteUser(Long id);

    User updateUser(User user);

    User login(String username, String password);

}
