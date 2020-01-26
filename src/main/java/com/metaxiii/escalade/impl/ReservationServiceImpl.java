package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.model.Reservation;
import com.metaxiii.escalade.model.Topo;
import com.metaxiii.escalade.model.User;
import com.metaxiii.escalade.repository.ReservationRepository;
import com.metaxiii.escalade.service.IReservationService;
import com.metaxiii.escalade.service.ITopoService;
import com.metaxiii.escalade.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationServiceImpl implements IReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    private ITopoService topoService;

    @Autowired
    private IUserService userService;

    @Override
    public Reservation reservation(long id, long userId) {
        Reservation reservation = new Reservation();
        Topo        topo        = new Topo();
        User        user        = new User();
        user.setId(userId);
        topo.setId(id);
        reservation.setTopo(topo);
        reservation.setRequestUserId(user);
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> findAllReservationByUserId(long id) {
        return reservationRepository.findAllByTopoUserId(id);
    }
}
