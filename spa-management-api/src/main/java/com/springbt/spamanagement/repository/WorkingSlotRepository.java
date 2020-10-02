package com.springbt.spamanagement.repository;

import com.springbt.spamanagement.model.WorkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingSlotRepository extends JpaRepository<WorkingSlot, Long> {
}
