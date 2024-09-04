package org.restaurantapp.worker.repository;

import org.restaurantapp.worker.domain.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker,Integer> {
}
