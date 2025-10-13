package org.gfg.Library_Management_Minor.repository;

import jakarta.validation.constraints.NotBlank;
import org.gfg.Library_Management_Minor.model.Txn;
import org.gfg.Library_Management_Minor.model.TxnStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TxnRepository extends JpaRepository<Txn,Integer> {
    Txn findByUserPhoneNoAndBookBookNoAndTxnStatus(@NotBlank(message = "User phone number cannot be blank") String userPhoneNo, @NotBlank(message = "Book number cannot be blank") String bookNo, TxnStatus txnStatus);
}
