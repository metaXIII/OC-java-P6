package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.controller.AbstractController;
import com.metaxiii.escalade.dto.TopoDto;
import com.metaxiii.escalade.model.Topo;
import com.metaxiii.escalade.repository.TopoRepository;
import com.metaxiii.escalade.service.IReservationService;
import com.metaxiii.escalade.service.ITopoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TopoServiceImpl extends AbstractController implements ITopoService {
    private final TopoRepository topoRepository;

    @Autowired
    private IReservationService reservationService;

    @Override
    public List<Topo> findAllTopos() {
        return topoRepository.findAll();
    }

    @Override
    public Optional<Topo> findById(long id) {
        return topoRepository.findById(id);
    }

    @Override
    public void updateAvailableById(int id, boolean available) {
        topoRepository.updateTopo(id, available);
    }

    @Override
    public String updateTopoWithId(String id) {
        try {
            Optional<Topo> topoById = topoRepository.findById(Integer.parseInt(id));
            if (topoById.isPresent()) {
                reservationService.reservation(Long.parseLong(id), getUser().getId());
                topoById.get().setAvailable(false);
                topoRepository.save(topoById.get());
                return "La demande de réservation a bien été effectuée";
            } else {
                return "Une erreur s'est produite, veuillez réessayer plus tard";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur s'est produite, veuillez réessayer plus tard";
        }
    }

    @Override
    public Topo save(TopoDto topoDto) throws ParseException {
        Date dateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(topoDto.getDateParution());
        Topo topo       = new Topo();
        topo.setNom(topoDto.getNom());
        topo.setAvailable(true);
        topo.setDateParution(dateFormat);
        topo.setDescription(topoDto.getDescription());
        topo.setLieu(topoDto.getLieu());
        topo.setUserId(getUser().getId());
        return topoRepository.save(topo);
    }
}
