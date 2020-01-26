package com.metaxiii.escalade.service;


import com.metaxiii.escalade.model.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation reservation(long id, long userId);

    List<Reservation> findAllReservationByUserId(long id);
}
