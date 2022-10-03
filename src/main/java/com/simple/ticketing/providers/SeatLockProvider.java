package com.simple.ticketing.providers;

import java.util.List;

import com.simple.ticketing.model.Seat;
import com.simple.ticketing.model.Show;

public interface SeatLockProvider {

    void lockSeats(Show show, List<Seat> seat, String user);
    void unlockSeats(Show show, List<Seat> seat, String user);
    boolean validateLock(Show show, Seat seat, String user);

    List<Seat> getLockedSeats(Show show);
}
