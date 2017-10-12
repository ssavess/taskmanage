package technicaltest.com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import technicaltest.com.entity.ContactEntity;

public interface ContactRepository extends CrudRepository<ContactEntity, String>{
	
	//querie primeiro nome
	//List<ContactEntity> findAllByFirstName(String firstName);
	//querie ultimo nome
	//List<ContactEntity> findAllByContactEntityFirstNameIgnoreCase(String firstName);
	 List<ContactEntity> findByLastNameOrFirstNameAllIgnoreCase(String lastname, String firstname);
}
