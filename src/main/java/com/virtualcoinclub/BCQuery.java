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
 * @author  Eric Peterson
 * @version 1.0
 * @since   2014-08-23
 */
public class BCQuery {
    private long id;
    private String method;
    private String val;

    public BCQuery(long _id, String _method) {
	id = _id;
	method = _method;
    }

    public boolean validate() {
	return true;
    }

    public String getValue() {
	return val;
    }
    
    public String toJSON() {
	return "{\"id\" : \"" + id + "\", \"method\" : \"" + method + "\"}";
    }

}
