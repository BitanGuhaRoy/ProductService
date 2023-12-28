package com.bitan.pdtserv.InheritanceRelation.singleclass;

//import com.bitan.pdtserv.InheritanceRelation.jointable.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MSUserRepository extends JpaRepository <User,Long>{
   User save(User user);
    User findUserById(Long id);
}
