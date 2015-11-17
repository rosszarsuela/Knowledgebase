package com.cocolife.marketing.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
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

public class GenerateSamplePolicyContract extends BasePDFGenUtil {
	private static final String directory = "D:/EGG Projects/HMODemo/Source Code/PDF/samplePolicyContract.pdf";
	
	static Config config = new Config();
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws DocumentException, IOException {
		
		
		Properties props = new Properties();
		
		props.load(new FileInputStream("D:/Volumes/Data/Code/Eclipse workspace/HMODemo/src/messages.properties"));
		
		config.setProperties(props);
		
		
		String emptySpace = " ";
		
		Rectangle pageSize = new Rectangle(PageSize.A4); 

		BaseFont helvetica = BaseFont.createFont(BaseFont.HELVETICA,
				BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
		
		Font helveticaFontNormal = new Font(helvetica, 10, Font.NORMAL);
		Font helveticaFontBold = new Font(helvetica, 10, Font.BOLD);
		Font helveticaFontBold14 = new Font(helvetica, 14, Font.BOLD);
		
		
		Document doc = new Document(PageSize.LETTER, 1, 1, 1, 1);
		
		PdfWriter.getInstance(doc, new FileOutputStream(directory));
		
		PdfPTable coverTable = PDFUtil.createPdfTable(2, Element.ALIGN_CENTER);
		PdfPTable contractTable = PDFUtil.createPdfTable(2, Element.ALIGN_CENTER);
		
		 doc.open();
		 
		createCover(coverTable);	
		doc.add(coverTable);
		
		createContract(doc, contractTable);
		
		/*doc.newPage();
		doc.add(contractTable);*/
        doc.close();
	}
	
	@SuppressWarnings("static-access")
	private static void createCover(PdfPTable coverTable) throws DocumentException, IOException {
		int padding = 1;
		int colspan = 2;
		int rowspan = 2;
		
		String emptySpace = " ";
		
		BaseFont helvetica = BaseFont.createFont(BaseFont.HELVETICA,
				BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
		
		Font helveticaFontNormal = new Font(helvetica, 10, Font.NORMAL);
		Font helveticaFontUnderline = new Font(helvetica, 10, Font.UNDERLINE);
		Font helveticaFontBold14 = new Font(helvetica, 14, Font.BOLD);
		PdfPCell cell = null;
		//Title
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.cover.title"),  helveticaFontNormal, 
																Element.ALIGN_CENTER, padding, colspan, false, BLACK);
		coverTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
																Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		cell.setBorderColorTop(BLACK);
		coverTable.addCell(cell);
		
		//Account Information
		//Policy Number
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.cover.acctInfo.policyNo"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		coverTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(":\t\t\t\t123123",  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		coverTable.addCell(cell);
		//Account Name
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.cover.acctInfo.policHolder"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		coverTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(":\t\t\t\tEGG",  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		coverTable.addCell(cell);
		
		//Address
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.cover.acctInfo.address"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		coverTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(":\t\t\t\t3F Salcedo St., Legazpi Village, Makati City",  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		coverTable.addCell(cell);
		
		//Eff Date
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.cover.acctInfo.effDate"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		coverTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(":\t\t\t\tFeb 21, 2012",  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		coverTable.addCell(cell);
		
		//Premium Date
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.cover.acctInfo.policNo"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		coverTable.addCell(cell);
		
		final String PREMIUM_DATE = "PREMIUM_DATE";
		String premiumDate= config.getProperties("marketing.contract.cover.acctInfo.annivDate.value");
		premiumDate = StrUtil.replaceAll(premiumDate, PREMIUM_DATE, "Feb 21, 1987");
		cell = PDFUtil.createPdfPCell(premiumDate,  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, false, WHITE);
		coverTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
				Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		coverTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
				Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		coverTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
				Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		coverTable.addCell(cell);
		
		//Forms attached
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.cover.formsAttached"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, BLACK);
		coverTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
				Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		cell.setBorderColorTop(BLACK);
		coverTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
				Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		coverTable.addCell(cell);
		
		//Payment Agreement
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.cover.paymentAgreement"),  helveticaFontNormal, 
				Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		coverTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
				Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		coverTable.addCell(cell);
		
		//In Witness
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.cover.inWitness"),  helveticaFontNormal, 
				Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		coverTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
				Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		coverTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
				Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		coverTable.addCell(cell);
		
		//Authorized Signatory
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.cover.authorizedPerson"),  helveticaFontUnderline, 
				Element.ALIGN_RIGHT, padding, colspan, false, WHITE);
		coverTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.cover.authorizedSign"),  helveticaFontNormal, 
				Element.ALIGN_RIGHT, padding, colspan, false, WHITE);
		coverTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
				Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		coverTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
				Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		coverTable.addCell(cell);
		
