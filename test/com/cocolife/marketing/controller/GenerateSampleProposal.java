package com.cocolife.marketing.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.PageSize;
import com.oris.base.BasePDFGenUtil;
import com.oris.util.PDFUtil;

/**
 * Class to test the Generation of Proposal
 * @author Ross Zarsuela
 *
 */

public class GenerateSampleProposal extends BasePDFGenUtil {
	private static final String directory = "D:/EGG Projects/HMODemo/Source Code/PDF/sampleProposal.pdf";
	
	//Constants
	private static final String HEALTH_CARE = "Cocolife Healthcare Program";	
	private static final String MAX_BEN_LIM = "Maximum Benefit Limit";
	private static final String PER_DISABILITY_YEARLY = "Per Disablity per Year";
	private static final String RM_AND_BOARD = "ROOM & BOARD ACCOMODATION";
	private static final String ANNUAL_PREMIUM = "ANNUAL PREMIUM: Per Individual";
	private static final String BENEFITS = "BENEFITS";
	private static final String DETAILS = "DETAILS";
	private static final String OUT_PATIENT = "Out Patient Benefits";
	private static final String IN_PATIENT = "In Patient Benefits";
	private static final String APE = "Annual Physical Examination";
	private static final String DENTAL = "Dental Benefits";
	private static final String PREVENTIVE_CARE = "Preventice Care";
	private static final String FINANCIAL_ASST = "Financial Assistance";
	private static final String EMERGENCY_ACCRED = "EMERGENCY TREATMENT IN ACCREDITED HOSPITALS";
	private static final String EMERGENCY_NON_ACCRED = "EMERGENCY TREATMENT IN NON ACCREDITED HOSPITALS (including Outside the Philippines)";
	private static final String EMERGENCY_NON_ACCRED_RADIUS = "EMERGENCY TREATMENT IF THERE ARE NO ACCREDITED HOSPITALS WITHIN 50KM RADIUS";
	private static final String OTHER_BENEFITS = "Other Benefits";
	private static final String SPECIAL_PROV = "Special Provision";
	private static final String NOTES = "Notes:";
	private static final String REGULAR_EMP = "Regular Employee";
	private static final String SPOUSE = "Spouse of Married Employees";
	private static final String CHILDREN = "children";
	private static final String PARENTS = "Parents of single Employees";
	private static final String NETWORK = "Network Nationwide";
	private static final String HOSPITAL = "Hospital/s";
	private static final String CLINIC =  "Clinic/s";
	private static final String PLAN_COORD = "Plan Coordinator/s";
	private static final String SPECIALIST = "Specialist/s";
	private static final String OTHER_PRIV = "Other Privilage";
		
