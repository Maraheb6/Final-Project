package com.example.finalproject.Repository;

import com.example.finalproject.Model.BookingService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingServiceRepository extends JpaRepository<BookingService,Integer> {
    BookingService findBookingServicesById(Integer id);
}
