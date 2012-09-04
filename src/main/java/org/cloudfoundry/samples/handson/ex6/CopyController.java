package org.cloudfoundry.samples.handson.ex6;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.cloudfoundry.samples.handson.ex5.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * This exercise shows what happens if you have two services of the same "kind"
 * (here two RDBMS {@link DataSource DataSources}) in your app. Uncomment the
 * injection part and add an second DataSource to your context and see it fail
 * on CloudFoundry.
 * 
 * @author Eric Bottard
 * 
 */
@Controller
public class CopyController {

	private NamedParameterJdbcTemplate fromTemplate;

	private NamedParameterJdbcTemplate toTemplate;

	// @Inject
	@Qualifier("fromDataSource")
	public void setFromDataSource(DataSource dataSource) {
		this.fromTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	// @Inject
	@Qualifier("toDataSource")
	public void setToDataSource(DataSource dataSource) {
		this.toTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	/**
	 * Displays the list of {@link Person Persons} in the destination DB and a
	 * button to trigger the copy mechanism.
	 */
	@RequestMapping(value = "/ex6", method = RequestMethod.GET)
	public ModelAndView displayDestinationData() {
		ModelAndView mav = new ModelAndView("ex6-form");
		Map<String, Object> params = Collections.emptyMap();
		List<Person> persons = toTemplate.queryForList("select * from Persons",
				params, Person.class);
		mav.addObject("persons", persons);
		return mav;
	}

	/**
	 * Actually performs the copy and redirects to the list.
	 */
	@RequestMapping(value = "/ex6", method = RequestMethod.POST)
	public String copy() {
		Map<String, Object> params = Collections.emptyMap();
		List<Person> persons = fromTemplate.queryForList(
				"select * from Persons", params, Person.class);
		for (Person p : persons) {
			toTemplate
					.update("insert into Persons(firstName, lastName, age) values (:firstName, :lastName, :age)",
							new BeanPropertySqlParameterSource(p));
		}
		return "redirect:/ex6";
	}

}
