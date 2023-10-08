package id.ticket.bookingManagement.service;

import id.ticket.bookingManagement.entity.Ticket;
import id.ticket.bookingManagement.responseException.NotFoundException;
import id.ticket.bookingManagement.entity.Booking;
import id.ticket.bookingManagement.repository.BookingRepository;
import id.ticket.bookingManagement.repository.ConcertRepository;
import id.ticket.bookingManagement.repository.TicketRepository;
import id.ticket.bookingManagement.util.SimpleStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ConcertRepository concertRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Transactional
    public Booking createBooking(Long userId, Long concertId, Integer totalTicket) {
        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setConcertId(concertId);
        booking.setTotalTicket(totalTicket);
        booking.setBookingTime(LocalDateTime.now());

        if (!concertRepository.findById(concertId).isPresent())throw new NotFoundException("Concert not found with ID: " + concertId);
        List<Ticket> tickets = ticketRepository.getUnsoldTicket(concertId,totalTicket);
        List<String> randomCodes = generateRandomTicketCodes(totalTicket);
       for (int i = 0; i <= tickets.size(); i++){
           tickets.get(i).setCode(randomCodes.get(i));
       }
       ticketRepository.saveAll(tickets);

        return bookingRepository.save(booking);
    }
    private List<String> generateRandomTicketCodes(int numberOfCodes) {
        return IntStream.range(0, numberOfCodes)
                .mapToObj(i -> SimpleStringUtils.randomString(8))
                .distinct()
                .collect(Collectors.toList());
    }
    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

}
