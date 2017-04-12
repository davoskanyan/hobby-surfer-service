package me.hobbier.endpoint;

import me.hobbier.model.Hobby;
import me.hobbier.service.HobbierInternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author lilit.abrahamyan on 11/3/2016.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/hobbies")
public class HobbierServiceController {

	private final HobbierInternalService hobbierService;


	@Autowired
	public HobbierServiceController(HobbierInternalService hobbierService) {
		this.hobbierService = hobbierService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Set<Hobby> getHobbies() {
		return hobbierService.getHobbies();
	}

}
