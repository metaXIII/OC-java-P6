package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.model.Reservation;
import com.metaxiii.escalade.repository.ReservationRepository;
import com.metaxiii.escalade.service.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationServiceImpl implements IReservationService {
	private final ReservationRepository reservationRepository;

	@Override
	public Reservation reservation(long id, long userId) {
		Reservation reservation = new Reservation();
		reservation.setTopoId(id);
		reservation.setRequestUserId(userId);
		return reservationRepository.save(reservation);
	}
}
