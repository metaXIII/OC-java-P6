package com.metaxiii.escalade.service;

import com.metaxiii.escalade.dto.TopoDto;
import com.metaxiii.escalade.model.Topo;

import java.util.List;
import java.util.Optional;

public interface ITopoService {
	List<Topo> findAllTopos();

	Optional<Topo> findById(int id);

	void updateAvailableById(int id, boolean available);

	String updateTopoWithId(String id);

	Topo save(TopoDto topoDto);
}
