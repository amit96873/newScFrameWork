package com.qa.utils;

import java.io.InputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestUtils {
	
	public static final long WAIT=10;

	
	public HashMap<String, String> paseStringXML(InputStream file) throws Exception{
		HashMap<String, String> stringmap= new HashMap<String, String>();
		
		//get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		//Build Document
		Document document = builder.parse(file);
		//Normalize the xml stracture; its just to important
		document.getDocumentElement().normalize();
		//here comes the root node
		Element root = document.getDocumentElement();
//		System.out.println(root.getNodeName());
		//get all elements
		NodeList nlist = document.getElementsByTagName("string");
//		System.out.println("====================================");
		for(int temp=0; temp<nlist.getLength(); temp++) {
			Node node = nlist.item(temp);
			System.out.println(""); //just a separator
			if(node.getNodeType()==Node.ELEMENT_NODE){
				Element eElement=(Element) node;
				//store each element key value in map
				stringmap.put(eElement.getAttribute("name"), eElement.getTextContent());
				
			}
		}
		return stringmap;
	}
}
