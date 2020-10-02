package com.springbt.spamanagement.repository;

import com.springbt.spamanagement.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {
}
