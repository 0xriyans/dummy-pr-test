package com.example.dummy;

import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

@RestController
@RequestMapping("/api/reports")
public class ReportParserController {

    @PostMapping("/process")
    public String processReport(@RequestBody String xmlData) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            
            DocumentBuilder builder = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xmlData));
            Document doc = builder.parse(is);
            
            return "Report processed. Root element: " + doc.getDocumentElement().getNodeName();
        } catch (Exception e) {
            return "Failed to process report";
        }
    }
}
