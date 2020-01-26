package com.metaxiii.escalade.repository;

import com.metaxiii.escalade.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	List<Reservation> findAllByTopoUserId(long id);
}
