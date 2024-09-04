package org.restaurantapp.worker.controller;

import org.restaurantapp.worker.dto.WorkerDataFormDto;
import org.restaurantapp.worker.services.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workers")
public class WorkerController {
    WorkerService workerService;
    @PostMapping("/add")
    @Transactional
    public ResponseEntity<Void> add(WorkerDataFormDto workerDataFormDto){
        workerService.create(workerDataFormDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
