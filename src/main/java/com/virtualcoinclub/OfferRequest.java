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
 * <h1>OfferRequest class (object for JSON transactions)</h1>
 * Object used to update array of Offers in back end
 * 
 * <p>
 * Front end usage: 
 * <pre><code>
 * OfferRequest oreq = new OfferRequest(session.getSID(), session.getMID());
 * oreq.setAction("withdraw");
 * String[] oids = request.getParameterValues("oids");
 * if (oids != null) {
 *   oreq.setOIDs(oids);
 *   jsonBody = oreq.toJSON();
 *   // Send jsonbody to back end.
 * </code></pre>
 * <p>
 * Back end usage: 
 * <pre><code>
 * OfferRequest req = gson.fromJson(reader, OfferRequest.class);
 * String action = req.getAction();
 * int[] oids = req.getOIDs();
 * if (action.equals("withdraw")) {
 * ...
 * </code></pre>
 * <p>
 *
 * @author  Eric Peterson
 * @version 1.0
 * @since   2014-08-23
 */
public class OfferRequest {
    private String sid;
    private int mid;
    private int[] oids;
    private String action;
    private String data;
    private String result;

    public OfferRequest(String _sid, int _mid) {
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
    
    public void setOIDs(int[] _oids) {
	oids = _oids;
    }

    public void setOIDs(String[] _oids) {
	int[] values = new int[_oids.length];  
	for(int i = 0; i < _oids.length; i++)  
	    values[i] = Integer.parseInt(_oids[i]); 
	oids = values;
    }

    public int[] getOIDs() {
	return oids;
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
	json = json + "\", \"oids\" : [";
	if (oids != null) {
	    for( int i = 0; i < oids.length; i++)  {
		json = json + "\"";
		json = json + oids[i];
		if (i < oids.length - 1)
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
