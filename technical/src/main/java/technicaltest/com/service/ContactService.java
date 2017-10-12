package technicaltest.com.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import technicaltest.com.entity.ContactEntity;
import technicaltest.com.repository.ContactRepository;

@Service
@Transactional
public class ContactService {
	
	@Autowired
	private ContactRepository contactReposity;
	
	//adiciona um contacto.
	//obrigatorio ter firstname lastname email
	public boolean addContact(ContactEntity contact) {
		if(!contactReposity.exists(contact.getEmailAddress())){
			contactReposity.save(new ContactEntity(contact.getFirstName(), contact.getLastName(), contact.getEmailAddress(),
					contact.getCity(),contact.getCity(),contact.getCity(),contact.getCity(),contact.getCity()));
			return true;
		}
		return false;
	}

	//edita um contacto existente
	public void editContact() {

	}

	//Remove um contacto
	public boolean removeContact(String string) {
		contactReposity.delete(string);
		if(contactReposity.exists(string))
			return false;
		else
			return true;
	}

	//mostra todos os contactos no systema
	public List<ContactEntity> getAllContacts() {
		List<ContactEntity> aux = new ArrayList<>();
		contactReposity.findAll()
		.forEach(aux::add);
		return aux;
	}

	//procura pelo primeiro ou ultimo nome
	public List<ContactEntity> getcontact(String firstName) {
		List<ContactEntity> aux = new ArrayList<>();
		contactReposity.findByLastNameOrFirstNameAllIgnoreCase(firstName,firstName )
		.forEach(aux::add);
		return aux;
	}

}
