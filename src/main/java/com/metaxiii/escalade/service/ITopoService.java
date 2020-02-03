package com.metaxiii.escalade.service;

import com.metaxiii.escalade.dto.TopoDto;
import com.metaxiii.escalade.model.Topo;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface ITopoService {
    List<Topo> findAllTopos();

    Optional<Topo> findById(long id);

    String updateTopoWithId(String id);

    Topo save(TopoDto topoDto) throws ParseException;

    List<Topo> findAllByUserId(long id);

    void setAvailable(long id);
}
