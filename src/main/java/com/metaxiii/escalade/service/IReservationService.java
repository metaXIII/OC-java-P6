package com.metaxiii.escalade.service;


import com.metaxiii.escalade.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface IReservationService {
    Reservation reservation(long id, long userId);

    List<Reservation> findAllReservationByUserId(long id);

    void completeReservation(long id);
}
