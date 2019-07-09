package kr.inek.tanbbang01.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import kr.inek.tanbbang01.exception.DeptNotFoundException;
import kr.inek.tanbbang01.exception.WorkerNotFoundException;
import kr.inek.tanbbang01.model.Dept;
import kr.inek.tanbbang01.model.Worker;
import kr.inek.tanbbang01.repository.DeptRepository;
import kr.inek.tanbbang01.repository.WorkerRepository;
import kr.inek.tanbbang01.service.WorkerService;


@RestController
public class WorkerController {

	@Autowired
	private WorkerService workerSerivce;
	
	//GET /jpa/workers
	@GetMapping("/jpa/workers")
	public List<Worker> retrieveAllWorkers() {
		return workerSerivce.retrieveAllWorkers();
	}

	// GET /jpa/workers/{id}
	@GetMapping("/jpa/workers/{id}")
	public Resource<Worker> retrieveWorker(@PathVariable Long id) {
		return workerSerivce.retrieveWorker(id);
	}

	// Created Worker
	// input - details of workers
	// output - created & Return the created URI

	// GET  http://localhost:8080/jpa/workers
	// body : { "loginId": "tanbbang01", "name": "황인성", "isActive": 1, "password": "abcde", "mobilePhoneNo": "0101234444", "email": "tanbbang03@inek.co.kr", "isAccessibleToPatron": 1,"isSuperadmin": 1,  "lastUpdatorId" : 1, "expiryDate" : "2099-01-19T04:29:24", "dateCreated" : "2001-01-19T04:29:24", "lastUpdated" : "2001-02-19T04:29:24" }
	
	//HEATEOAS 
	// Hyper Media as the engine of application state
	@PostMapping("/jpa/workers")
	public ResponseEntity<Worker> createWorker(@Valid @RequestBody Worker worker) {
		return workerSerivce.createWorker(worker);
	}
	
	@DeleteMapping("/jpa/workers/{id}")
	public void deleteWorker(@PathVariable Long id) {
		workerSerivce.deleteWorker(id);
	}
}
