package technicaltest.com.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import technicaltest.com.entity.ActivityEntity;

import technicaltest.com.repository.ActivityRepository;

@Service
@Transactional
public class ActivityService {
	
	@Autowired
	private ActivityRepository  activityRepository;
	
	//mostrar todas actividas no sistema e seu contacto
	public List<ActivityEntity> getAllActivity() {
		List<ActivityEntity> aux = new ArrayList<>();
		activityRepository.findAll()
		.forEach(aux::add);
		return aux;
	

	}
	
	//apenas com DATA
	public void createActiviteSemContactoo() {

	}
	
	//adiciona activity
	//colocar automaticamente todos os detalhes do contacto
	public void addActivity() {

	}
	
	//edita actitity
	public void editActivity() {

	}
	
	//remove activity
	public void removeActivity() {

	}

	//todas as actividades daquele contacto
	public void getAllActivityContact() {

	}
	
	//procura activitys por subject==title
	public void getActivitySubject() {
		

	}
}