package com.cocolife.marketing.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.oris.base.BasePDFGenUtil;
import com.oris.util.Config;
import com.oris.util.PDFUtil;

/**
 * Class to test the Generation of Proposal
 * @author Ross Zarsuela
 *
 */

public class GenerateSampleID extends BasePDFGenUtil {
	private static final String directory = "D:/EGG Projects/HMODemo/Source Code/PDF/idPrinting.pdf";
	
	static Config config = new Config();
	private static final String ACCOUNT_NAME = "ACCOUNT_NAME";
	private static final String POLICY_NUMBER = "POLICY_NUMBER";
	private static final String COVERAGE_START = "COVERAGE_START";
	private static final String COVERAGE_END = "COVERAGE_END";
	
	private static int padding = 1;
	private static int colPadding = 1;
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws DocumentException, IOException {
		courier =  BaseFont.createFont(BaseFont.COURIER, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
		
		double pHeight = 72 * 8.5;// 14.87 inches = 1008 / 72
		double pWidth = 72 * 3;// 3 inches = 432 / 72
		float pageWidth = new Float(pWidth).floatValue();
		float pageHeight = new Float(pHeight).floatValue();
		Rectangle pageSize = new Rectangle(pageWidth, pageHeight); 
						
		Document doc = new Document(pageSize, 0.25F, 0.25F, 0.25F, 0.25F);
		
		PdfWriter.getInstance(doc, new FileOutputStream(directory));
		
		PdfPTable idTable = new PdfPTable(2);
		int[] widths = new int[2];
		widths[0] = 30;
		widths[1] = 70;
		
		idTable.setWidths(widths);
		
		createID(idTable);
		 doc.open();
		doc.add(idTable);
		doc.close();
	}
	
	private static void createID(PdfPTable idTable) throws DocumentException, IOException {
		int colspan = 2;
		SimpleDateFormat format = new SimpleDateFormat("MMMM dd, yyyy");
		
		String emptySpace = " ";
		
		PdfPCell cell = null;
		
		cell = PDFUtil.createPdfPCell(emptySpace,  
				courierFontNormal, Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  
				courierFontNormal, Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  
				courierFontNormal, Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  
				courierFontNormal, Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		idTable.addCell(cell);
		
		//First Page
		
		cell = PDFUtil.createPdfPCell("Member's Name",  courierFontNormal, 
				Element.ALIGN_LEFT, colPadding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("Calantog, Ruby Anne C.",  courierFontBold, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("Company",  courierFontNormal, 
				Element.ALIGN_LEFT, colPadding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("Entertainment Gateway Group",  courierFontBold, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("Policy Number",  courierFontNormal, 
				Element.ALIGN_LEFT, colPadding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("POL-123-456-789",  courierFontBold, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		idTable.addCell(cell);	
		
		cell = PDFUtil.createPdfPCell("ID Number",  courierFontNormal, 
				Element.ALIGN_LEFT, colPadding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("0013-00002421-00",  courierFontBold, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("Birthdate",  courierFontNormal, 
				Element.ALIGN_LEFT, colPadding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(format.format(new Date()),  courierFontBold, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("Period Covered ",  courierFontNormal, 
				Element.ALIGN_LEFT, colPadding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(format.format(new Date()) + " to " + format.format(new Date()),  
				courierFontBold, Element.ALIGN_LEFT, padding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("Inception Date ",  courierFontNormal, 
				Element.ALIGN_LEFT, colPadding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(format.format(new Date()),  
				courierFontBold, Element.ALIGN_LEFT, padding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("Room Limit ",  courierFontNormal, 
				Element.ALIGN_LEFT, colPadding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("PLAN UP TO PHP 1,400",  
				courierFontBold, Element.ALIGN_LEFT, padding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  
				courierFontNormal, Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		idTable.addCell(cell);
		cell = PDFUtil.createPdfPCell(emptySpace,  
				courierFontNormal, Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		idTable.addCell(cell);
		cell = PDFUtil.createPdfPCell(emptySpace,  
				courierFontNormal, Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		idTable.addCell(cell);
		
		//Second Page
		cell = PDFUtil.createPdfPCell("In-Patient ",  courierFontNormal, 
				Element.ALIGN_LEFT, colPadding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("Select Accredited Hospitals",  
				courierFontBold, Element.ALIGN_LEFT, padding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  
				courierFontNormal, Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("Out-Patient ",  courierFontNormal, 
				Element.ALIGN_LEFT, colPadding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("Reimbursement Only",  
				courierFontBold, Element.ALIGN_LEFT, padding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  
				courierFontNormal, Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("OP Medicines ",  courierFontNormal, 
				Element.ALIGN_LEFT, colPadding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("80% of Prescribed Medicines at Select Meercury Drugstores",  
				courierFontBold, Element.ALIGN_LEFT, padding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  
				courierFontNormal, Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("Pre-Existing ",  courierFontNormal, 
				Element.ALIGN_LEFT, colPadding, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("COVERED UP TO MBL",  
				courierFontBold, Element.ALIGN_LEFT, padding, false, WHITE);
		idTable.addCell(cell);
				
		cell = PDFUtil.createPdfPCell(emptySpace,  
				courierFontNormal, Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		idTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("COCOLIFE HEALTHCARE DIVISION\n" +
																	"8/F Feliza Bldg. 108 V.A. Rufino St.\n" +
																	"Legaspi Village, Makati\n" +
																	"Member Hotline: (02) 812-9090\n" +
																	"Cellphone No.: (0917) 886-799",  
				courierFontNormal, Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		idTable.addCell(cell);
	}
	
}