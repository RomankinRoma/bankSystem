package kz.bank.bankingsystem.service;

import kz.bank.bankingsystem.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User getUserById(Integer id);

    User createUser(User user);

    void deleteUser(Integer id);

    User updateUser(User user);

}
