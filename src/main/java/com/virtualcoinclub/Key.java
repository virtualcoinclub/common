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
 * <h1>Key (object for JSON transactions)</h1>
 * Used as part of KeyTable
 * 
 * <p>
 * Sample usage: 
 * <pre><code>
 * Key key = new Key(addressString, compAddressString, pubKeyString, encPrivKeyString);
 * </code></pre>
 * <p>
 *
 * @author  Eric Peterson
 * @version 1.0
 * @since   2014-08-23
 */
public class Key {
    private int kid;
    private boolean verified;
    private boolean locked;
    private String address;
    private String caddress;
    private String pubKey;
    private String encPrivKey;
    private String status;

    public Key(String addr, String caddr, String pbk, String epvk) {
	verified = false;
	locked = false;
	address = addr;
	caddress = caddr;
	pubKey = pbk;
	encPrivKey = epvk;
	status = "ok";
    }
    
    public int getKID() {
	return kid;
    }

    public void setKID(int _kid) {
	kid = _kid;
    }

    public String getAddress() {
	return address;
    }
    
    public String getCompressedAddress() {
	return caddress;
    }
    
    public String getPubKey() {
	return pubKey;
    }
    
    // show first and last 8 bytes (16 hex chars)
    public String getPartialPubKey() {
	return pubKey.substring(0,16) + "..." + pubKey.substring(114);
    }
    
    public String getEncPrivKey() {
	return encPrivKey;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String stat) {
	status = stat;
    }

    public boolean getVerified() {
	return verified;
    }

    public void setVerified(boolean state) {
	verified = state;
    }

    public boolean getLocked() {
	return locked;
    }

    public void setLocked(boolean state) {
	locked = state;
    }

    public String toJSON() {
	return "{\"kid\" : \"" + kid +
	    "\", \"verified\" : \"" + verified +
	    "\", \"locked\" : \"" + locked +
	    "\", \"address\" : \"" + address +
	    "\", \"caddress\" : \"" + caddress +
	    "\", \"pubKey\" : \"" + pubKey +
	    "\", \"encPrivKey\" : \"" + encPrivKey +
	    "\", \"status\" : \"" + status +  "\"}";
    }
    
}
