package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.controller.AbstractController;
import com.metaxiii.escalade.dto.TopoDto;
import com.metaxiii.escalade.model.Topo;
import com.metaxiii.escalade.repository.TopoRepository;
import com.metaxiii.escalade.service.IReservationService;
import com.metaxiii.escalade.service.ITopoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class TopoServiceImpl extends AbstractController implements ITopoService {
    private final transient TopoRepository topoRepository;

    private final transient IReservationService reservationService;

    @Override
    public List<Topo> findAllTopos() {
        return topoRepository.findAll();
    }

    @Override
    public Optional<Topo> findById(long id) {
        return topoRepository.findById(id);
    }

    @Override
    public String updateTopoWithId(String id) {
        try {
            Optional<Topo> topoById = topoRepository.findById(Integer.parseInt(id));
            if (topoById.isPresent()) {
                topoById.get().setAvailable(!topoById.get().isAvailable());
                if (!topoById.get().isAvailable())
                    reservationService.reservation(Long.parseLong(id), getUser().getId());
                topoRepository.save(topoById.get());
                return "La demande de réservation a bien été effectuée";
            } else {
                return "Une erreur s'est produite, veuillez réessayer plus tard";
            }
        } catch (Exception e) {
            log.error(e.getMessage());
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

    @Override
    public List<Topo> findAllByUserId(long id) {
        return topoRepository.findAllByUserId(id);
    }

    @Override
    public void setAvailable(long id) {
        Optional<Topo> topo = topoRepository.findById(id);
        if (topo.isPresent()) {
            topo.get().setAvailable(!topo.get().isAvailable());
            topoRepository.save(topo.get());
        }
    }
}
