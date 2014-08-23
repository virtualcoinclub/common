/************************************************************************
Copyright 2014 Eric Peterson

Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
************************************************************************/
package com.virtualcoinclub.common;

import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>Common Utilities for front and back end</h1>
 *
 * Created for convenience but more specifically to utilize the same
 * member provided string cleanup on the fron and back ends.  This is
 * mainly to make sure that already-used member names are not reused,
 * but the functions themselves are to prevent SQL injection or other
 * abuse of the database.
 * <p>
 *
 * @author  Eric Peterson
 * @version 1.0
 * @since   2014-08-22
 */
public class Utility {

    private static Logger logger = LoggerFactory.getLogger("Utility.class");

    /**
     * Strips all special characters from the input.  Prevents SQL
     * injection and keeps junk characters out of the database.
     * Prevent member from using unprintable or other characters that
     * could cause confusion when comparaing user names.
     * @param input String to be cleaned
     * @return String Cleaned string
     */
    public static String stripSpecial(String input) {
	String cleaned = input.replaceAll("[^a-zA-Z0-9_ ]", "");
	return cleaned;
    }

    /**
     * Turns all instances of more than one space into a single space.
     * This prevents members from creating names that are identical to
     * other names except for the number of spaces.
     * @param input String to be condensed
     * @return String Condensed string
     */
    public static String condenseSpaces(String input) {
	String cleaned = input.replaceAll(" +", " ");
	return cleaned;
    }

    /**
     * Utility function to log HTTP requests
     * @param input String to be condensed
     * @return none
     */
    public static void printRequest(String method, HttpServletRequest request)
    {
	Enumeration e = request.getParameterNames();
	
	logger.info( "=== start === " + method + " request: " + request.getRequestURI());
	while (e.hasMoreElements())
	    {
		String name = (String) e.nextElement();         
		String[] values = request.getParameterValues(name);
		if (values.length == 1) {
		    logger.info( name + " : " + values[0]);
		}
		else {
		    StringBuffer sb = new StringBuffer();
		    sb.append(name);
		    sb.append(" : [");
		    for (String value: values) {
			sb.append(value + ",");
		    }
		    sb.append("]");
		    logger.info(sb.toString());
		}
	    }  
	logger.info("=== end ===");
    }
    
}
