package org.jboss.examples.earproblem.transformer;

import org.switchyard.annotations.Transformer;
import org.w3c.dom.Element;

public final class Service2Transformers {

	@Transformer(to = "{org.jboss.examples.earproblem}logMesssageResponse")
	public Element transformStringToLogMesssageResponse(String from) {
        StringBuffer resultXml = new StringBuffer()
        .append("<return>" + from + "</return>");

        return TransformUtils.toElement(resultXml.toString());
	}

	@Transformer(from = "{org.jboss.examples.earproblem}logMesssage")
	public String transformLogMesssageToString(Element from) {
        return TransformUtils.getStringValue(from);
	}

}
