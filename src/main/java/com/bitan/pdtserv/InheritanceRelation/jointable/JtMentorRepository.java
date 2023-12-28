package com.bitan.pdtserv.InheritanceRelation.jointable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JtMentorRepository extends JpaRepository<Mentor,Long> {

    Mentor save(Mentor mentor);
  Mentor findMentorById(Long id);

}
