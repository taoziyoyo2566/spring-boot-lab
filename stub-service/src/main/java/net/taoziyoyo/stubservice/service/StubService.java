package net.taoziyoyo.stubservice.service;

import net.taoziyoyo.stubservice.model.Stub;
import net.taoziyoyo.stubservice.repository.StubRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StubService {
    final StubRepository stubRepository;

    public StubService(StubRepository stubRepository) {
        this.stubRepository = stubRepository;
    }

    public List<Stub> getAll() {
        return stubRepository.findAll();
    }

    public Stub save(Stub stub) {
        if (stub.getId() == null) {
            stub.setCreatedAt(LocalDateTime.now());
        } else {
            stub.setUpdatedAt(LocalDateTime.now());
        }
        return stubRepository.save(stub);

    }
}
