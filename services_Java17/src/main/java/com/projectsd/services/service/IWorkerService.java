package com.projectsd.services.service;

import com.projectsd.services.model.Worker;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface IWorkerService {
    Worker createWorker(Worker worker);

    Collection<Worker> getWorkers(int limit);

    Worker findWorkerById(Long id);

    Worker updateWorker(Worker worker);

    void deleteWorker(Long id);
}
