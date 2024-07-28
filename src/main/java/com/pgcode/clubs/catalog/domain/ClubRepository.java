package com.pgcode.clubs.catalog.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Goran Paunovic
 */

@Repository
public interface ClubRepository extends JpaRepository<Club, Integer> {

}