	public static void main(String[] args) throws DocumentException, IOException {
		
		int padding = 1;
		int colspan = 2;
		int rowspan = 2;
		
		String emptySpace = " ";
		
		
		BaseFont helvetica = BaseFont.createFont(BaseFont.HELVETICA,
				BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
		
		Font helveticaFontNormal = new Font(helvetica, 10, Font.NORMAL);
		Font helveticaFontBold = new Font(helvetica, 10, Font.BOLD);
		Font helveticaFontBold14 = new Font(helvetica, 14, Font.BOLD);
		
		
		Document doc = new Document();
		
		PdfWriter.getInstance(doc, new FileOutputStream(directory));
		
		PdfPTable mainTable = PDFUtil.createPdfTable(2, Element.ALIGN_CENTER);
		PdfPCell cell = null;
		
		//Header
		/*HeaderFooter headerFooter = PDFUtil.setHeader(new Phrase("XYZ Company\n"+HEALTH_CARE), 
																		Element.ALIGN_LEFT, BLACK, Element.HEADER)	;
		mainTable.addCell(headerFooter);*/
		
		//Title
		cell = PDFUtil.createPdfPCell("XYZ Company",  helveticaFontNormal, Element.ALIGN_CENTER, padding, colspan, false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(HEALTH_CARE, helveticaFontNormal, Element.ALIGN_CENTER, padding, colspan, false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding, colspan, false, BLACK);
		mainTable.addCell(cell);
				
		setPlans(mainTable, helveticaFontBold, helveticaFontNormal);
		
		cell = PDFUtil.createPdfPCell("Please note that as a Life Insurance Company, COCOLIFE is exempt from the Value Added Tax under the provisions of the National Internal Revenue Code. Therefore, ",
																		helveticaFontNormal, Element.ALIGN_CENTER, padding, colspan,  false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("Per Disability per year: shall mean a sickness or injury; all bodily injuries sustained in any one accident shall be considered as ", 
																		helveticaFontNormal, Element.ALIGN_LEFT, padding, colspan, false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("one disability and any sickness existing simultaneously with an injury or other sickness shall likewise be considered as one disability.", 
																	helveticaFontNormal, Element.ALIGN_LEFT, padding, colspan, false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding, colspan, false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("* Indicative rates subject to change upon submission of complete requirements", 
																	helveticaFontBold, Element.ALIGN_LEFT, padding, colspan, false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding, colspan, false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(BENEFITS, helveticaFontBold14, Element.ALIGN_CENTER, padding,false, BLACK);
		mainTable.addCell(cell); 
		
		cell = PDFUtil.createPdfPCell(DETAILS, helveticaFontBold14, Element.ALIGN_CENTER, padding,false, BLACK);
		mainTable.addCell(cell); 
		
		setOutPatientBenefits(mainTable, helveticaFontBold, helveticaFontNormal);
		setInPatientBenefits(mainTable, helveticaFontBold, helveticaFontNormal);
		setAPE(mainTable, helveticaFontBold, helveticaFontNormal);
		setDentalBenefits(mainTable, helveticaFontBold, helveticaFontNormal);
		setPreventiveCare(mainTable, helveticaFontBold, helveticaFontNormal);
		
		//NEXT PAGE		
		cell = PDFUtil.createPdfPCell(HEALTH_CARE, helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		mainTable.addCell(cell);
		
		setFinancialAssistance(mainTable, helveticaFontBold, helveticaFontNormal);
		
		cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		mainTable.addCell(cell);
		
		setEmergencyAccreditedHospital(mainTable, helveticaFontBold, helveticaFontNormal);
		
		cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		mainTable.addCell(cell);
		
		setEmergencyNonAccreditedHospital(mainTable, helveticaFontBold, helveticaFontNormal);
		
		cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		mainTable.addCell(cell);
		
		setEmergencyNonAccreditedHospitalRadius(mainTable, helveticaFontBold, helveticaFontNormal);
		
		cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		mainTable.addCell(cell);
		
		setOtherBenefits(mainTable, helveticaFontBold, helveticaFontNormal);
		
		cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		mainTable.addCell(cell);
		
		setSpecialProvisions(mainTable, helveticaFontBold, helveticaFontNormal);
		
		cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		mainTable.addCell(cell);
		
		setEligibleMembers(mainTable, helveticaFontBold, helveticaFontNormal);
		
		cell = PDFUtil.createPdfPCell("Over " + getPlanCoordinatorCount() + " Plan Coordinators and " + getSpecialistCount() + " Specialists", helveticaFontBold, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		mainTable.addCell(cell); 
		
		//Network Nationwide
		setNotes(mainTable, helveticaFontBold, helveticaFontNormal);
		
		cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(NETWORK, helveticaFontBold, Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		mainTable.addCell(cell); 
		
		cell = PDFUtil.createPdfPCell("Over " + getHospitalCount() + " Hospitals and " + getClinicCount() + " Clinics", helveticaFontBold, 
																		Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		mainTable.addCell(cell); 
		
		cell = PDFUtil.createPdfPCell("Over " + getPlanCoordinatorCount() + " Plan Coordinators and " + getSpecialistCount() + " Specialists", helveticaFontBold, 
				Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		mainTable.addCell(cell); 
		
		cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding, colspan, false, WHITE);
		mainTable.addCell(cell);
		
		setWellnessProgram(mainTable, helveticaFontBold, helveticaFontNormal);
		
		doc.open();
		doc.add(mainTable);
        doc.close();
	}
	
	private static Integer getHospitalCount() {
		return 413;
	}
	
	private static Integer getClinicCount() {
		return 361;
	}
	
	private static Integer getPlanCoordinatorCount() {
		return 578;
	}
	
	private static Integer getSpecialistCount() {
		return 9230;
	}
	
	private static Map<Integer, List<String>> getPlans() {
		Map<Integer, List<String>> recordList= new HashMap<Integer, List<String>>();
		
		List<String> record = new ArrayList<String>();
		
		record.add("100,000");
		record.add("Regular Private");
		record.add("Annual Premium");
		recordList.put(1, record);
		
		record.add("200,000");
		record.add("Regular Private");
		record.add("Annual Premium");
		recordList.put(2, record);
		
		record.add("300,000");
		record.add("Regular Private");
		record.add("Annual Premium");
		recordList.put(3, record);
		
		return recordList;
	}
	
	private static void setPlans(PdfPTable mainTable, Font helveticaFontBold, Font helveticaFontNormal)  {
		PdfPCell cell = null;
		int padding = 1;
		int colspan = 2;
		int rowspan = 2;
		String emptySpace = " ";
		
		Map<Integer, List<String>> recordList = getPlans();
		
		cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("I", helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(MAX_BEN_LIM, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
		mainTable.addCell(cell);
			
		//MBL AMOUNT
		cell = PDFUtil.createPdfPCell(recordList.get(1).get(0), helveticaFontNormal, Element.ALIGN_CENTER, padding, 1,rowspan,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(PER_DISABILITY_YEARLY, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(RM_AND_BOARD, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(recordList.get(1).get(1), helveticaFontNormal, Element.ALIGN_CENTER, padding, false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(ANNUAL_PREMIUM, helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(recordList.get(1).get(2), helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
		mainTable.addCell(cell);		
		
		//2nd plan
		cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("II", helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(MAX_BEN_LIM, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
		mainTable.addCell(cell);
		
		//MBL AMOUNT
		cell = PDFUtil.createPdfPCell(recordList.get(2).get(0), helveticaFontNormal, Element.ALIGN_CENTER, padding, 1,rowspan,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(PER_DISABILITY_YEARLY, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(RM_AND_BOARD, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(recordList.get(2).get(1), helveticaFontNormal, Element.ALIGN_CENTER, padding, false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(ANNUAL_PREMIUM, helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(recordList.get(2).get(2), helveticaFontNormal, Element.ALIGN_CENTER, padding, false, BLACK);
		mainTable.addCell(cell);
		
		//3rd
		cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("III", helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(MAX_BEN_LIM, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
		mainTable.addCell(cell);
		
		//MBL AMOUNT
		cell = PDFUtil.createPdfPCell(recordList.get(3).get(0), helveticaFontNormal, Element.ALIGN_CENTER, padding, 1,rowspan,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(PER_DISABILITY_YEARLY, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(RM_AND_BOARD, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(recordList.get(3).get(1), helveticaFontNormal, Element.ALIGN_CENTER, padding, false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(ANNUAL_PREMIUM, helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell(recordList.get(3).get(2), helveticaFontNormal, Element.ALIGN_CENTER, padding, false, BLACK);
		mainTable.addCell(cell);
	}
	
	private static List<String> getOutPatientBenefits() {
		List<String> recordList = new ArrayList<String>();
		
		recordList.add("* Unlimited consultations incld. specialists evaluation");
		recordList.add("* Necessary x-ray and laboratory examinations");
		recordList.add("* EENT consultations");
		recordList.add("* First aid treatment of accidental injuries");
		recordList.add("* Minor surgeries");
		
		return recordList;
	}
	
	private static void setOutPatientBenefits(PdfPTable mainTable, Font helveticaFontBold, Font helveticaFontNormal)  {
		PdfPCell cell = null;
		int padding = 1;
		int colspan = 2;
		String emptySpace = "";
		
		//Out Patient
		cell = PDFUtil.createPdfPCell("Out Patient Benefits", helveticaFontBold, Element.ALIGN_LEFT, padding, colspan, false, BLACK);
		mainTable.addCell(cell); 
		
		List<String> recordList = getOutPatientBenefits();
		
		for(String record :  recordList) {
			cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
			mainTable.addCell(cell);
			
			cell = PDFUtil.createPdfPCell(record, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
			mainTable.addCell(cell);
		}
	}
	
	private static List<String> getInPatientBenefits() {
		List<String> recordList = new ArrayList<String>();
		
		recordList.add("* Daily room and board");
		recordList.add("* Services of physicians, specialists and surgeons");
		recordList.add("* General nursing services");
		recordList.add("* Use of emergency, operating and recovery rooms");
		recordList.add("* Drugs, medicines, anethesia and oxygen");
		recordList.add("* Laboratory tests, x-ray and other diagnostic procedures");
		recordList.add("* Dressing,  casts & other necessary medical supplies");
		recordList.add("* Transfusion of blood and other blood elements");
		return recordList;
	}
	
	private static void setInPatientBenefits(PdfPTable mainTable, Font helveticaFontBold, Font helveticaFontNormal)  {
		PdfPCell cell = null;
		int padding = 1;
		int colspan = 2;
		String emptySpace = "";
		
		//In Patient Benefits
		cell = PDFUtil.createPdfPCell("In Patient Benefits", helveticaFontBold, Element.ALIGN_LEFT, padding, colspan, false, BLACK);
		mainTable.addCell(cell); 
		
		List<String> recordList = getInPatientBenefits();
		
		for(String record :  recordList) {
			cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
			mainTable.addCell(cell);
			
			cell = PDFUtil.createPdfPCell(record, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
			mainTable.addCell(cell);
		}
	}
	
	private static List<String> getAPE() {
		List<String> recordList = new ArrayList<String>();
		
		recordList.add("* General physical examination and medical history taking");
		recordList.add("* General consultation and counseling on health habits");
		recordList.add("* Chest x-ray examination");
		recordList.add("* Urinalysis examination");
		recordList.add("* Fecalysis examination");
		recordList.add("* Complete blood count");
		recordList.add("* Electrocardiogram (for over 35 or if indicated)");
		recordList.add("* Pap smear (for female over 35 or if indicated)");
		recordList.add("* Immunization (except cost of vaccine)");
		return recordList;
	}
	
	private static void setAPE(PdfPTable mainTable, Font helveticaFontBold, Font helveticaFontNormal) {
		PdfPCell cell = null;
		int padding = 1;
		int colspan = 2;
		String emptySpace = "";
		
		//APE
		cell = PDFUtil.createPdfPCell("ANNUAL PHYSICAL EXAMINATION", helveticaFontBold, Element.ALIGN_LEFT, padding, colspan, false, BLACK);
		mainTable.addCell(cell); 
		
		List<String> recordList = getAPE();
		
		for(String record :  recordList) {
			cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
			mainTable.addCell(cell);
			
			cell = PDFUtil.createPdfPCell(record, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
			mainTable.addCell(cell);
		}
	}
	
	private static List<String> getDentalBenefits() {
		List<String> recordList = new ArrayList<String>();
		
		recordList.add("* Dental consultation including orthodontic and anesthetic");
		recordList.add("* Annual oral propylaxis including polishing and cleaning");
		recordList.add("* Any number of temporary fillings");
		recordList.add("* Any number of non-surgical tooth extraction");
		recordList.add("* Recementation of jackets, crowns, inlays and onlays");
		recordList.add("* Minor adjustment of dentures");
		recordList.add("* Relief of acute dental pain");
		recordList.add("* Emergency desensitization of hypersensitive teeth");
		recordList.add("* Care for oral lesions, wounds and burns");
		return recordList;
	}
	
	private static void setDentalBenefits(PdfPTable mainTable, Font helveticaFontBold, Font helveticaFontNormal)  {
		PdfPCell cell = null;
		
		int padding = 1;
		int colspan = 2;
		String emptySpace = "";
		
		//Dental Benefits
		cell = PDFUtil.createPdfPCell("DENTAL BENEFITS", helveticaFontBold, Element.ALIGN_LEFT, padding, colspan, false, BLACK);
		mainTable.addCell(cell); 
		
		List<String> recordList = getDentalBenefits();
		
		for(String record :  recordList) {
			cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
			mainTable.addCell(cell);
			
			cell = PDFUtil.createPdfPCell(record, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
			mainTable.addCell(cell);
		}
	}
	
	private static List<String> getPreventiveCare() {
		List<String> recordList = new ArrayList<String>();
		
		recordList.add("* Immunization (except cost of vaccine)");
		recordList.add("* Medical Management of Health");
		recordList.add("* Healthcare Maintenance");
		recordList.add("* Family Planning");
		recordList.add("* Diet & Exercise");
		return recordList;
	}
	
	private static void setPreventiveCare(PdfPTable mainTable, Font helveticaFontBold, Font helveticaFontNormal)  {
		PdfPCell cell = null;
		int padding = 1;
		int colspan = 2;
		String emptySpace = "";
		
		//Preventive Care
		cell = PDFUtil.createPdfPCell("PREVENTIVE CARE", helveticaFontBold, Element.ALIGN_LEFT, padding, colspan, false, BLACK);
		mainTable.addCell(cell); 
		
		List<String> recordList = getPreventiveCare();
		
		for(String record :  recordList) {
			cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
			mainTable.addCell(cell);
			
			cell = PDFUtil.createPdfPCell(record, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
			mainTable.addCell(cell);
		}
	}
	
	private static List<String> getFinancialAssistance() {
		List<String> recordList = new ArrayList<String>();
		
		recordList.add("* Php 10,000 for death due to natural cause");
		recordList.add("* Php 20,000 for death due to accident cause");
		recordList.add("(incl. Unprovoked murder or assault)");
		return recordList;
	}
	
	private static void setFinancialAssistance(PdfPTable mainTable, Font helveticaFontBold, Font helveticaFontNormal)  {
		PdfPCell cell = null;
		int padding = 1;
		int colspan = 2;
		String emptySpace = "";
		
		//Financial Assistance
		cell = PDFUtil.createPdfPCell("PREVENTIVE CARE", helveticaFontBold, Element.ALIGN_LEFT, padding, colspan, false, BLACK);
		mainTable.addCell(cell); 
		
		List<String> recordList = getFinancialAssistance();
		
		for(String record :  recordList) {
			cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
			mainTable.addCell(cell);
			
			cell = PDFUtil.createPdfPCell(record, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
			mainTable.addCell(cell);
		}
	}
	
	private static List<String> getEmergencyAccreditedHospitals() {
		List<String> recordList = new ArrayList<String>();
		
		recordList.add("Cocolife will cover for the following: ");
		recordList.add("* Doctor's services ");
		recordList.add("* Emergency room fees ");
		recordList.add("* Medicines used for immediate relief and during treatment ");
		recordList.add("* Oxygen, IV fluids, whole blood and human blood products for transfusion");
		recordList.add("* X-ray, lab exams and other diagnostic procedures ");
		return recordList;
	}

	private static void setEmergencyAccreditedHospital(PdfPTable mainTable, Font helveticaFontBold, Font helveticaFontNormal)  {
		PdfPCell cell = null;
		int padding = 1;
		int colspan = 2;
		String emptySpace = "";
		
		//Emergency Treatment in Accredited Hospitals
		cell = PDFUtil.createPdfPCell("EMERGENCY TREATMENT IN ACCREDITED HOSPITALS", helveticaFontBold, 
																	Element.ALIGN_LEFT, padding, colspan, false, BLACK);
		mainTable.addCell(cell); 
		
		List<String> recordList = getEmergencyAccreditedHospitals();
		
		for(String record :  recordList) {
			cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
			mainTable.addCell(cell);
			
			cell = PDFUtil.createPdfPCell(record, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
			mainTable.addCell(cell);
		}
	}
	
	private static List<String> getEmergencyNonAccreditedHospitals() {
		List<String> recordList = new ArrayList<String>();
		
		recordList.add("Cocolife will reimburse 80% of  reasonable and customary charges ");
		recordList.add("but not to exceed the amount we should have paid our service ");
		recordList.add("provider maximum of Ps 20,000  per disability.");
		return recordList;
	}
	
	private static void setEmergencyNonAccreditedHospital(PdfPTable mainTable, Font helveticaFontBold, Font helveticaFontNormal)  {
		PdfPCell cell = null;
		int padding = 1;
		int colspan = 2;
		String emptySpace = "";
		
		//Emergency Treatment in Non Accredited Hospitals
		cell = PDFUtil.createPdfPCell("EMERGENCY TREATMENT IN NON ACCREDITED HOSPITALS (including Outside the Philippines)", helveticaFontBold, 
																	Element.ALIGN_LEFT, padding, colspan, false, BLACK);
		mainTable.addCell(cell); 
		
		List<String> recordList = getEmergencyNonAccreditedHospitals();
		
		for(String record :  recordList) {
			cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
			mainTable.addCell(cell);
			
			cell = PDFUtil.createPdfPCell(record, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
			mainTable.addCell(cell);
		}
	}
	
	private static List<String> getEmergencyNonAccreditedHospitalsRadius() {
		List<String> recordList = new ArrayList<String>();
		
		recordList.add("Cocolife will reimburse 100% of  reasonable and customary charges");
		recordList.add("based on cocolife relative value we should have paid to our service ");
		recordList.add("provider");
		return recordList;
	}
	
	private static void setEmergencyNonAccreditedHospitalRadius(PdfPTable mainTable, Font helveticaFontBold, Font helveticaFontNormal)  {
		PdfPCell cell = null;
		int padding = 1;
		int colspan = 2;
		String emptySpace = "";
		
		//Emergency Treatment in Non Accredited Hospitals within 50km Radius
		cell = PDFUtil.createPdfPCell("EMERGENCY TREATMENT IF THERE ARE NO ACCREDITED HOSPITALS WITHIN 50KM RADIUS", helveticaFontBold, 
																	Element.ALIGN_LEFT, padding, colspan, false, BLACK);
		mainTable.addCell(cell); 
		
		List<String> recordList = getEmergencyNonAccreditedHospitalsRadius();
		
		for(String record :  recordList) {
			cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
			mainTable.addCell(cell);
			
			cell = PDFUtil.createPdfPCell(record, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
			mainTable.addCell(cell);
		}
	}
	
	private static List<String> getOtherBenefits() {
		List<String> recordList = new ArrayList<String>();
		
		recordList.add("Anti Rabies:                 1st dose within 24 hours");
		recordList.add("Anti Tetanus:               1st dose within 24 hours");
		recordList.add("Anti Venom, snake bites:                 1st dose within 24 hours");
		recordList.add("Admission kit (excluding ice cap/weebag) covered");
		recordList.add("Ambulance (on reimbursement):  up to 2,500 on reimbursement");
		recordList.add("Pre and post natal consultations: up to 14 consultations");
		return recordList;
	}
	
	private static void setOtherBenefits(PdfPTable mainTable, Font helveticaFontBold, Font helveticaFontNormal)  {
		PdfPCell cell = null;
		int padding = 1;
		int colspan = 2;
		String emptySpace = "";
		
		//Other Benefits
		cell = PDFUtil.createPdfPCell("Other Benefits", helveticaFontBold, 
																	Element.ALIGN_LEFT, padding, colspan, false, BLACK);
		mainTable.addCell(cell); 
		
		List<String> recordList = getOtherBenefits();
		
		for(String record :  recordList) {
			cell = PDFUtil.createPdfPCell(emptySpace, helveticaFontNormal, Element.ALIGN_CENTER, padding,false, BLACK);
			mainTable.addCell(cell);
			
			cell = PDFUtil.createPdfPCell(record, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, BLACK);
			mainTable.addCell(cell);
		}
	}
	
	private static List<List<String>> getSpecialProvisions() {
		List<List<String>> recordList = new ArrayList<List<String>>();
		
		List<String> record = new ArrayList<String>();
		
		record.add("Lithotripsy");
		record.add("80% up to Php 40,000");
		recordList.add(record);
		
		record = new ArrayList<String>();
		record.add("Laparoscopy");
		record.add("80% up to Php 40,000");
		recordList.add(record);
		
		record = new ArrayList<String>();
		record.add("MRI/ Isotope Scan");
		record.add("covered");
		recordList.add(record);
		
		record = new ArrayList<String>();
		record.add("CT Scan");
		record.add("covered");
		recordList.add(record);
		
		record = new ArrayList<String>();
		record.add("Thallium Scintigraphy");
		record.add("covered");
		recordList.add(record);
		
		record = new ArrayList<String>();
		record.add("24 Hour Holter Monitoring");
		record.add("covered");
		recordList.add(record);
		
		return recordList;
	}
	
	private static void setSpecialProvisions(PdfPTable mainTable, Font helveticaFontBold, Font helveticaFontNormal)  {
		PdfPCell cell = null;
		int padding = 1;
		int colspan = 2;
		
		//Other Benefits
		cell = PDFUtil.createPdfPCell("Special Provisions", helveticaFontBold, 
																	Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		mainTable.addCell(cell); 
		
		List<List<String>> recordList = getSpecialProvisions();
		
		for(List<String> record :  recordList) {
			for(String rec :  record) {
				cell = PDFUtil.createPdfPCell(rec, helveticaFontNormal, Element.ALIGN_LEFT, padding,false, WHITE);
				mainTable.addCell(cell);
			}
		}
	}
	
	private static void setNotes(PdfPTable mainTable, Font helveticaFontBold, Font helveticaFontNormal)  {
		PdfPCell cell = null;
		int padding = 1;
		int colspan = 2;
		String emptySpace = "";
		
		//Other Benefits
		cell = PDFUtil.createPdfPCell("NOTES:", helveticaFontBold, 
																	Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		mainTable.addCell(cell); 
		
		cell = PDFUtil.createPdfPCell("* Covers only all regular and full time employees and eligible dependents if applicable", helveticaFontNormal,
																	Element.ALIGN_LEFT, padding,colspan,false, WHITE);
		mainTable.addCell(cell);
		
		cell = PDFUtil.createPdfPCell("* This proposal assumes enrollment of at least 1,600 employees.  10% reduction in the enrolee size may invalidate this proposal", helveticaFontNormal,
																	Element.ALIGN_LEFT, padding,colspan,false, WHITE);
		mainTable.addCell(cell);

		cell = PDFUtil.createPdfPCell("* Requires 75% participation of principal to cover PEC of Dependents", helveticaFontNormal,
																	Element.ALIGN_LEFT, padding,colspan,false, WHITE);
		mainTable.addCell(cell);

		cell = PDFUtil.createPdfPCell("* Pre-existing Medical Conditions are covered up to maximum limit", helveticaFontNormal,
																	Element.ALIGN_LEFT, padding,colspan,false, WHITE);
		mainTable.addCell(cell);

		cell = PDFUtil.createPdfPCell("* All plans have access to all Major Hospitals such as Cardinal Santos Medical Center", helveticaFontNormal,
																	Element.ALIGN_LEFT, padding,colspan,false, WHITE);
		mainTable.addCell(cell);

		cell = PDFUtil.createPdfPCell("Capitol Medical Center, Medical City    (please refer to provider directory for the complete list accredited network)", helveticaFontNormal,
																	Element.ALIGN_LEFT, padding,colspan,false, WHITE);
		mainTable.addCell(cell);

		cell = PDFUtil.createPdfPCell("* Cocolife Healthcare has a 24 by 7 Customer Service Hotline", helveticaFontNormal,
																	Element.ALIGN_LEFT, padding,colspan,false, WHITE);
		mainTable.addCell(cell);

		cell = PDFUtil.createPdfPCell("* With Liason Officers that can assist our members during confinement", helveticaFontNormal,
																	Element.ALIGN_LEFT, padding,colspan,false, WHITE);
		mainTable.addCell(cell);
	}
	
	private static List<String> getEligibleMembers() {
		List<String> recordList = new ArrayList<String>();
		
		Integer maxEmp = 65;
		Integer maxSpouse = 65;
		Integer minChildren = 9;
		Integer maxChildren = 21;
		Integer maxParents = 65;		
		
		recordList.add("Regular Employees up to " + maxEmp + " years old");
		recordList.add("Spouse of married employees up to " + maxSpouse + " years old and children " +
										minChildren + " months old up to " + maxChildren + " years old, single and unemployed");
		recordList.add("Parents of Single employees up to " + maxParents);
		return recordList;
	}
	
	private static void setEligibleMembers(PdfPTable mainTable, Font helveticaFontBold, Font helveticaFontNormal)  {
		PdfPCell cell = null;
		int padding = 1;
		int colspan = 2;
		
		//Other Benefits
		cell = PDFUtil.createPdfPCell("Eligible Individuals", helveticaFontBold, 
																	Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		mainTable.addCell(cell); 
		
		List<String> recordList = getEligibleMembers();
		
		for(String record :  recordList) {
			cell = PDFUtil.createPdfPCell(record, helveticaFontNormal, Element.ALIGN_LEFT, padding, colspan,false, WHITE);
			mainTable.addCell(cell);
		}
	}
	
	private static List<String> getWellnessProgram() {
		List<String> recordList = new ArrayList<String>();
		
		recordList.add("* Hypertension");
		recordList.add("* Stress Management ");
		recordList.add("* Diet and Nutritions");
		return recordList;
	}
	
	private static void setWellnessProgram(PdfPTable mainTable, Font helveticaFontBold, Font helveticaFontNormal)  {
		PdfPCell cell = null;
		int padding = 1;
		int colspan = 2;
		
		//Other Benefits
		cell = PDFUtil.createPdfPCell("Cocolife Healthcare may provide a once a year wellness program awareness.  Some interesting topics conducted are as follows:", helveticaFontBold, 
																	Element.ALIGN_LEFT, padding, colspan, false, WHITE);
		mainTable.addCell(cell); 
		
		List<String> recordList = getWellnessProgram();
		
		for(String record :  recordList) {
			cell = PDFUtil.createPdfPCell(record, helveticaFontNormal, Element.ALIGN_LEFT, padding, colspan,false, WHITE);
			mainTable.addCell(cell);
		}
	}
}
