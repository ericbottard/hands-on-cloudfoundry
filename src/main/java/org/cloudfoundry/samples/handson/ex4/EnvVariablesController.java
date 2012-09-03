package org.cloudfoundry.samples.handson.ex4;

import java.io.PrintWriter;

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
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();
		// ...
	}

}
