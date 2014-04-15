package org.jboss.examples.earproblem.transformer;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class TransformUtils {

	private TransformUtils() {}

	public static NodeList getNodeList(Element from, String elementName) {
		NodeList nodes = from.getElementsByTagName(elementName);
		return nodes;
	}

	public static String getStringValue(Element from) {
		String value = from.getFirstChild().getNodeValue();
		return value;
	}

	public static String getStringValue(Element from, String elementName) {
		String value = null;
		NodeList nodes = from.getElementsByTagName(elementName);
		if (nodes != null && nodes.getLength() > 0) {
			value = nodes.item(0).getChildNodes().item(0).getNodeValue();
		}
		return value;
	}

	public static Boolean getBooleanValue(Element from, String elementName) {
		String value = getStringValue(from, elementName);
		if (value != null) {
			return Boolean.valueOf(value).booleanValue();
		} else {
			return null;
		}
	}

	public static Integer getIntValue(Element from, String elementName) {
		String value = getStringValue(from, elementName);
		if (value != null) {
			return Integer.valueOf(value).intValue();
		} else {
			return null;
		}
	}

	public static List<String> getStringValues(Element from, String elementName) {
		List<String> values = new LinkedList<String>();
		NodeList nodes = from.getElementsByTagName(elementName);
		if (nodes != null) {
			for (int i = 0; i < nodes.getLength(); i ++) {
				values.add(nodes.item(i).getChildNodes().item(0).getNodeValue());
			}
		}
		return values;
	}

	public static Element toElement(String xml) {
		DOMResult dom = new DOMResult();
		try {
			TransformerFactory.newInstance().newTransformer().transform(
					new StreamSource(new StringReader(xml)), dom);
		} catch (Exception e) {
		}

		return ((Document)dom.getNode()).getDocumentElement();
	}

}
