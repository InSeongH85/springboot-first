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

import kr.inek.tanbbang01.controller.WorkerController;
import kr.inek.tanbbang01.exception.WorkerNotFoundException;
import kr.inek.tanbbang01.model.Worker;
import kr.inek.tanbbang01.repository.WorkerRepository;

@Service
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	private WorkerRepository workerRepository;
	
	@Override
	public List<Worker> retrieveAllWorkers() {
		return workerRepository.findAll();
	}

	@Override
	public Resource<Worker> retrieveWorker(Long id) {
		Optional<Worker> worker = workerRepository.findById(id);
		if (!worker.isPresent())
			throw new WorkerNotFoundException("id - " + id);
		
		// "all-workers", SERVER_PATH + "/workers"
		//HATEOAS
		Resource<Worker> resource = new Resource<Worker>(worker.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(WorkerController.class).retrieveAllWorkers());
		resource.add(linkTo.withRel("all-workers"));
		
		return resource;
	}


	// Created Worker
	// input - details of workers
	// output - created & Return the created URI

	// GET  http://localhost:8080/jpa/workers
	// body : { "loginId": "tanbbang01", "name": "황인성", "isActive": 1, "password": "abcde", "mobilePhoneNo": "0101234444", "email": "tanbbang03@inek.co.kr", "isAccessibleToPatron": 1,"isSuperadmin": 1,  "lastUpdatorId" : 1, "expiryDate" : "2099-01-19T04:29:24", "dateCreated" : "2001-01-19T04:29:24", "lastUpdated" : "2001-02-19T04:29:24" }
	
	//HEATEOAS 
	// Hyper Media as the engine of application state
	
	@Override
	public ResponseEntity<Worker> createWorker(@Valid Worker worker) {
		Worker savedWorker = workerRepository.save(worker);
		// Created
		URI location = ServletUriComponentsBuilder
											.fromCurrentRequest()
											.path("/{id}")
											.buildAndExpand(savedWorker.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@Override
	public void deleteWorker(Long id) {
		workerRepository.deleteById(id);
	}

}
