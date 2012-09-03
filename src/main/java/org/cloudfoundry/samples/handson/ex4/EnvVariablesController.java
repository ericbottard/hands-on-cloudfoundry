package org.cloudfoundry.samples.handson.ex4;

import static java.lang.System.getenv;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EnvVariablesController {

	/**
	 * Use the out variable to dump the contents of the environment variables.
	 * 
	 * Notice how CloudFoundry instructs the app about services it provides
	 * inside variables named {@code VCAP_something}.
	 */
	@RequestMapping("/ex4")
	public void dump(HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		Map<String, String> envVars = getenv();
		StringBuilder variables = new StringBuilder();
		for(Entry<String,String> variable : envVars.entrySet()) {
			variables.append(variable.getKey());
			variables.append(" = ");
			variables.append(variable.getValue());
			variables.append("<br />");
		}
		response.setContentType("text/html");
		out.append(variables.toString());
		out.close();
	}

}
