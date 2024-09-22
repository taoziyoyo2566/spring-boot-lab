package net.taoziyoyo.stubservice.repository;

import net.taoziyoyo.stubservice.model.Stub;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StubRepository extends ListCrudRepository<Stub,Long> {

}
