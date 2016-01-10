package services.xslt;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.URIResolver;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class XmlTransformer {

	/**
	 * Instantiates a new xml transformer.
	 */
	public XmlTransformer() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Transform XML.
	 * 
	 * @param pXml
	 *            the xml
	 * @param pXsltPath
	 *            the xslt path
	 * @return the string
	 */
	public static String transform(String pXml, String pXsltPath) {
		StringWriter writer = new StringWriter();

		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			// factory.setAttribute("indent-number", 2);
			factory.setURIResolver(new URIResolver() {
				@Override
				public Source resolve(String href, String base) throws TransformerException {
					return new StreamSource(this.getClass().getClassLoader().getResourceAsStream(href));
				}
			});

			Source xslt = new StreamSource(XmlTransformer.class.getClassLoader().getResourceAsStream(pXsltPath));
			Templates cachedXslt = factory.newTemplates(xslt);
			Transformer transformer = cachedXslt.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setEntityResolver(new EntityResolver() {
				@Override
				public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
					if (systemId.endsWith(".dtd")) {
						StringReader stringInput = new StringReader(" ");
						return new InputSource(stringInput);
					} else {
						// use default behavior
						return null;
					}
				}
			});
			SAXSource xmlSource = new SAXSource(reader, new InputSource(new StringReader(pXml)));
			transformer.transform(xmlSource, new StreamResult(writer));
		} catch (TransformerException e) {
			System.out.println("TransformerException thrown in SalesTransactionServiceTest.restoreNamespaces");
			e.printStackTrace();
		} catch (SAXException e) {
			System.out.println("SAXException thrown in SalesTransactionServiceTest.restoreNamespaces");
			e.printStackTrace();
		}

		return writer.toString();
	}
}
