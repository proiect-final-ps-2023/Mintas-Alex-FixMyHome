package com.projectsd.services.service;

import com.projectsd.services.model.Worker;
import com.projectsd.services.repository.WorkerRepository;
import com.projectsd.services.service.implementation.WorkerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class WorkerServiceTest {
    @Mock
    private WorkerRepository workerRepository;
    @InjectMocks
    private WorkerService workerService;

/*    @BeforeEach
    void init() {

        workerService = new WorkerService(workerRepository);

        Worker worker01 = new Worker("Alex", "Mintas", "alexmintas@yahoo.ro", "0740933344", 21);
        Worker worker02 = new Worker("Oana", "Morar", "oanamorar@yahoo.ro", "0740344521", 22);
        Worker worker03 = new Worker("Mihai", "Mic", "mihaimic@yahoo.com", "0726977211", 26);

        workerService.createWorker(worker01);
        workerService.createWorker(worker03);
    }*/

    @Test
    public void createWorkerTest() {
        Worker worker = new Worker();
        worker.setEmail("SteamAlex12@yahoo.ro");

        when(workerRepository.save(ArgumentMatchers.any(Worker.class))).thenReturn(worker);

        Worker createdWorker = workerService.createWorker(worker);

        assertThat(createdWorker.getEmail()).isSameAs(worker.getEmail());
        verify(workerRepository).save(worker);
    }

/*    @Test
    public void getWorkersTest() {
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker());

        given(workerRepository.findAll()).willReturn(workers);

        List<Worker> expected = workerService.getWorkers(10).stream().toList();

        assertEquals(expected, workers);
        verify(workerRepository).findAll(PageRequest.of(0, 10));
    }*/

/*    @Test
    public void whenGivenId_shouldDeleteWorker_ifFound() {
        Worker worker = new Worker();

        worker.setFirstName("Alex");
        worker.setId(1L);

        when(workerRepository.findById(worker.getId())).thenReturn(Optional.of(worker));
        workerService.deleteWorker(worker.getId());

        verify(workerRepository).deleteById(worker.getId());
    }*/

/*    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_user_doesnt_exist() {
        Worker worker = new Worker();

        worker.setFirstName("Alex");
        worker.setId(89L);

        given(workerRepository.findById(anyLong())).willReturn(Optional.ofNullable(null));

        workerService.deleteWorker(worker.getId());
    }*/

/*    @Test
    public void updateWorkerTest() {
        Worker worker = new Worker();
        worker.setId(89L);
        worker.setFirstName("Alex");

        Worker newWorker = new Worker();
        newWorker.setFirstName("Oana");
        newWorker.setId(89L);

        given(workerRepository.findById(worker.getId())).willReturn(Optional.of(worker));

        workerService.updateWorker(newWorker);
        verify(workerRepository).save(newWorker);
        verify(workerRepository).findById(worker.getId());
    }*/

/*    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_worker_doesnt_exist() {
        Worker worker = new Worker();
        worker.setId(89L);
        worker.setFirstName("Alex");

        Worker newWorker = new Worker();
        newWorker.setId(90L);
        newWorker.setFirstName("Oana");

        given(workerRepository.findById(anyLong())).willReturn(Optional.ofNullable(null));
        workerService.updateWorker(newWorker);
    }*/

}
