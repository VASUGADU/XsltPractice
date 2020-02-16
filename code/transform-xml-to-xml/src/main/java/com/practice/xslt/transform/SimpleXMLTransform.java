package com.practice.xslt.transform;

import java.io.File;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class SimpleXMLTransform {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String inXML = "D:\\MyPractice\\XsltPractice\\XsltPractice\\code\\transform-xml-to-xml\\src\\main\\resources\\catalog.xml";
        String inXSL = "D:\\MyPractice\\XsltPractice\\XsltPractice\\code\\transform-xml-to-xml\\src\\main\\resources\\transform-catalog.xsl";
        String outTXT = "code/transform-xml-to-xml/output.xml";
        SimpleXMLTransform st = new SimpleXMLTransform();
        try {
            st.transform(inXML,inXSL,outTXT);
        } catch(TransformerConfigurationException e) {
            System.err.println("Invalid factory configuration");
            System.err.println(e);
        } catch(TransformerException e) {
            System.err.println("Error during transformation");
            System.err.println(e);
        }
    }
    public void transform(String inXML,String inXSL,String outTXT)
            throws TransformerConfigurationException,
            TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslStream = new StreamSource(inXSL);
        Transformer transformer = factory.newTransformer(xslStream);
        transformer.setErrorListener(new MyErrorListener());
        StreamSource in = new StreamSource(inXML);
        StreamResult out = new StreamResult(outTXT);
        transformer.transform(in,out);
        System.out.println("The generated XML file is:" + outTXT);

    }
}
class MyErrorListener implements ErrorListener {
    public void warning(TransformerException e)
            throws TransformerException {
        show("Warning",e);
        throw(e);
    }
    public void error(TransformerException e)
            throws TransformerException {
        show("Error",e);
        throw(e);
    }
    public void fatalError(TransformerException e)
            throws TransformerException {
        show("Fatal Error",e);
        throw(e);
    }
    private void show(String type,TransformerException e) {
        System.out.println(type + ": " + e.getMessage());
        if(e.getLocationAsString() != null)
            System.out.println(e.getLocationAsString());

    }
}
