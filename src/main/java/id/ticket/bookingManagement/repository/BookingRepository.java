package id.ticket.bookingManagement.repository;

import id.ticket.bookingManagement.entity.Booking;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookingRepository extends PagingAndSortingRepository<Booking,Long>, JpaSpecificationExecutor<Booking> {

    List<Booking> findByUserId(Long userId);
}
