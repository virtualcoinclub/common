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
 * <h1>KeyRequest (object for JSON transactions)</h1>
 *
 * Created to send action requests from the front end to the back end
 * for an array of key IDs.
 * <p>
 * Sample usage: 
 * <pre><code>
 * KeyRequest kreq = new KeyRequest(session.getSID(), session.getMID());
 * kreq.setAction("convert");
 * kreq.setData("48");
 * // Get array of key ids from HTML form.
 * String[] kids = request.getParameterValues("kids");
 * String jsonBody = kreq.toJSON();
 * StringEntity entity = new StringEntity(jsonBody, "UTF-8");
 * // Set entity in HttpPost object and execute.
 * </code></pre>
 * <p>
 *
 * @author  Eric Peterson
 * @version 1.0
 * @since   2014-08-23
 */
public class KeyRequest {
    private String sid;
    private int mid;
    private int[] kids;
    private String action;
    private String data;
    private String result;

    public KeyRequest(String _sid, int _mid) {
	sid = _sid;
	mid = _mid;
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
    
    public void setKIDs(int[] _kids) {
	kids = _kids;
    }

    public void setKIDs(String[] _kids) {
	int[] values = new int[_kids.length];  
	for(int i = 0; i < _kids.length; i++)  
	    values[i] = Integer.parseInt(_kids[i]); 
	kids = values;
    }

    public int[] getKIDs() {
	return kids;
    }

    public void setData(String _data) {
	data = _data;
    }

    public String getData() {
	return data;
    }

    public void setAction(String _action) {
	action = _action;
    }

    public String getAction() {
	return action;
    }

    public void setResult(String _result) {
	result = _result;
    }

    public String getResult() {
	return result;
    }

    public String toJSON() {
	String json = "{";
	json = json + "\"sid\" : \"" + sid;
	json = json + "\", \"mid\" : \"" + mid;
	json = json + "\", \"kids\" : [";
	if (kids != null) {
	    for( int i = 0; i < kids.length; i++)  {
		json = json + "\"";
		json = json + kids[i];
		if (i < kids.length - 1)
		    json = json + "\",";
		else
		    json = json + "\"";
	    }
	}
	json = json + "]";
	json = json + ", \"action\" : \"" +  action;
	json = json + "\", \"data\" : \"" +  data;
	json = json + "\", \"result\" : \"" +  result;
	json = json + "\"}";
	return json;
    }
    
}
