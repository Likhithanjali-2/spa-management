package com.springbt.spamanagement.repository;

import com.springbt.spamanagement.model.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertsRepository extends JpaRepository<Expert,Long> {
}
