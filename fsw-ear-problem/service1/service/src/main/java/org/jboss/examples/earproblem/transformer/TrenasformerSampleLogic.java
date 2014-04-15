package org.jboss.examples.earproblem.transformer;

import org.switchyard.annotations.Transformer;
import org.w3c.dom.Element;

public final class TrenasformerSampleLogic {

	@Transformer(to = "{urn:org.jboss.examples.earproblem.services:1.0}doLogicResponse")
	public Element transformStringToDoLogicResponse(String from) {
		StringBuffer xml = new StringBuffer();
		xml.append("<return>" + from + "</return>");
		return TransformUtils.toElement(xml.toString());
	}

	@Transformer(from = "{urn:org.jboss.examples.earproblem.services:1.0}doLogic")
	public String transformDoLogicToString(Element from) {
		 return TransformUtils.getStringValue(from);
	}

}
