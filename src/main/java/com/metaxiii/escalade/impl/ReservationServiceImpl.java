package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.enums.Message;
import com.metaxiii.escalade.model.Reservation;
import com.metaxiii.escalade.model.Topo;
import com.metaxiii.escalade.model.User;
import com.metaxiii.escalade.repository.ReservationRepository;
import com.metaxiii.escalade.service.IReservationService;
import com.metaxiii.escalade.service.ITopoService;
import com.metaxiii.escalade.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
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
        reservation.setProgress(true);
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> findAllReservationByUserId(long id) {
        return reservationRepository.findAllByTopoUserIdAndProgressIsTrue(id);
    }

    @Override
    public void completeReservation(long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()) {
            Optional<Topo> topoOptional = topoService.findById(reservation.get().getTopo().getId());
            topoOptional.ifPresent(topo -> topoService.updateTopoWithId(String.valueOf(topo.getId())));
            reservation.get().setProgress(false);
            reservationRepository.save(reservation.get());
        } else
            log.error(Message.GLOBAL_ERROR.getMsg());
    }
}
