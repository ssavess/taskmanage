package technicaltest.com.controller;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



import technicaltest.com.service.ActivityService;


@Controller
public class ActivityController {
	
	
	@Autowired
	private ActivityService activityService;
	
	
	@GetMapping("/all-activity")
	public String getAllActivity(HttpServletRequest request){
		request.setAttribute("activitys",activityService.getAllActivity());
		request.setAttribute("mode", "MODE_ACTIVITY");
		return "index";
	}

}
