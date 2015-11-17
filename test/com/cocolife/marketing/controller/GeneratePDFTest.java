package com.cocolife.marketing.controller;
import java.awt.CardLayout;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class GeneratePDFTest {
                
                private static List<String> headers;
                private static List<String> results;

                public static void main(String[] args) throws IOException, DocumentException {
                                
                                headers = new ArrayList<String>();
                                headers.add("Member");
                                /*headers.add("Contract No");
                                headers.add("Account Name");
                                headers.add("Account Type");
                                headers.add("Effectivity Date");
                                headers.add("Paid Until");
                                headers.add("Payment Mode");
                                headers.add("Hospital");
                                headers.add("Dentist");
                                headers.add("Birthdate");
                                headers.add("Gender");
                                headers.add("Philhealth");*/
                                
                                results = new ArrayList<String>();
                                results.add("Zarsuela, Roselito L.");
                                results.add("0001");
                                results.add("Entertainment Gateway Group");
                                results.add("Individual");
                                results.add("2011-12-12");
                                results.add("2011-12-13");
                                results.add("Monthly");
                                results.add("Asian General Hospital");
                                results.add("Anne Curtis Smith");
                                results.add("2012-12-13");
                                results.add("M");
                                results.add("1234567890");
                                
                                double pWidth = 72 * 8.5;// 14.87 inches = 1008 / 72
                                double pHeight = 72 * 5.5;// 11 inches = 792 / 72
                                float pageWidth = new Float(pWidth).floatValue();
                                float pageHeight = new Float(pHeight).floatValue();
                                Rectangle pageSize = new Rectangle(pageWidth, pageHeight); 

                                BaseFont courier = BaseFont.createFont(BaseFont.TIMES_ROMAN,
                                                                BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
                                
                                Font courierFontNormal = new Font(courier, 7, Font.NORMAL);
                                Font courierFontBold = new Font(courier, 10, Font.BOLD);
                                
//                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                
                                Document doc = new Document(pageSize,1,1,1,1);
                                doc.setMarginMirroring(true);
                                
                                PdfWriter.getInstance(doc, new FileOutputStream("C:/Documents and Settings/Jethro Estrada/My Documents/Billback SOA Format/samplePDFJet.pdf"));
                                
                                Phrase headerPhrase = new Phrase("\nHEALTH MAINTENANCE, INC." +
                                                                "\nEXPIRING MEMBERS ON-HOLD\n", courierFontBold);
                                
                                HeaderFooter headerFooter = new HeaderFooter(headerPhrase, false);
                                headerFooter.setAlignment(Element.ALIGN_CENTER);
                                headerFooter.setBorderColor(Color.WHITE);
                                headerFooter.setTop(5);                             
                                doc.setHeader(headerFooter);
                                
//                            PdfCopy writer = new PdfCopy(doc,new FileOutputStream("D://test.pdf"));
                                
                                
                                
//                            PdfReader reader = new PdfReader(baos.toByteArray());
//                            System.out.println("reader: " + reader.getNumberOfPages());
                                
                                PdfPTable table = new PdfPTable(12);
                                PdfPTable mainTable = new PdfPTable(2);
                                PdfPTable leftTable = new PdfPTable(1);
                                PdfPTable rightTable = new PdfPTable(1);
                                
                                table.setTotalWidth(200);
                                table.setWidths(new int[] {20,10,20,10,15,20,10,20,10,15,10,10});
        // the cell object
        PdfPCell cell;
        // we add a cell with colspan 3
        
        boolean upperL = true;
        boolean upperR = false;
        
        for(int i=1 ; i<=7 ; i++) {
            
            /*for(String s : results) {
                cell = new PdfPCell(new Phrase(s, courierFontNormal));
                cell.setBorderColor(Color.WHITE);
                table.addCell(cell);
            }*/
                /*if(upperL) {
                                
                                for(String s : headers) {
                                cell = new PdfPCell(new Phrase(s, courierFontNormal));
                                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                            cell.setBorderColor(Color.WHITE);
                                table.addCell(cell);
                }
                                
                }*/
                
                if(i > 2) {
                                rightTable.addCell(cardTable());
                } else {
                                leftTable.addCell(cardTable());                                  
                }
                
//            mainTable.addCell(cardTable());
        }
        
        doc.open();
        
        mainTable.addCell(leftTable);
        mainTable.addCell(rightTable);
        doc.add(mainTable);
        doc.close();
                                
                }
                
                public static PdfPTable cardTable() {
                                PdfPTable table = new PdfPTable(1);
                                PdfPCell cell = null;
                                for(String s : headers) {
                cell = new PdfPCell(new Phrase(s));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            cell.setBorderColor(Color.WHITE);
                table.addCell(cell);
        }
                                
                                return table;
                }
                
}
