package org.cloudfoundry.samples.handson.ex5;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * A very basic controller for listing and inserting {@link Person} objects in an RDBMS.
 *
 * @author Eric Bottard
 * @author Florent Biville
 * 
 * P.S.: don't do this at home ;)
 *
 */
@Controller
public class PersonController {
    public static final String EXERCISE_5 = "/ex5";

    private final DataSource dataSource;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public PersonController(@Qualifier("fromDataSource") DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new NamedParameterJdbcTemplate(this.dataSource);
    }

    @RequestMapping(value = EXERCISE_5, method = GET)
    public ModelAndView show(Person command) {
        ModelAndView mav = new ModelAndView("ex5-form");
        List<Person> persons = jdbcTemplate.query(
                "SELECT firstName, lastName, age FROM Persons", //
                new HashMap<String,Object>(), //
                new BeanPropertyRowMapper<Person>(Person.class)
        );
        mav.addObject("persons", persons);
        return mav;
    }

    @RequestMapping(value = EXERCISE_5, method = POST)
    public String add(Person person, Errors errors, RedirectAttributes redirectAttributes) {

        jdbcTemplate.update(
                "INSERT INTO Persons(firstName, lastName, age) " + //
                        "VALUES (:firstName,:lastName,:age)", //
                new BeanPropertySqlParameterSource(person)
        );

        return "redirect:" + EXERCISE_5;
    }

}
