package com.metaxiii.escalade.service;


import com.metaxiii.escalade.model.Reservation;

public interface IReservationService {
	Reservation reservation(long id, long userId);
}
