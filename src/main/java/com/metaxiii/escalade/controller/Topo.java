package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.dto.TopoDto;
import com.metaxiii.escalade.service.IDepartementService;
import com.metaxiii.escalade.service.ITopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Topo {
	@Autowired
	private ITopoService        topoService;
	@Autowired
	private IDepartementService departementService;

	@RequestMapping("/topo")
	public ModelAndView topo() {
		return new ModelAndView("topo", "results", topoService.findAllTopos());
	}

	@GetMapping("/reservation-topo/{id}")
	@ResponseBody
	public ModelAndView reservation(@PathVariable String id) {
		String msg = topoService.updateTopoWithId(id);
		return new ModelAndView("index", "msg", msg);
	}

	@GetMapping("/account/new-topo")
	public ModelAndView newTopo(Model model) {
		Map<String, Object> data = new HashMap<>();
		data.put("new", "Nouveau topo");
		data.put("departement_list", departementService.findAllDepartement());
		return new ModelAndView("topo", "data", data);
	}

	@PostMapping("/account/new-topo")
	public ModelAndView saveTopo(Model model, @ModelAttribute("site") TopoDto topoDto) {
		topoService.save(topoDto);
		String msg = "Merci pour votre participation";
		return new ModelAndView("index", "msg", msg);
	}
}
