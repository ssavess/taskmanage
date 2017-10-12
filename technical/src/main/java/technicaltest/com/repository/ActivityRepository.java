package technicaltest.com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import technicaltest.com.entity.ActivityEntity;

public interface ActivityRepository  extends CrudRepository<ActivityEntity, String>{

}
