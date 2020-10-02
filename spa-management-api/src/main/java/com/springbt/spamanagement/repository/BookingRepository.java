package com.springbt.spamanagement.repository;

import com.springbt.spamanagement.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    public  List<Booking> findBookingByDateEqualsAndAndExpertId( Date date, Long expertId);
}
