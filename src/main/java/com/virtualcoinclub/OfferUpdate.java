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
 * <h1>OfferUpdate (object for JSON transactions)</h1>
 * Object to send information about an offer to the back end
 * (e.g. an update to the item_desc)
 * <p>
 * Sample usage: 
 * <pre><code>
 * OfferUpdate upd = gson.fromJson(reader, OfferUpdate.class);
 * int oid = upd.getOID();
 * String action = upd.getAction();
 * String data = upd.getData();
 * allSQL.updateOffer(oid, action, data);
 * </code></pre>
 * <p>
 *
 * @author  Eric Peterson
 * @version 1.0
 * @since   2014-08-23
 */
public class OfferUpdate {
    private String sid;
    private int mid;
    private int oid;
    private String action;
    private String data;
    private String result;

    public OfferUpdate(String _sid, int _mid) {
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
    
    public void setOID(int _oid) {
	oid = _oid;
    }

    public void setOID(String oidString) {
	oid = Integer.parseInt(oidString); 
    }

    public int getOID() {
	return oid;
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
	json = json + "\", \"oid\" : \"" + oid;
	json = json + "\", \"action\" : \"" +  action;
	json = json + "\", \"data\" : \"" +  data;
	json = json + "\", \"result\" : \"" +  result;
	json = json + "\"}";
	return json;
    }
    
}
