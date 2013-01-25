/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
		
		// TODO: retrieve persons and add them to the model under key "persons"
		// cf. jdbcTemplate.query(sql, parameters, BeanPropertyRowMapper)
		List<Person> persons = null;
		mav.addObject("persons", persons);
		
		return mav;
	}
	
	@RequestMapping(value = "/ex5", method=RequestMethod.POST)
	public String add(Person person, Errors errors, RedirectAttributes redirectAttributes) {
		
		// TODO: save the person POJO in the db using a JdbcTemplate
		// cf. jdbcTemplate.update(sql, new BeanPropertySqlParameterSource)
		return "redirect:/ex5";
	}

}
