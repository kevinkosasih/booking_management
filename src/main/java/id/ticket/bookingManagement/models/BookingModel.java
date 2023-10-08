package id.ticket.bookingManagement.models;

import lombok.Data;

@Data
public class BookingModel {
        private Long userId;
        private Long concertId;
        private Integer totalTicket;


}
