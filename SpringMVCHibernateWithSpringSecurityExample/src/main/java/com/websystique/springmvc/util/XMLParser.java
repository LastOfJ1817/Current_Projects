package com.websystique.springmvc.util;

public class XMLParser {

    private static String CURRENCY_URL = "http://www.nbrb.by/Services/XmlExRates.aspx";

    private static org.w3c.dom.Document loadDocument(String url) throws Exception {
	javax.xml.parsers.DocumentBuilderFactory factory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
	factory.setNamespaceAware(true);
	return factory.newDocumentBuilder().parse(new java.net.URL(url).openStream());
    }

    public static String getCurrency(String currencyCode){
	boolean isCurrencyCodeNext = false;
	org.w3c.dom.Document doc = null;
	try {
	    doc = loadDocument(CURRENCY_URL);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	org.w3c.dom.Node n = doc.getFirstChild();

	org.w3c.dom.NodeList nl = n.getChildNodes();
	org.w3c.dom.Node an, an2;

	for (int i = 0; i < nl.getLength(); i++) {
	    an = nl.item(i);

	    if (an.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
		org.w3c.dom.NodeList nl2 = an.getChildNodes();

		for (int i2 = 0; i2 < nl2.getLength(); i2++) {
		    an2 = nl2.item(i2);
		    if (an2.hasChildNodes()) {
			if (an2.getNodeName().trim().equalsIgnoreCase("Rate") && isCurrencyCodeNext) {
			    isCurrencyCodeNext = false;
			    return an2.getFirstChild().getNodeValue();
			}

			if (an2.getFirstChild().getNodeValue().trim().equalsIgnoreCase(currencyCode)) {
			    isCurrencyCodeNext = true;
			}
		    }
		}
	    }
	}
	return null;
    }
    
    public static String getCurrency2(String currencyName){
    	switch (currencyName) {
		case "USD":
			return getCurrency("840");
		case "EUR":
			return getCurrency("978");

		default:
			break;
		}
		return currencyName;
        }
    
    public static String getAllCurrency(String currencyName){
    	switch (currencyName) {
		case "USD":
			return getCurrency("840");
		case "EUR":
			return getCurrency("978");

		default:
			break;
		}
		return currencyName;
        }
    

    public static void main(String[] args) throws Exception {
    	System.out.println(getCurrency("840"));
    	
    	System.out.println(getCurrency("USD"));
    }

}

