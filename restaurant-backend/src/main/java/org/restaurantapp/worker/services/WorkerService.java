package org.restaurantapp.worker.services;

import lombok.RequiredArgsConstructor;
import org.restaurantapp.auth.domain.role.Role;
import org.restaurantapp.auth.domain.role.service.RoleService;
import org.restaurantapp.auth.domain.user.User;
import org.restaurantapp.auth.domain.user.service.UserRoleService;
import org.restaurantapp.auth.domain.user.service.UserService;
import org.restaurantapp.worker.dto.WorkerDataFormDto;
import org.restaurantapp.worker.domain.Worker;
import org.restaurantapp.worker.repository.WorkerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WorkerService {
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final RoleService roleService;
    private final WorkerRepository workerRepository;
    @Transactional
    public Worker create(WorkerDataFormDto workerDataFormDto) {
        User registeredUser = userService.create(workerDataFormDto.registerUserData());

        Role roleToAssign = roleService.findByName(workerDataFormDto.role());
        userRoleService.createUserRole(registeredUser,roleToAssign);
        Worker newWorker = buildWorkerData(registeredUser,workerDataFormDto.pesel(),workerDataFormDto.hourlyRate());

        return workerRepository.save(newWorker);
    }

    private Worker buildWorkerData(User registeredUser, String pesel, BigDecimal hourlyRate) {
        return Worker.builder()
                .user(registeredUser)
                .pesel(pesel)
                .hourlyRate(hourlyRate)
                .build();
    }
}
