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
 * Front end usage: 
 * <pre><code>
 * // Reply is String returned by sending "getmyoffers" to back end.
 * Offer[] offers = gson.fromJson(reply, Offer[].class);
 * OfferTable offerTable = new OfferTable(offers);
 * </code></pre>
 * <p>
 * Back end usage: 
 * <pre><code>
 * // Request "getmyoffers" sent.
 * AllSQL allSQL = new AllSQL();
 * ot = allSQL.getOfferTable(mid, 0, klimit);
 *
 * public OfferTable getOfferTable(int mid, int start, int klimit)
 * ...
 * Offer offer = new Offer(oid, kid, mid, description, askDescription);
 * offerTable.addOffer(offer);
 * ...
 * </code></pre>
 * <p>
 *
 * @author  Eric Peterson
 * @version 1.0
 * @since   2014-08-23
 */
public class OfferTable {

    private Offer[] offers;
    private int maxOffers;
    private int numOffers = 0;

    public OfferTable(int max) {
	maxOffers = max;
	offers = new Offer[max];
    }
    
    public OfferTable(Offer[] _offers) {
	maxOffers = _offers.length;
	numOffers = _offers.length;
	offers = _offers;
    }
    
    public void addOffer(Offer offer) {
	if (numOffers < maxOffers) {
	    offers[numOffers] = offer;
	    numOffers++;
	}
    }

    // When my_offers is true the descr and ask_descr are editable.
    // With my_offers false, we add a Bid column.
    public String toHTML(boolean myOffers) {
	int numOffer;
	String html = "<TABLE><TR><TH></TH><TH>KID</TH><TH>item_description</TH><TH>ask_description</TH>";
	if (!myOffers)
	    html = html + "<TH>Bid</TH>";
	html = html + "</TR>\n";
	if (numOffers > 0) {
	    for (numOffer = 0; numOffer < numOffers; numOffer++) {
		Offer offer = offers[numOffer];
		if (offer != null) {
		    html = html + "<TR ID=\"offer_row_" + offer.getOID() + "\">";
		    if (myOffers)
			html = html + "<TD rowspan=2>";
		    else
			html = html + "<TD>";
		    html = html + "<INPUT TYPE=\"checkbox\" WIDTH=\"12\" ID=\"offer_";
		    html = html + offer.getOID() + "\" NAME=\"oids\" VALUE=\"";
		    html = html + offer.getOID() + "\"></TD>";
		    if (myOffers)
			html = html + "<TD rowspan=2>";
		    else
			html = html + "<TD>";
		    html = html + offer.getKID() + "</TD>\n";
		    html = html + "<TD ID=\"descr_" + offer.getOID() + "\">" + offer.getDescription() + "</TD>";
		    html = html	+ "<TD>" + offer.getAskDescription() + "</TD>\n";
		    if (myOffers) {
			html = html + "<TR><TD><INPUT TYPE=\"text\" SIZE=32 NAME=\"item_descr_";
			html = html + offer.getOID() + "\"></TD>";
			html = html + "<TD><INPUT TYPE=\"text\" SIZE=32 NAME=\"ask_descr_";
			html = html + offer.getOID() + "\"></TD></TR>\n";
		    }
		    else {
			html = html + "<TD><INPUT TYPE=\"text\" SIZE=32 NAME=\"bid_descr_";
			html = html + offer.getOID() + "\" ID=\"bid_descr_";
			html = html + offer.getOID() + "\"></TD>\n";
		    }
		    html = html + "</TR>";
		}
	    }
	}
	html = html + "</TABLE>";
	return html;
    }

    public String toJSON() {
	int numOffer;
	String json = "[";
	if (numOffers > 0) {
	    for (numOffer = 0; numOffer < numOffers; numOffer++) {
		Offer offer = offers[numOffer];
		if (offer != null) {
		    json = json + offer.toJSON();
		}
		if (numOffer < numOffers - 1)
		    json = json + ",";
	    }
	}
	json = json + "]";
	return json;
    }
    
}
