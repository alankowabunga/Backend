package com.pure_springboot.repository;

import com.pure_springboot.domain.GtPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GtPersonRepository extends JpaRepository<GtPerson, Long> {
}
