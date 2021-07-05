package demo;

import java.io.File;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;

public class ConvertXML {

	public static void main(String[] args) {
		try {  
			
			//creating a constructor of file class and parsing an XML file  
			File file = new File("G:\\test.xml");  
			//an instance of factory that gives a document builder  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			//an instance of builder to parse the specified xml file  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document doc = db.parse(file);  

		       DOMSource domSource = new DOMSource(doc);
		       StringWriter writer = new StringWriter();
		       StreamResult result = new StreamResult(writer);
		       TransformerFactory tf = TransformerFactory.newInstance();
		       Transformer transformer = tf.newTransformer();
		       transformer.transform(domSource, result);
			
			JSONObject json = XML.toJSONObject(writer.toString());   
			        String jsonString = json.toString(4);  
			        System.out.println(jsonString);  
			  
			}catch (Exception e) {  
			// TODO: handle exception  
			System.out.println(e.toString());  
			}  
		
	}
}
