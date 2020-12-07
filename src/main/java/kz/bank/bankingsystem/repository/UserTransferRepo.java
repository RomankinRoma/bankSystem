package kz.bank.bankingsystem.repository;

import kz.bank.bankingsystem.model.UserTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTransferRepo extends JpaRepository<UserTransfer,Long> {

}
