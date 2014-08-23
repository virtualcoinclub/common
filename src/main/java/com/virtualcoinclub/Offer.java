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
 * <h1>Offer class (object for JSON transactions)</h1>
 * Object used by OfferTable
 * 
 * <p>
 *
 * @author  Eric Peterson
 * @version 1.0
 * @since   2014-08-23
 */
public class Offer {
    private int oid;
    private int kid;
    private int mid;
    private String description;
    private String askDescription;

    public Offer(int _oid, int _kid, int _mid, String _description, String _askDescription ) {
	oid = _oid;
	kid = _kid;
	mid = _mid;
	description = _description;
	askDescription = _askDescription;
    }
    
    public int getOID() {
	return oid;
    }

    public void setOID(int _oid) {
	oid = _oid;
    }

    public int getKID() {
	return kid;
    }

    public void setKID(int _kid) {
	kid = _kid;
    }

    public int getMID() {
	return mid;
    }

    public void setMID(int _mid) {
	mid = _mid;
    }

    public String getDescription() {
	return description;
    }
    
    public void setDescription(String _description) {
	description = _description;
    }
    
    public String getAskDescription() {
	return askDescription;
    }
    
    public void setAskDescription(String _askDescription) {
	askDescription = _askDescription;
    }
    
    public String toJSON() {
	return "{" + 
	    "\"oid\" : \"" + oid + "\", " + 
	    "\"kid\" : \"" + kid + "\", " + 
	    "\"mid\" : \"" + mid + "\", " + 
	    "\"description\" : \"" + description + "\", " + 
	    "\"askDescription\" : \"" + askDescription + "\"" + 
	    "}";
    }
    
}
