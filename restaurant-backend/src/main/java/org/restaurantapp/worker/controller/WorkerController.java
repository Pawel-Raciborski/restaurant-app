package org.restaurantapp.worker.controller;

import lombok.RequiredArgsConstructor;
import org.restaurantapp.worker.dto.WorkerDataFormDto;
import org.restaurantapp.worker.dto.WorkerDto;
import org.restaurantapp.worker.mapper.WorkerMapper;
import org.restaurantapp.worker.services.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workers")
@RequiredArgsConstructor
public class WorkerController {
    private final WorkerService workerService;
    @PostMapping("/add")
    @Transactional
    public ResponseEntity<WorkerDto> create(WorkerDataFormDto workerToRegister){
        WorkerDto createdWorker = WorkerMapper.INSTANCE.mapFromEntity(workerService.create(workerToRegister));

        return ResponseEntity.status(HttpStatus.CREATED).body(createdWorker);
    }
}
