package com.springbt.spamanagement.controller;

import antlr.ASTNULLType;
import com.springbt.spamanagement.model.*;
import com.springbt.spamanagement.repository.BookingRepository;
import com.springbt.spamanagement.repository.ExpertsRepository;
import com.springbt.spamanagement.repository.SlotRepository;
import com.springbt.spamanagement.repository.WorkingSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.LongStream;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping("/api/v1/spa")
public class SlotsController {
    @Autowired
    private SlotRepository slotRepository;
    @Autowired
    private WorkingSlotRepository workinngSlotRepositpry;

    @Autowired
    private BookingRepository bookingsRepository;

    @GetMapping("/slots")
    public List<Slot> getAllSlots(){
        return slotRepository.findAll();
    }

    @PostMapping("/slots")
    public Slot createSlot(@Valid @RequestBody Slot slot) {
        return slotRepository.save(slot);
    }

    @GetMapping("/working-slots")
    public List<WorkingSlot> getAllWorkingSlots(){
        return  workinngSlotRepositpry.findAll();
    }

    @PostMapping("/working-slots")
    public  WorkingSlot createWorkingSlots(@Valid @RequestBody WorkingSlot workingSlot){
        return  workinngSlotRepositpry.save(workingSlot);
    }

    @GetMapping("/slots/available/{id}/{date}")
    public List<Slot> getAvailableSlotsForExpert(@PathVariable(value = "id") Long expertId, @PathVariable(value = "date") String date) throws ParseException {
        List<Slot> slots= slotRepository.findAll();
        Date uDate = new SimpleDateFormat("yyyy-mm-dd").parse(date);
        List<Booking> bookings = bookingsRepository.findBookingByDateEqualsAndAndExpertId( uDate, expertId);
        long[] usedSlots = new long[bookings.size()];
        for (int i = 0; i < usedSlots.length; i++) {
            System.out.println(bookings.get(i).getSlotId());
            usedSlots[i]=bookings.get(i).getSlotId();
        }
        slots.removeIf(slot -> LongStream.of(usedSlots).anyMatch(x -> x == slot.getId()));
        return  slots;
    }
}
