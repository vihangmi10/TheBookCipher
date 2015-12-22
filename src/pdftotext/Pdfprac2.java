/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pdftotext;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.*;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author RASIKA
 */
public class Pdfprac2 {
public String pdftoText(String fileName) {
		PDFParser parser;
		String parsedText = null;;
                String location=fileName.replaceAll(".pdf", ".txt");
                //System.out.println(location);
		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		File file = new File(fileName);
		if (!file.isFile()) {
			System.err.println("File " + fileName + " does not exist.");
			return null;
		}
		try {
			parser = new PDFParser(new FileInputStream(file));
		} catch (IOException e) {
			System.err.println("Unable to open PDF Parser. " + e.getMessage());
			return null;
		}
		try {
			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdDoc = new PDDocument(cosDoc);
			//pdfStripper.setStartPage(1);
			//pdfStripper.setEndPage(5);
			parsedText = pdfStripper.getText(pdDoc);
                    try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(location, true)))) {
                        out.println(parsedText);
                    }
                } catch (IOException e) {
			System.err
					.println("An exception occured in parsing the PDF Document."
							+ e.getMessage());
		} finally {
			try {
				if (cosDoc != null)
					cosDoc.close();
				if (pdDoc != null)
					pdDoc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return location;
	}
public void pprint(){
   
    
}
    
    public static void main(String[] args) {
        
//String pr = "D:\\abc.pdf";

		//System.out.println(pdftoText(pr));
        
	
 
}
    
    }
    

