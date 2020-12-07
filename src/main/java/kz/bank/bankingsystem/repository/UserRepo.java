package kz.bank.bankingsystem.repository;

import kz.bank.bankingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User getById(Long id);
    void deleteById(Long id);
    User getByPhoneNumber(String phoneNumber);
}