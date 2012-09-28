package org.cloudfoundry.samples.handson.ex5;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * A very basic controller for listing and inserting {@link Person} objects in an RDBMS.
 *
 * @author Eric Bottard
 * @author Florent Biville
 */
@Controller
public class PersonController {
	
	// TODO: configure the jdbcTemplate with an injected DataSource
//	private NamedParameterJdbcTemplate jdbcTemplate;
	
	// @Inject
//	public void setDataSource(DataSource dataSource) {
//		this.jdbcTemplate = ...
//	}
	
	@RequestMapping(value = "/ex5", method=RequestMethod.GET)
	public ModelAndView show(Person command) {
		ModelAndView mav = new ModelAndView("ex5-form");
		
		// TODO: retrieve persons and add them to the model
		// under key "persons"
		List<Person> persons = null;
		mav.addObject("persons", persons);
		
		return mav;
	}
	
	public String add(Person person, Errors errors, RedirectAttributes redirectAttributes) {
		
		// TODO: save the person POJO in the db using a JdbcTemplate
		
		return "redirect:/ex5";
	}

}