		//Important Notice
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.cover.imptNotice"),  helveticaFontNormal, 
				Element.ALIGN_RIGHT, padding, colspan, false, WHITE);
		coverTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
				Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		coverTable.addCell(cell);
		
		//Review
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.cover.reviewNote"),  helveticaFontNormal, 
				Element.ALIGN_RIGHT, padding, colspan, false, WHITE);
		coverTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
				Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		coverTable.addCell(cell);
		
		//Document Stamp
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.cover.docStamp"),  helveticaFontNormal, 
				Element.ALIGN_RIGHT, padding, colspan, false, WHITE);
		coverTable.addCell(cell);
	}
	
	@SuppressWarnings("static-access")
	private static void createContract(Document doc, PdfPTable contractTable) throws DocumentException, IOException {
		int padding = 1;
		int colspan = 2;
		int rowspan = 2;
		
		String emptySpace = " ";
		
		BaseFont helvetica = BaseFont.createFont(BaseFont.HELVETICA,
				BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
		
		Font helveticaFontNormal = new Font(helvetica, 10, Font.NORMAL);
		Font helveticaFontUnderline = new Font(helvetica, 10, Font.UNDERLINE);
		Font helveticaFontBold = new Font(helvetica, 12, Font.BOLD);
		PdfPCell cell = null;
		
		//new page
		doc.newPage();
		doc.add(contractTable);
		contractTable = PDFUtil.createPdfTable(2, Element.ALIGN_CENTER);
		
		//***************************************Definitions
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def"),  helveticaFontBold, 
																Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
																Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Company
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.company"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Effectivity Date
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.effDate"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Individual
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.indiv"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Dependent
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.dep"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Insured
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.insured"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Hospital
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.hospital"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Clinic
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.clinic"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Physician
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.physician"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Sickness
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.sickness"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Injury
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.injury"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Disability
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.disability"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Emergency
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.emergency"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Hospital Confinement
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.hospConfinement"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//In Patient
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.inPatient"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Out Patient
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.outPatient"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Treatment
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.treatment"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Convalescent Care
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.convalescentCare"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Custodial
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.custodial"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Medical Necessary
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.medicalNecessary"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Waiver
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.waiver"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Pre Existing
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.preExisting"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Personal Lifetime Exclusion
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.def.personalLifetimeExclusion"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//new page
		doc.newPage();
		doc.add(contractTable);
		contractTable = PDFUtil.createPdfTable(2, Element.ALIGN_CENTER);
		
		//new page
		doc.newPage();
		doc.add(contractTable);
		contractTable = PDFUtil.createPdfTable(2, Element.ALIGN_CENTER);
		
		//**************************************General Policy Provisions
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv"),  helveticaFontBold, 
				Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Entire Contract
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv.entireContract"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Policy Inconstestability
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv.policyInconstestability"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Assignment
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv.assignment"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Additions
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv.additions"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Data Required
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv.dataRequired"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Individual Application Required
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv.indivAppRequired"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Certificates
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv.certificates"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Clerical Error
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv.clericalError"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Non Waiver
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv.nonWaiver"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Limitations
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv.limitations"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Subrogation
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv.subrogation"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Indemnity
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv.indemnity"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Contract Termination
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv.contractTermination"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Effectivity of Termination
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv.effTermination"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Reinstatement
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv.reinstatement"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Participation Requirement
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv.participationRequirement"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Article 1250 Waiver
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv.article1250Waiver"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Policy Availability
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genPolicyProv.policyAvailability"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//new page
		doc.newPage();
		doc.add(contractTable);
		contractTable = PDFUtil.createPdfTable(2, Element.ALIGN_CENTER);
		
		//new page
		doc.newPage();
		doc.add(contractTable);
		contractTable = PDFUtil.createPdfTable(2, Element.ALIGN_CENTER);
		
		//****************************************Premium Provisions
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.premiumProv"),  helveticaFontBold, 
				Element.ALIGN_CENTER, padding, colspan, false, BLACK);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_CENTER, padding, colspan, false, BLACK);
		contractTable.addCell(cell);
		
		//Premium Payment
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.premiumProv.premiumPayment"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Other Charges
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.premiumProv.otherCharges"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Premium Adjustments
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.premiumProv.premiumAdjustments"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Renewal Clause
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.premiumProv.renewalClause"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Grace Period
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.premiumProv.gracePeriod"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Cancellation
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.premiumProv.cancellation"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//new page
		doc.newPage();
		doc.add(contractTable);
		contractTable = PDFUtil.createPdfTable(2, Element.ALIGN_CENTER);
		
		//new page
		doc.newPage();
		doc.add(contractTable);
		contractTable = PDFUtil.createPdfTable(2, Element.ALIGN_CENTER);
		
		//************************************Claims Provision
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.claimsProv"),  helveticaFontBold, 
				Element.ALIGN_CENTER, padding, colspan, false, BLACK);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Claim Notice
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.claimsProv.claimNotice"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Claim Forms
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.claimsProv.claimForms"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Proof of Loss
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.claimsProv.lossProof"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Examination
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.claimsProv.examination"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Suit against Company clause
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.claimsProv.suitAgainstCompanyClause"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//new page
		doc.newPage();
		doc.add(contractTable);
		contractTable = PDFUtil.createPdfTable(2, Element.ALIGN_CENTER);
		
		//****************************************General Exclusions
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genExclusion"),  helveticaFontBold, 
				Element.ALIGN_CENTER, padding, colspan, false, BLACK);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Content
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.genExclusion.content"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//new page
		doc.newPage();
		doc.add(contractTable);
		contractTable = PDFUtil.createPdfTable(2, Element.ALIGN_CENTER);
		
		//*************************************Life and Accident Insurance Benefits Provisions
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv"),  helveticaFontBold, 
				Element.ALIGN_CENTER, padding, colspan, false, BLACK);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Basic Medication Benefits
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.basicMedicalBen"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Accredited Hospital's Room and Boarding
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.accreditedHospRoomAndBoard"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Physician Fee
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.accreditedPhysicianFee"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Specialist Fee
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.accreditedSpecialistFee"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Surgeon Fee
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.accreditedSurgeonFee"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Multiple Surgeries
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.multipleSurgeries"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Surgical Operation not contained
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.surgicalOperationNotContained"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Accredited Anesthesiologist Fee
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.accreditedAnesthesiologistFee"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Operating Room Fee
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.operatngRoomFee"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Hospital Intensive Care
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.hospIntensiveCare"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Miscellaneous Fee
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.miscFee"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Major Medical Benefits
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.majorMedBen"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Emergency Benefits
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.emergencyBen"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Out Patient Benefits
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.outPatientBen"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//APE Benefits
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.apeBen"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Dental Benefits
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.dentalBen"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Maternity Benefits
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.maternityBen"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Latest Medical Modalities
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.latestMedModalities"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Dread disease limit
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.dreadDiseaseLim"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Identification Card
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.identificationCard"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//In Hospital Confinement
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.inHospConfinement"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Limitations
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.limitations"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Philhealth
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.philhealth"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Definitions
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.definitions"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Privilaged Communication Waiver
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.privilagedCommWaiver"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Claim Payable
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.lifeAndAccidentProv.claimPayable"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//new page
		doc.newPage();
		doc.add(contractTable);
		contractTable = PDFUtil.createPdfTable(2, Element.ALIGN_CENTER);
		
		//*******************************Insuring Provisions applicable to Individuals
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.insuringProv"),  helveticaFontBold, 
				Element.ALIGN_CENTER, padding, colspan, false, BLACK);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Eligiblity
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.insuringProv.eligibility"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Coverage Effectivity Date
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.insuringProv.coverageEffDate"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Actively at work
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.insuringProv.activelyAtWork"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Individual Incontestability
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.insuringProv.indivIncontestability"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Changes in insurance amount
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.insuringProv.insuranceAmountChange"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Enrollment
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.insuringProv.enrollment"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Occupation Change
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.insuringProv.occupationChange"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Individual Insurance Termination
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.insuringProv.indivInsuranceTermination"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//new page
		doc.newPage();
		doc.add(contractTable);
		contractTable = PDFUtil.createPdfTable(2, Element.ALIGN_CENTER);
		
		//******************************Insuring Provisions Applicable to Dependents
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.depInsuringProv"),  helveticaFontBold, 
				Element.ALIGN_CENTER, padding, colspan, false, BLACK);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Dependent Declaration
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.depInsuringProv.depDeclaration"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Eligibility
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.depInsuringProv.eligibility"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Coverage Effectivity Date
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.depInsuringProv.coverageEffDate"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Changes in insurance amount
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.depInsuringProv.insuranceAmountChange"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		//Dependent Insurance Termination
		cell = PDFUtil.createPdfPCell(config.getProperties("marketing.contract.depInsuringProv.depInsuranceTermination"),  helveticaFontNormal, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace,  helveticaFontNormal, 
						Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		contractTable.addCell(cell);
	}
}