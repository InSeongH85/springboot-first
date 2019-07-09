package kr.inek.tanbbang01.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import kr.inek.tanbbang01.controller.DeptController;
import kr.inek.tanbbang01.exception.DeptNotFoundException;
import kr.inek.tanbbang01.model.Dept;
import kr.inek.tanbbang01.repository.DeptRepository;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptRepository deptRepository;
	
	@Override
	public List<Dept> retrieveAllDepts() {
		return deptRepository.findAll();
	}

	@Override
	public Resource<Dept> retrieveDept(Long id) {
		Optional<Dept> dept = deptRepository.findById(id);
		if (!dept.isPresent())
			throw new DeptNotFoundException("id - " + id);
		
		// "all-depts", SERVER_PATH + "/depts"
		//HATEOAS
		Resource<Dept> resource = new Resource<Dept>(dept.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(DeptController.class).retrieveAllDepts());
		resource.add(linkTo.withRel("all-depts"));
		return resource;
	}

	@Override
	public ResponseEntity<Dept> createDept(@Valid Dept dept) {
		Dept savedDept = deptRepository.save(dept);
		// Created
		URI location = ServletUriComponentsBuilder
											.fromCurrentRequest()
											.path("/{id}")
											.buildAndExpand(savedDept.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@Override
	public void deleteDept(Long id) {
		deptRepository.deleteById(id);
	}

}
