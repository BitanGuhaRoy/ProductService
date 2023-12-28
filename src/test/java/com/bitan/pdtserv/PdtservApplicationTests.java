package com.bitan.pdtserv;

import com.bitan.pdtserv.InheritanceRelation.jointable.JtMentorRepository;
import com.bitan.pdtserv.InheritanceRelation.jointable.Mentor;
import com.bitan.pdtserv.InheritanceRelation.jointable.User;
import com.bitan.pdtserv.InheritanceRelation.jointable.JtUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PdtservApplicationTests {
    @Autowired
 private JtUserRepository jtUserRepository;
    @Autowired
 private JtMentorRepository jtMentorRepository;

    @Test
    void contextLoads() {
    }
    @Test
    void testDifferentInheritances()
    {
        User user = new User();
        user.setEmail("r.bitan@iitg.ac.in");
        user.setPassword("Bitan");
        jtUserRepository.save(user);

        Mentor mentor = new Mentor();
        mentor.setEmail("m.pinaki@iitg.ac.in");
        mentor.setPassword("Pinaki");
        mentor.setNumberOfMentees(49);
        mentor.setNumberOfSessions(29);

        jtMentorRepository.save(mentor);

    }
}
