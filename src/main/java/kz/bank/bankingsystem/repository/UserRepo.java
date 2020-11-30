package kz.bank.bankingsystem.repository;

import kz.bank.bankingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User getById(Integer id);
    void deleteById(Integer id);
}
