package kr.inek.tanbbang01.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import kr.inek.tanbbang01.model.Worker;

public interface WorkerService {
//전체 Workers
	public List<Worker> retrieveAllWorkers();
	
	// 특정 Worker
	public Resource<Worker> retrieveWorker(@PathVariable Long id);
	
	// Save WOrker
	public ResponseEntity<Worker> createWorker(@Valid @RequestBody Worker worker);
	
	// Delete Worker
	public void deleteWorker(@PathVariable Long id);
}
