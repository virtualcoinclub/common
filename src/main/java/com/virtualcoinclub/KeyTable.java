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
 * <h1>KeyTable (object for JSON transactions)</h1>
 * Object used to return key from back to front end
 * 
 * <p>
 * Back end code usage: 
 * <pre><code>
 * KeyTable kt = allSQL.getKeyTable(mid, klimit);
 * ... (in getKeyTable)
 * Key key = new Key(address, cAddress, pubKey, encPrivKey);
 * // Set other Key attributes.
 * keyTable.addKey(key);
 * </code></pre>
 * <p>
 *
 * @author  Eric Peterson
 * @version 1.0
 * @since   2014-08-23
 */
public class KeyTable {

    private Key[] keys;
    private int maxKeys;
    private int numKeys = 0;

    public KeyTable(int max) {
	maxKeys = max;
	keys = new Key[max];
    }
    
    public KeyTable(Key[] _keys) {
	maxKeys = _keys.length;
	numKeys = _keys.length;
	keys = _keys;
    }
    
    public void addKey(Key key) {
	if (numKeys < maxKeys) {
	    keys[numKeys] = key;
	    numKeys++;
	}
    }

    public String toHTML() {
	int numKey;
	String html = "<TABLE>";
	if (numKeys > 0) {
	    html = html + "<TR><TH></TH><TH>V</TH><TH>L</TH><TH>KID</TH><TH>address</TH><TH>compressed address</TH><TH>encrypted private key</TH></TR>\n";
	    for (numKey = 0; numKey < numKeys; numKey++) {
		Key key = keys[numKey];
		if (key != null) {
		    html = html + "<TR><TD><INPUT TYPE=\"checkbox\" WIDTH=\"12\" ID=\"key_\"";
		    html = html + key.getKID() + "\" NAME=\"kids\" VALUE=\"";
		    html = html + key.getKID() + "\">";
		    if (key.getVerified())
			html = html + "</TD><TD>Y";
		    else
			html = html + "</TD><TD>N";
		    if (key.getLocked())
			html = html + "</TD><TD>Y";
		    else
			html = html + "</TD><TD>N";
		    html = html + "</TD><TD><A HREF=\"kd" + key.getKID() + "\">" + key.getKID() + "</A>";
		    html = html + "</TD><TD>" + key.getAddress();
		    html = html	+ "</TD><TD>" + key.getCompressedAddress();
		    html = html	+ "</TD><TD>" + key.getEncPrivKey();
		    html = html	+ "</TD></TR>\n";
		}
	    }
	}
	html = html + "</TABLE>";
	return html;
    }

    public String toJSON() {
	int numKey;
	String json = "[";
	if (numKeys > 0) {
	    for (numKey = 0; numKey < numKeys; numKey++) {
		Key key = keys[numKey];
		if (key != null) {
		    json = json + key.toJSON();
		}
		if (numKey < numKeys - 1)
		    json = json + ",";
	    }
	}
	json = json + "]";
	return json;
    }
    
}
