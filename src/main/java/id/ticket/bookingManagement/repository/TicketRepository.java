package id.ticket.bookingManagement.repository;

import id.ticket.bookingManagement.entity.Ticket;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TicketRepository extends PagingAndSortingRepository<Ticket,Long>, JpaSpecificationExecutor<Ticket> {

    @Query(nativeQuery = true, value = "SELECT * FROM Ticket t WHERE t.concert_ticket = :concertId and t.booking_id IS NULL ORDER BY t.id  LIMIT :limit")
    List<Ticket> getUnsoldTicket (@Param("concertId") Long concertId,@Param("limit") Integer limit);
}
