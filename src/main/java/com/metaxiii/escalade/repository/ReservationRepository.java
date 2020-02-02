package com.metaxiii.escalade.repository;

import com.metaxiii.escalade.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByTopoUserIdAndProgressIsTrue(long id);

    Optional<Reservation> findById(long id);
}
