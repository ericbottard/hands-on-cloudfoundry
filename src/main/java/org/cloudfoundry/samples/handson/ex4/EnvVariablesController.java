package org.cloudfoundry.samples.handson.ex4;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EnvVariablesController {

	@RequestMapping("/ex4")
	public void dump(PrintWriter out) throws Exception {
		//...
	}
	
	
}
