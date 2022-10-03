package com.simple.ticketing.api;

import java.util.List;
import java.util.stream.Collectors;

import com.simple.ticketing.model.Seat;
import com.simple.ticketing.model.Show;
import com.simple.ticketing.services.BookingService;
import com.simple.ticketing.services.ShowService;
import com.simple.ticketing.services.TheatreService;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class BookingController {
    private final ShowService showService;
    private final BookingService bookingService;
    private final TheatreService theatreService;

    public String createBooking(@NonNull final String userId, @NonNull final String showId,
                                @NonNull final List<String> seatsIds) {
        final Show show = showService.getShow(showId);
        final List<Seat> seats = seatsIds.stream().map(theatreService::getSeat).collect(Collectors.toList());
        return bookingService.createBooking(userId, show, seats).getId();
    }
}
