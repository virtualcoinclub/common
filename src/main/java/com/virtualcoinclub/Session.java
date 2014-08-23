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
 * <h1>Session (object for JSON transactions)</h1>
 * Object holds the session info to send from the front to back end to
 * verify that it is legitimate
 * 
 * <p>
 * Front end usage: 
 * <pre><code>
 * // Send credientials to back end and get reply
 * Session returnedSession = gson.fromJson(reply, Session.class);
 * </code></pre>
 * <p>
 * Back end usage: 
 * <pre><code>
 * byte[] sid = new byte[SID_B_ARRAY_SIZE];
 * random.nextBytes(sid);
 * String sidString = PBKDF2Hash.toHex(sid);
 * Session session = new Session(sidString, mid);
 * ...
 * // Send to front end
 * writer.append(session.toJSON());
 * </code></pre>
 * <p>
 *
 * @author  Eric Peterson
 * @version 1.0
 * @since   2014-08-23
 */
public class Session {
    private String sid;
    private int mid;
    private int startID;
    private String screen;
    private String status;

    public Session(String _sid, int _mid) {
	sid = _sid;
	mid = _mid;
	status = "ok";
    }
    
    public String getSID() {
	return sid;
    }
    
    public void setSID(String _sid) {
	sid = _sid;
    }
    
    public int getMID() {
	return mid;
    }
    
    public void setMID(int _mid) {
	mid = _mid;
    }
    
    public int getStartID() {
	return startID;
    }
    
    public void setStartID(int _startID) {
	startID = _startID;
    }
    
    public String getStatus() {
	return status;
    }

    public void setStatus(String stat) {
	status = stat;
    }

    public String getScreen() {
	return screen;
    }

    public void setScreen(String screen_name) {
	 screen = screen_name;
    }

    public String toJSON() {
	return "{\"sid\" : \"" + sid + "\", \"mid\" : \"" + mid + "\", \"startID\" : \"" + startID +  "\", \"screen\" : \"" + screen +  "\", \"status\" : \"" + status +  "\"}";
    }
    
}
