/**
 * 
 */
package com.blackbox.sharing.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author joseph
 *
 */
@RestController
@RequestMapping(value="/persons")
public class PersonRest {
	@RequestMapping(method=RequestMethod.GET)
	public String test() {
		return "Test working...";
	}
}