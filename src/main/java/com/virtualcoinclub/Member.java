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
 * <h1>Member class (object for JSON transactions)</h1>
 * Object for sending new member info such as the password to the back end.
 * 
 * <p>
 * Front end usage: 
 * <pre><code>
 * Member member = new Member(screen, emailaddr, pwd1, name, 0);
 * String jsonBody = member.toJSON();
 * // Send jsonbody to back end.
 * </code></pre>
 * <p>
 * Back end usage: 
 * <pre><code>
 * Member member = gson.fromJson(reader, Member.class);
 * // Generate random salt.
 * byte[] hash = pbkdf2Hash.calculateHash(salt, member.getPassword());
 * // Add member name, salt, hash, etc. to database.
 * </code></pre>
 * <p>
 *
 * @author  Eric Peterson
 * @version 1.0
 * @since   2014-08-23
 */
public class Member {
    private String screen;
    private String emailaddr;
    private String password;
    private String name;
    private int mid;

    public Member(String _screen, String _emailaddr, String _password, String _name, int _mid) {
	screen = _screen;
	emailaddr = _emailaddr;
	password = _password;
	name = (_name == null ? "" : _name);
	mid = _mid;
    }
    
    public String getScreenName() {
	return screen;
    }
    
    public String getEmailAddr() {
	return emailaddr;
    }
    
    public String getPassword() {
	return password;
    }
    
    public String getName() {
	return name;
    }
    
    public int getMID() {
	return mid;
    }
    
    public String toJSON() {
	return "{\"screen\" : \"" + screen + "\", \"emailaddr\" : \"" + emailaddr +
	    "\", \"password\" : \"" + password + "\", \"name\" : \"" + name + 
	    "\", \"mid\" : \"" + mid + "\"}";
    }
    
}
