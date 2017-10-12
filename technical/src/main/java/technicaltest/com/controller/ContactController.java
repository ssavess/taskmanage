package technicaltest.com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import technicaltest.com.entity.ContactEntity;
import technicaltest.com.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	
	@GetMapping("/all-contacts")
	public String getAllContacts(HttpServletRequest request){
		request.setAttribute("contacts",contactService.getAllContacts());
		request.setAttribute("mode", "MODE_CONTACTS");
		return "index";

	}
	
	
	@RequestMapping("/get-contact/{firstName}")
	public List<ContactEntity> getcontact(@PathVariable (value="firstName") String firstName){
		return contactService.getcontact(firstName);
	}
	
	
	@GetMapping("/new-contact")
	public String addContact(){
		return "ADD Feito";
	}
	
	
	@PostMapping("/save-contact")
	//@RequestMapping(method=RequestMethod.POST, value="/save-contact")
	public boolean addContactSave(@RequestBody ContactEntity contact){
		
		return contactService.addContact( contact);
	}
	
	@GetMapping("/edit-contact")
	public String editContact(@RequestParam String email, HttpServletRequest request){
		request.setAttribute("task", contactService.getcontact(email));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	
	@GetMapping("/remove-contact")
	public String removeContact(@RequestParam String email, HttpServletRequest request){
		
		contactService.removeContact(email);
		request.setAttribute("contacts", contactService.getAllContacts());
		request.setAttribute("mode", "MODE_CONTACTS");
		return "index";
		
	}
}
