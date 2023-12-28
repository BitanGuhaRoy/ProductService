package com.bitan.pdtserv.InheritanceRelation.mappedsuperclass;

//import com.bitan.pdtserv.InheritanceRelation.jointable.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MSMentorRepository extends JpaRepository<Mentor,Long> {

   Mentor save(Mentor mentor);
  Mentor findMentorById(Long id);

}
