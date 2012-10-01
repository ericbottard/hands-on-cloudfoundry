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
