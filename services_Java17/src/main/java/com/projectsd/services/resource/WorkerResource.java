package com.projectsd.services.resource;

import com.projectsd.services.model.Worker;
import com.projectsd.services.service.implementation.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/worker")
@RequiredArgsConstructor
public class WorkerResource {
    private final WorkerService workerService;

    @GetMapping("/getWorkers")
    public ResponseEntity<Collection<Worker>> getWorkers() {
        return new ResponseEntity<>(workerService.getWorkers(30), HttpStatus.OK);
    }

    @PostMapping("/createWorker")
    public ResponseEntity<Worker> createWorker(@RequestBody Worker worker) {
        return new ResponseEntity<>(workerService.createWorker(worker), HttpStatus.CREATED);
    }


    @GetMapping("/findWorkerById/{id}")
    public ResponseEntity<Worker> getWorker(@PathVariable("id") Long id) {
        return new ResponseEntity<>(workerService.findWorkerById(id), HttpStatus.OK);
    }

    @PutMapping("/updateWorker")
    public ResponseEntity<Worker> updateWorker(@RequestBody Worker worker) {
        return new ResponseEntity<>(workerService.updateWorker(worker), HttpStatus.OK);
    }


    @DeleteMapping("/deleteWorker/{id}")
    public ResponseEntity<?> deleteWorker(@PathVariable("id") Long id) {
        workerService.deleteWorker(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
