package net.taoziyoyo.stubservice.config;

import net.taoziyoyo.stubservice.model.Stub;
import net.taoziyoyo.stubservice.service.StubService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInit implements CommandLineRunner {

    private final StubService stubService;
    public DbInit(StubService stubService) {
        this.stubService = stubService;
    }
    /**
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {

        Stub stub1 = Stub.builder().description("cloth").build();
        Stub stub2 = Stub.builder().description("cloth 2").build();
        Stub stub3 = Stub.builder().description("cloth 3").build();
        stubService.save(stub1);
        stubService.save(stub2);
        stubService.save(stub3);
    }
}
