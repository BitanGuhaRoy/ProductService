package com.bitan.pdtserv.InheritanceRelation.tableterclass;

//import com.bitan.pdtserv.InheritanceRelation.jointable.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TPCUserRepository extends JpaRepository <User,Long>{
    User save(User user);
    User findUserById(Long id);
}
