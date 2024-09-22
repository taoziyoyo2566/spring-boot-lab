package net.taoziyoyo.stubservice.controller;

import net.taoziyoyo.stubservice.model.Stub;
import net.taoziyoyo.stubservice.service.StubService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/stub")
@RestController
public class StubController {
    private final StubService stubService;

    public StubController(StubService stubService) {
        this.stubService = stubService;
    }

    @GetMapping("")
    public List<Stub> findAll(){
        return stubService.getAll();
    }
}
