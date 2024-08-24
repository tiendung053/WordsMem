package com.coreservice.repository;

import com.coreservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends GenericRepository<Account> {
    @Query(value = "SELECT * FROM ADM_ACCOUNT WHERE ACCOUNT_NAME = :username AND PASSWD = :password", nativeQuery = true)
    Account findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    boolean existsAccountByUsername(String username);
    boolean existsAccountByPassword(String password);
}
