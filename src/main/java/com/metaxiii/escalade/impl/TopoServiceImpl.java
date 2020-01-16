package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.model.Topo;
import com.metaxiii.escalade.model.User;
import com.metaxiii.escalade.repository.TopoRepository;
import com.metaxiii.escalade.service.IReservationService;
import com.metaxiii.escalade.service.ITopoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TopoServiceImpl implements ITopoService {
    private final TopoRepository topoRepository;

    @Autowired
    private IReservationService reservationService;

    @Override
    public List<Topo> findAllTopos() {
        return topoRepository.findAll();
    }

    @Override
    public Optional<Topo> findById(int id) {
        return topoRepository.findById(id);
    }

    @Override
    public void updateAvailableById(int id, boolean available) {
        topoRepository.updateTopo(id, available);
    }

    @Override
    public String updateTopoWithId(String id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            if (topoRepository.findById(Integer.parseInt(id)).isPresent()) {
                reservationService.reservation(Long.parseLong(id), user.getId());
                topoRepository.updateTopo(Integer.parseInt(id), false);
                return "La demande de réservation a bien été effectuée";
            } else {
                return "Une erreur s'est produite, veuillez réessayer plus tard";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur s'est produite, veuillez réessayer plus tard";
        }
    }
}
