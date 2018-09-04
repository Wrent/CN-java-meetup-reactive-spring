package dk.cngroup.reactivespringintro.repository;

import dk.cngroup.reactivespringintro.model.JavaDev;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JavaMeetupRepository extends ReactiveMongoRepository<JavaDev, String> {

}
