package com.simple.ticketing.api;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.simple.ticketing.model.Movie;
import com.simple.ticketing.model.Screen;
import com.simple.ticketing.model.Seat;
import com.simple.ticketing.model.Show;
import com.simple.ticketing.services.MovieService;
import com.simple.ticketing.services.SeatAvailabilityService;
import com.simple.ticketing.services.ShowService;
import com.simple.ticketing.services.TheatreService;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class ShowController {
    private final SeatAvailabilityService seatAvailabilityService;
    private final ShowService showService;
    private final TheatreService theatreService;
    private final MovieService movieService;

    public String createShow(@NonNull final String movieId, @NonNull final String screenId, @NonNull final Date startTime,
                             @NonNull final Integer durationInSeconds) {
        final Screen screen = theatreService.getScreen(screenId);
        final Movie movie = movieService.getMovie(movieId);
        return showService.createShow(movie, screen, startTime, durationInSeconds).getId();
    }

    public List<String> getAvailableSeats(@NonNull final String showId) {
        final Show show = showService.getShow(showId);
        final List<Seat> availableSeats = seatAvailabilityService.getAvailableSeats(show);
        return availableSeats.stream().map(Seat::getId).collect(Collectors.toList());
    }
}
