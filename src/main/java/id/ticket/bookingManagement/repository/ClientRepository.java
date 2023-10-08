package id.ticket.bookingManagement.repository;

import id.ticket.bookingManagement.entity.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {

    Client findOneByClientId(String clientId);

}
