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

/**
 * <h1>Query (object for JSON transactions)</h1>
 * Object used to ask back end if a screen name is available.
 * 
 * <p>
 * Sample usage: 
 * <pre><code>
 * Query query = new Query("available", "screen_name", sn);
 * String jsonBody = query.toJSON();
 * </code></pre>
 * <p>
 *
 * @author  Eric Peterson
 * @version 1.0
 * @since   2014-08-23
 */
public class Query {
    private String query;
    private String param;
    private String val;

    public Query(String q, String p, String v) {
	query = q;
	param = p;
	val = v;
    }

    public String getValue() {
	return val;
    }
    
    public String toJSON() {
	return "{\"query\" : \"" + query + "\", \"param\" : \"" + param + "\", \"val\" : \"" + val + "\"}";
    }

}
