package id.ticket.bookingManagement.repository;

import id.ticket.bookingManagement.entity.Concert;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ConcertRepository extends PagingAndSortingRepository<Concert,Long>, JpaSpecificationExecutor<Concert> {
}
