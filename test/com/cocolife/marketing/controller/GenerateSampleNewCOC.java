package com.cocolife.marketing.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.oris.base.BasePDFGenUtil;
import com.oris.util.Config;
import com.oris.util.PDFUtil;
import com.oris.util.StrUtil;

/**
 * Class to test the Generation of Proposal
 * @author Ross Zarsuela
 *
 */

public class GenerateSampleNewCOC extends BasePDFGenUtil {
	private static final String directory = "D:/EGG Projects/HMODemo/Source Code/PDF/sampleCOC.pdf";
	
	static Config config = new Config();
	private static final String ACCOUNT_NAME = "ACCOUNT_NAME";
	private static final String POLICY_NUMBER = "POLICY_NUMBER";
	private static final String COVERAGE_START = "COVERAGE_START";
	private static final String COVERAGE_END = "COVERAGE_END";
	
	private static int padding = 2;
	private int colspan = 2;
	private String emptyString = " ";
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws DocumentException, IOException {
		courier =  BaseFont.createFont(BaseFont.COURIER, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
		
		Properties props = new Properties();
		
		props.load(new FileInputStream("D:/Volumes/Data/Code/Eclipse workspace/HMODemo/src/messages.properties"));
		
		config.setProperties(props);
						
		Document doc = new Document();
		
		PdfWriter.getInstance(doc, new FileOutputStream(directory));
		
		PdfPTable cocTable = new PdfPTable(2);
		
		createCOC(cocTable);
		 doc.open();
		doc.add(cocTable);
		doc.close();
	}
	
	@SuppressWarnings("static-access")
	private static void createCOC(PdfPTable cocTable) throws DocumentException, IOException {
		int colspan = 2;
		SimpleDateFormat format = new SimpleDateFormat("MMMM dd, yyyy");
		
		String emptySpace = " ";
		
		BaseFont helvetica = BaseFont.createFont(BaseFont.HELVETICA,
				BaseFont.CP1252, BaseFont.NOT_EMBEDDED);		
		
		PdfPCell cell = null;
		//Current Date
		cell = PDFUtil.createPdfPCell(format.format(new Date()),  courierFontNormal, 
																Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		cocTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  courierFontNormal, 
																Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		cocTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  courierFontNormal, 
																Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		cocTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  courierFontNormal, 
																Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		cocTable.addCell(cell);
		
		//Address Information
		//TO
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.coc.to"),  courierFontNormal, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		cocTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.coc.to.value"),  courierFontBold, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		cocTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  courierFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		cocTable.addCell(cell);
		
		//FROM
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.coc.from"),  courierFontNormal, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		cocTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.coc.from.value"),  courierFontBold, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		cocTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  courierFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		cocTable.addCell(cell);
		
		//SUBJECT
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.coc.subject"),  courierFontNormal, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		cocTable.addCell(cell);
		
		String subject = config.getProperties("marketing.coc.new.subject.value");
		subject = StrUtil.replaceAll(subject, ACCOUNT_NAME, "EGG");
		cell = PDFUtil.createPdfPCell(subject,  courierFontBold, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		cocTable.addCell(cell);	
		
		cell = PDFUtil.createPdfPCell(emptySpace,  courierFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		cell.setBorderColorBottom(BLACK);
		cocTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  courierFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		cell.setBorderColorTop(BLACK);
		cocTable.addCell(cell);
		
		//Content
		String content = config.getProperties("marketing.coc.new.content");
		content = StrUtil.replaceAll(content, ACCOUNT_NAME, "EGG");
		content = StrUtil.replaceAll(content, POLICY_NUMBER, "HCB11-0345");
		content = StrUtil.replaceAll(content, COVERAGE_START, format.format(new Date()));
		content = StrUtil.replaceAll(content, COVERAGE_END, format.format(new Date()));
		
		cell = PDFUtil.createPdfPCell(content,  courierFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		cocTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  courierFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		cocTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  courierFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		cocTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  courierFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		cocTable.addCell(cell);
		
		//Signatories
		cell = PDFUtil.createPdfPCell("Ruby Anne C. Calantog",  courierFontBold, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		cocTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.coc.ae"),  courierFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		cocTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.coc.title"),  courierFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		cocTable.addCell(cell);
	}
	
}