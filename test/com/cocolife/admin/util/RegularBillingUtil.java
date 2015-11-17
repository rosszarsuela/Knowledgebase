package com.cocolife.admin.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.oris.base.BasePDFGenUtil;
import com.oris.util.PDFUtil;

public class RegularBillingUtil extends BasePDFGenUtil{
	private static final String directory = "D:/EGG Projects/HMODemo/Per Module Docs/Admin/Billing/PDF/RegularBilling.pdf";
	
	private static Integer totalPlanCount = 0;
	private static Integer totalPrincipalCount = 0;
	private static Integer totalDepCount = 0;
	
	private static Double totalNAFAmount = new Double(0);
	private static Double totalDFAmount = new Double(0);
	private static Double totalAmount = new Double(0);
	
	private static final String BILLING_NOTICE = "BILLING NOTICE";
	private static final String TO = "To:";
	private static final String ICODE = "ICode: ";
	private static final String ADDRESS = "Address: ";
	private static final String DATE = "Date: ";
	private static final String CONTACT_PERSON = "Contact Person: ";
	private static final String BILLING_NO = "Billing No.: ";
	
	private static final String POLICY_NO = "Policy No.: ";
	private static final String MODE = "Mode: ";
	private static final String BILLING_PERIOD = "Billing Period: ";
	private static final String BILLING_DATE = "Billing Date: ";
	private static final String EFFECTIVITY_DATE = "Effectivity Date: ";
	private static final String DUE_DATE = "DUE DATE: ";
	private static final String EXPIRY_DATE = "Expiry Date: ";
	private static final String RENEWAL_DATE = "Renewal Date: ";
	private static final String BILLING_TYPE = "Billing Type: ";
	
	private static final String COMPUTATION_SUMMARY = "COMPUTATION SUMMARY";
	private static final String TOTAL_PREM_DUE = "Total Premium Due ";
	private static final String TOTAL_ENROLLMENT_FEE = "Total Enrollment Fee (if applicable) ";
	private static final String EARNED_AND_DENTAL = "\t\tEarned and Dental";
	private static final String PRORATA = "\t\tPro-rata (EF maybe included in premium computation) ";
	private static final String CANCELLED_BILLING = "Cancelled Billing (if any) :  ";
	private static final String AMOUNT = "\t\tAmount";
	private static final String PAYMENT_FOR_REPLACEMENT_ID = "Payment for replacement I.D. (if any) : ";
	private static final String LOST = "\t\tLost ";
	private static final String CHANGE_PC_BC = "\t\tChange in PC & BC";
	private static final String CHANGE_BC = "\t\tChange in BC only";
	private static final String TOTAL_REPLACEMENT_COST = "Total Replacement Cost";
	private static final String AMOUNT_DUE_US = "AMOUNT DUE US (YOU)";
	private static final String OUTSTANDING_BAL = "OUTSTANDING BALANCE";
	private static final String SEE_ATTACHED_GROUP_PREM = "(see attached Group Premium Statement for the details)";
	
	private static final String PREPARED_BY_CHECKED_BY = "Prepared By/Checked By:";
	private static final String APPROVED_BY = "Approved By: ";
	
	private static final String DISCLAIMER1 = "Please make al remittances payable to COCOLIFE. An official receipt will be sent to you to acknowledge payment.";
	private static final String DISCLAIMER2 = "For easier reconcillation, please remit exact amount as stated above, advise correctios if any and adjustments will be reflected on next premium statement.";
	
	private static final String GROUP_PREM_STATEMENT = "GROUP PREMIUM STATEMENT ";
	private static final String COMPUTATION_DETAILS = "COMPUTATION DETAILS";
	
	private static final String INSURED = "Insured";
	private static final String EE_NO = "EE. No.";
	private static final String BDATE = "BDATE\n(DD/MM/YY)";
	private static final String REL = "Rel";
	private static final String EFFECTIVE = "Effective\n(DD/MM/YY)";
	private static final String EXPIRY = "Effective\n(DD/MM/YY)";
	private static final String PLAN = "Plan";
	private static final String PREM_CLASS = "Prem Class";
	private static final String PREM_DUE = "Prem Due";
	
	private static String BILL_TYPE_DESC = "";
	private static final String COUNT = "COUNT:";
	
	private static final String TOTAL_PRINCIPALS = "Total	Principals: ";
	private static final String TOTAL_DEPS = "Total Dependents";
	
	private static final String SUMMARY_OF_TRANSACTIONS = "SUMMARY OF TRANSACTIONS";
	private static final String BILLING_CTRL_NO = "Billing Ctrl No.:";
	private static final String TRANSACTION_NAME = "TRANSACTION NAME";
	private static final String TRANSACTION_REGULAR = "REGULAR";
	private static final String MEMBER_COUNT = "MEMBER COUNT";
	private static final String EEF = "EEF";
	private static final String PEF = "PEF";
	private static final String CEF = "CEF";
	
	private static final String PLAN_SUMMARY = "PLAN SUMMARY";
	private static final String PLAN_CLASS = "PLAN CLASS";
	private static final String PREMIUM = "PREMIUM";
	private static final String CODE = "CODE";
	private static final String SHORT_NAME = "SHORT NAME";

	private static final String TOTAL = "TOTAL";
	
	public static void main(String[] args) throws DocumentException, IOException {
		Document doc = initialize(PageSize.A4);
		PdfWriter.getInstance(doc, new FileOutputStream(directory));
				
		doc.open();
		
		doc.add(createBillingNotice1Table());
		doc.add(createBillingNotice2Table());
		doc.add(createComputationSummaryTable());
		doc.add(createBillingNoticeFooterTable());
		
		doc.newPage();
		doc.add(createGroupPremiumTable());	
		
		BILL_TYPE_DESC = "*** REGULAR ***";
		
		doc.add(createComputationDetailsTable());
		doc.add(createAmountDueTable());
		doc.add(createSummaryOfTransactionsTable());
		doc.add(createPlanSummaryTable());
		
		doc.close();
	}
	
	private static PdfPTable createBillingNotice1Table() {
		PdfPTable billingNotice1Table = new PdfPTable(4);
		billingNotice1Table.setWidthPercentage(100);
		
		int colspan = billingNotice1Table.getNumberOfColumns();
				
		billingNotice1Table.addCell(PDFUtil.createPdfPCell(BILLING_NOTICE,  helvetica14Bold, ALIGN_CENTER, padding, colspan, true, WHITE));
		billingNotice1Table.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		billingNotice1Table.addCell(PDFUtil.createPdfPCell(TO,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		billingNotice1Table.addCell(PDFUtil.createPdfPCell("Entertainment Gateway Group",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		billingNotice1Table.addCell(PDFUtil.createPdfPCell(ICODE,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		billingNotice1Table.addCell(PDFUtil.createPdfPCell("36",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		
		billingNotice1Table.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		billingNotice1Table.addCell(PDFUtil.createPdfPCell(ADDRESS,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		billingNotice1Table.addCell(PDFUtil.createPdfPCell("3/F Bloomingdale",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		billingNotice1Table.addCell(PDFUtil.createPdfPCell(DATE,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		billingNotice1Table.addCell(PDFUtil.createPdfPCell(shortDateFormat.format(new Date()),  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		
		billingNotice1Table.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		billingNotice1Table.addCell(PDFUtil.createPdfPCell(CONTACT_PERSON,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		billingNotice1Table.addCell(PDFUtil.createPdfPCell("Ross Zarsuela",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		billingNotice1Table.addCell(PDFUtil.createPdfPCell(BILLING_NO,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		billingNotice1Table.addCell(PDFUtil.createPdfPCell("12-059015-0001",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		
		billingNotice1Table.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		billingNotice1Table.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		billingNotice1Table.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, BLACK, GRAY));
		billingNotice1Table.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		
		
		return billingNotice1Table;
	}
	
	private static PdfPTable createBillingNotice2Table() {
		PdfPTable billingNotice2Table = new PdfPTable(4);
		billingNotice2Table.setWidthPercentage(100);
		int colspan = billingNotice2Table.getNumberOfColumns();
		
		billingNotice2Table.addCell(PDFUtil.createPdfPCell(POLICY_NO,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		billingNotice2Table.addCell(PDFUtil.createPdfPCell("HCB12-0356",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		billingNotice2Table.addCell(PDFUtil.createBlankPdfPCell(padding, colspan-2, WHITE));
		
		billingNotice2Table.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		billingNotice2Table.addCell(PDFUtil.createPdfPCell(BILLING_PERIOD,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		billingNotice2Table.addCell(PDFUtil.createPdfPCell("16-Aug-2012 To 16-Aug 2013",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		billingNotice2Table.addCell(PDFUtil.createPdfPCell(MODE,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		billingNotice2Table.addCell(PDFUtil.createPdfPCell("ANNUAL",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		
		billingNotice2Table.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		billingNotice2Table.addCell(PDFUtil.createPdfPCell(EFFECTIVITY_DATE,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		billingNotice2Table.addCell(PDFUtil.createPdfPCell("16-Aug-2012",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		billingNotice2Table.addCell(PDFUtil.createPdfPCell(BILLING_DATE,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		billingNotice2Table.addCell(PDFUtil.createPdfPCell(shortDateFormat.format(new Date()),  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		
		billingNotice2Table.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		billingNotice2Table.addCell(PDFUtil.createPdfPCell(EXPIRY_DATE,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		billingNotice2Table.addCell(PDFUtil.createPdfPCell("16-Aug-2013",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		billingNotice2Table.addCell(PDFUtil.createPdfPCell(DUE_DATE,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		billingNotice2Table.addCell(PDFUtil.createPdfPCell("13-Oct-2012",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		
		billingNotice2Table.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		billingNotice2Table.addCell(PDFUtil.createPdfPCell(RENEWAL_DATE,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		billingNotice2Table.addCell(PDFUtil.createPdfPCell("16-Aug-2013",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		billingNotice2Table.addCell(PDFUtil.createPdfPCell(BILLING_TYPE,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		billingNotice2Table.addCell(PDFUtil.createPdfPCell("Initial Billing",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		
		billingNotice2Table.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		return billingNotice2Table;
	}
	
	private static PdfPTable createComputationSummaryTable() {
		PdfPTable mainTable = new PdfPTable(1);
		PdfPTable table = new PdfPTable(1);
		
		PdfPCell cell = new PdfPCell();
		cell.setBorderColor(BLACK);
		
		mainTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));		
		mainTable.addCell(PDFUtil.createPdfPCell(COMPUTATION_SUMMARY,  helvetica10Bold, ALIGN_CENTER, padding, true, WHITE, GRAY));
		mainTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		mainTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		PdfPTable computationSummaryTable = new PdfPTable(2);
		computationSummaryTable.setWidthPercentage(100);
		int colspan = computationSummaryTable.getNumberOfColumns();		
		
		computationSummaryTable.addCell(PDFUtil.createPdfPCell(TOTAL_PREM_DUE,  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		computationSummaryTable.addCell(PDFUtil.createPdfPCell("0.00",  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createPdfPCell(TOTAL_ENROLLMENT_FEE,  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createPdfPCell(EARNED_AND_DENTAL,  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		computationSummaryTable.addCell(PDFUtil.createPdfPCell("47, 840",  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createPdfPCell(PRORATA,  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		computationSummaryTable.addCell(PDFUtil.createPdfPCell("0.00",  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createPdfPCell(CANCELLED_BILLING,  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createPdfPCell(AMOUNT,  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		computationSummaryTable.addCell(PDFUtil.createPdfPCell("0.00",  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createPdfPCell(PAYMENT_FOR_REPLACEMENT_ID,  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createPdfPCell(LOST,  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		computationSummaryTable.addCell(PDFUtil.createPdfPCell("0.00",  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createPdfPCell(CHANGE_PC_BC,  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		computationSummaryTable.addCell(PDFUtil.createPdfPCell("0.00",  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createPdfPCell(CHANGE_BC,  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		computationSummaryTable.addCell(PDFUtil.createPdfPCell("0.00",  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createPdfPCell(TOTAL_REPLACEMENT_COST,  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		computationSummaryTable.addCell(PDFUtil.createPdfPCell("0.00",  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createPdfPCell(AMOUNT_DUE_US,  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		computationSummaryTable.addCell(PDFUtil.createPdfPCell("47,840.00",  helvetica10NormalUnderlined, ALIGN_RIGHT, padding,  true, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createPdfPCell(OUTSTANDING_BAL,  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createPdfPCell(SEE_ATTACHED_GROUP_PREM,  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		
		computationSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		cell.addElement(computationSummaryTable);
		
		table.addCell(cell);
		mainTable.getDefaultCell().setBorderColor(WHITE);
		
		mainTable.addCell(table);
		
		return mainTable;		
	}
	
	private static PdfPTable createBillingNoticeFooterTable() {
		PdfPTable mainTable = new PdfPTable(1);
		PdfPTable table = new PdfPTable(1);
		
		PdfPCell cell = new PdfPCell();
		cell.setBorderColor(BLACK);
		
		
		mainTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		mainTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		mainTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
				
		PdfPTable billingNoticeFooterTable = new PdfPTable(2);
		billingNoticeFooterTable.setWidthPercentage(100);
		
		int colspan = billingNoticeFooterTable.getNumberOfColumns();
		
		
		billingNoticeFooterTable.addCell(PDFUtil.createPdfPCell(PREPARED_BY_CHECKED_BY,  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		billingNoticeFooterTable.addCell(PDFUtil.createPdfPCell(APPROVED_BY,  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		
		billingNoticeFooterTable.addCell(PDFUtil.createPdfPCell("__________________________",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		billingNoticeFooterTable.addCell(PDFUtil.createPdfPCell("__________________________",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		
		billingNoticeFooterTable.addCell(PDFUtil.createPdfPCell("Jovy O. Sarip",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		billingNoticeFooterTable.addCell(PDFUtil.createPdfPCell("Maribel C. Biscochio",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		
		billingNoticeFooterTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		billingNoticeFooterTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		
		cell.addElement(billingNoticeFooterTable);
		table.addCell(cell);
		
		mainTable.getDefaultCell().setBorderColor(WHITE);
		mainTable.addCell(table);
		mainTable.addCell(PDFUtil.createPdfPCell(DISCLAIMER1,  helvetica6, ALIGN_LEFT, padding,  true, WHITE));
		mainTable.addCell(PDFUtil.createPdfPCell(DISCLAIMER2,  helvetica6, ALIGN_LEFT, padding,  true, WHITE));
		
		
		return mainTable;		
	}

	private static PdfPTable createGroupPremiumTable() {
		PdfPTable groupPremiumTable = new PdfPTable(4);
		groupPremiumTable.setWidthPercentage(100);
		
		int colspan = groupPremiumTable.getNumberOfColumns();
		
		groupPremiumTable.addCell(PDFUtil.createPdfPCell(GROUP_PREM_STATEMENT,  helvetica14Bold, ALIGN_CENTER, padding, colspan, true, WHITE));
		groupPremiumTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		groupPremiumTable.addCell(PDFUtil.createPdfPCell(POLICY_NO,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		groupPremiumTable.addCell(PDFUtil.createPdfPCell("HCB12-0356",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		groupPremiumTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan-2, WHITE));
		
		groupPremiumTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		groupPremiumTable.addCell(PDFUtil.createPdfPCell(BILLING_PERIOD,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		groupPremiumTable.addCell(PDFUtil.createPdfPCell("16-Aug-2012 To 16-Aug 2013",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		groupPremiumTable.addCell(PDFUtil.createPdfPCell(MODE,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		groupPremiumTable.addCell(PDFUtil.createPdfPCell("ANNUAL",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		
		groupPremiumTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		groupPremiumTable.addCell(PDFUtil.createPdfPCell(EFFECTIVITY_DATE,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		groupPremiumTable.addCell(PDFUtil.createPdfPCell("16-Aug-2012",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		groupPremiumTable.addCell(PDFUtil.createPdfPCell(BILLING_DATE,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		groupPremiumTable.addCell(PDFUtil.createPdfPCell(shortDateFormat.format(new Date()),  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		
		groupPremiumTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		groupPremiumTable.addCell(PDFUtil.createPdfPCell(EXPIRY_DATE,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		groupPremiumTable.addCell(PDFUtil.createPdfPCell("16-Aug-2013",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		groupPremiumTable.addCell(PDFUtil.createPdfPCell(DUE_DATE,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		groupPremiumTable.addCell(PDFUtil.createPdfPCell("13-Oct-2012",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		
		groupPremiumTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		groupPremiumTable.addCell(PDFUtil.createPdfPCell(RENEWAL_DATE,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		groupPremiumTable.addCell(PDFUtil.createPdfPCell("16-Aug-2013",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		groupPremiumTable.addCell(PDFUtil.createPdfPCell(BILLING_TYPE,  helvetica10, ALIGN_RIGHT, padding,  true, WHITE));
		groupPremiumTable.addCell(PDFUtil.createPdfPCell("Initial Billing",  helvetica10, ALIGN_LEFT, padding,  true, WHITE));
		
		groupPremiumTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		return groupPremiumTable;
	}

	private static PdfPTable createComputationDetailsTable() {
		PdfPTable mainTable = new PdfPTable(1);
		PdfPTable table = new PdfPTable(1);
		
		PdfPCell cell = new PdfPCell();
		cell.setBorderColor(BLACK);
		
		mainTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		mainTable.addCell(PDFUtil.createPdfPCell(COMPUTATION_DETAILS,  helvetica10Bold, ALIGN_CENTER, padding, true, WHITE, GRAY));
		mainTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		
		PdfPTable computationDetailsTable = new PdfPTable(19);
		computationDetailsTable.setWidthPercentage(100);
		
		table.setWidthPercentage(100);
		
		int colspan = computationDetailsTable.getNumberOfColumns();
		
		computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(INSURED,  helvetica6Bold, ALIGN_CENTER, padding,  true, WHITE));
		computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(EE_NO,  helvetica6Bold, ALIGN_CENTER, padding,  true, WHITE));
		computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(BDATE,  helvetica6Bold, ALIGN_CENTER, padding,  true, WHITE));
		computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(REL,  helvetica6Bold, ALIGN_CENTER, padding,  true, WHITE));
		computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(EFFECTIVE,  helvetica6Bold, ALIGN_CENTER, padding,  true, WHITE));
		computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(EXPIRY,  helvetica6Bold, ALIGN_CENTER, padding,  true, WHITE));
		computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(PLAN,  helvetica6Bold, ALIGN_CENTER, padding,  true, WHITE));
		computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(PREM_CLASS,  helvetica6Bold, ALIGN_CENTER, padding,  true, WHITE));
		computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(PREM_DUE,  helvetica6Bold, ALIGN_CENTER, padding,  true, WHITE));
		computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		
		cell.addElement(computationDetailsTable);
		table.addCell(cell);
		
		computationDetailsTable = new PdfPTable(colspan);
		computationDetailsTable.setWidthPercentage(100);
		
		cell = new PdfPCell();
		cell.setBorderColor(BLACK);
		
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(BILL_TYPE_DESC,  helvetica6Bold, ALIGN_LEFT, padding,  colspan-8, true, WHITE));
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(COUNT,  helvetica6Bold, ALIGN_LEFT, padding,  2, true, WHITE));
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(totalPlanCount+"",  helvetica6Bold, ALIGN_LEFT, padding,  2, true, WHITE));
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(amountFormat.format(totalNAFAmount),  helvetica6Bold, ALIGN_LEFT, padding,  2, true, WHITE));
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(amountFormat.format(totalDFAmount),  helvetica6Bold, ALIGN_LEFT, padding,  2, true, WHITE));
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(amountFormat.format(totalAmount),  helvetica6Bold, ALIGN_LEFT, padding,  2, true, WHITE));
		
		cell.addElement(computationDetailsTable);
		table.addCell(cell);
		
		computationDetailsTable = new PdfPTable(colspan);
		computationDetailsTable.setWidthPercentage(100);
		
		cell = new PdfPCell();
		cell.setBorderColor(BLACK);
		
		for(int i = 0; i< 10 ; i++) {
			computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
			computationDetailsTable.addCell(PDFUtil.createPdfPCell("Member, Member " + i,  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
			computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
			computationDetailsTable.addCell(PDFUtil.createPdfPCell(i+"",  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
			computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
			computationDetailsTable.addCell(PDFUtil.createPdfPCell(shortDateFormat.format(new Date()),  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
			computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
			computationDetailsTable.addCell(PDFUtil.createPdfPCell("PR",  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
			computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
			computationDetailsTable.addCell(PDFUtil.createPdfPCell(shortDateFormat.format(new Date()),  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
			computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
			computationDetailsTable.addCell(PDFUtil.createPdfPCell(shortDateFormat.format(new Date()),  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
			computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
			computationDetailsTable.addCell(PDFUtil.createPdfPCell("P UP T0 1,000",  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
			computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
			
			totalNAFAmount += i;
			computationDetailsTable.addCell(PDFUtil.createPdfPCell(amountFormat.format(i),  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
			computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
			
			totalDFAmount += i;
			computationDetailsTable.addCell(PDFUtil.createPdfPCell(amountFormat.format(i),  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
			computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		}
		
		cell.addElement(computationDetailsTable);
		table.addCell(cell);
		
		computationDetailsTable = new PdfPTable(colspan);
		computationDetailsTable.setWidthPercentage(100);
		
		cell = new PdfPCell();
		cell.setBorderColor(BLACK);
		
		
		computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(TOTAL,  helvetica6Bold, ALIGN_LEFT, padding,  colspan-6,true, WHITE));
		computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(amountFormat.format(totalNAFAmount),  helvetica6Bold, ALIGN_LEFT, padding,  true, WHITE));
		computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(amountFormat.format(totalDFAmount),  helvetica6Bold, ALIGN_LEFT, padding,  true, WHITE));
		computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		totalAmount = totalNAFAmount+totalDFAmount;
		computationDetailsTable.addCell(PDFUtil.createPdfPCell(amountFormat.format(totalAmount),  helvetica6Bold, ALIGN_LEFT, padding,  true, WHITE));
		computationDetailsTable.addCell(PDFUtil.createBlankPdfPCell(padding, 1, WHITE));
		
		cell.addElement(computationDetailsTable);
		table.addCell(cell);
		
		mainTable.getDefaultCell().setBorderColor(WHITE);
		mainTable.addCell(table);
		
		return mainTable;		
	}

	private static PdfPTable createAmountDueTable() {
		PdfPTable mainTable = new PdfPTable(1);
		PdfPTable table = new PdfPTable(1);
		
		PdfPCell cell = new PdfPCell();
		cell.setBorderColor(BLACK);
		
		
		PdfPTable amountDueTable = new PdfPTable(2);
		amountDueTable.setWidthPercentage(100);
		int colspan = amountDueTable.getNumberOfColumns();
		
		mainTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		mainTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		mainTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		amountDueTable.addCell(PDFUtil.createPdfPCell(TOTAL_PRINCIPALS,  helvetica6, ALIGN_LEFT, padding,  true, WHITE));
		amountDueTable.addCell(PDFUtil.createPdfPCell(totalPrincipalCount+"",  helvetica6, ALIGN_RIGHT, padding,  true, WHITE));
		
		amountDueTable.addCell(PDFUtil.createPdfPCell(TOTAL_DEPS,  helvetica6, ALIGN_LEFT, padding,  true, WHITE));
		amountDueTable.addCell(PDFUtil.createPdfPCell(totalDepCount+"",  helvetica6, ALIGN_RIGHT, padding,  true, WHITE));
		
		amountDueTable.addCell(PDFUtil.createPdfPCell(AMOUNT_DUE_US,  helvetica10, ALIGN_CENTER, padding, 1, 2,  true, WHITE));
		amountDueTable.addCell(PDFUtil.createPdfPCell(amountFormat.format(totalAmount),  helvetica10, ALIGN_CENTER, padding, 1, 2,  true, WHITE));
		
		cell.addElement(amountDueTable);
		table.addCell(cell);
		
		mainTable.getDefaultCell().setBorderColor(WHITE);
		mainTable.addCell(table);
		
		return mainTable;		
	}

	private static PdfPTable createSummaryOfTransactionsTable() {
		PdfPTable mainTable = new PdfPTable(1);
		PdfPTable table = new PdfPTable(1);
		
		PdfPCell cell = new PdfPCell();
		cell.setBorderColor(BLACK);
		
		mainTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		mainTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		mainTable.addCell(PDFUtil.createPdfPCell(SUMMARY_OF_TRANSACTIONS,  helvetica6Bold, ALIGN_CENTER, padding, colspan, true, WHITE, GRAY));
		
		PdfPTable summaryOfTransactionsTable = new PdfPTable(5);
		summaryOfTransactionsTable.setWidthPercentage(100);
		
		int colspan = summaryOfTransactionsTable.getNumberOfColumns();
		
		summaryOfTransactionsTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		summaryOfTransactionsTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		summaryOfTransactionsTable.addCell(PDFUtil.createPdfPCell(BILLING_CTRL_NO,  helvetica6, ALIGN_RIGHT, padding, colspan-1,  true, WHITE));
		summaryOfTransactionsTable.addCell(PDFUtil.createPdfPCell("12-059015-0001",  helvetica6, ALIGN_LEFT, padding,  true, WHITE));
		
		summaryOfTransactionsTable.addCell(PDFUtil.createPdfPCell(TRANSACTION_NAME,  helvetica6Bold, ALIGN_CENTER, padding,  true, WHITE));
		summaryOfTransactionsTable.addCell(PDFUtil.createPdfPCell(MEMBER_COUNT,  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		summaryOfTransactionsTable.addCell(PDFUtil.createPdfPCell(EEF,  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		summaryOfTransactionsTable.addCell(PDFUtil.createPdfPCell(PEF,  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		summaryOfTransactionsTable.addCell(PDFUtil.createPdfPCell(CEF,  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		
		summaryOfTransactionsTable.addCell(PDFUtil.createPdfPCell(TRANSACTION_REGULAR,  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		summaryOfTransactionsTable.addCell(PDFUtil.createPdfPCell(totalPrincipalCount + totalDepCount + "",  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		summaryOfTransactionsTable.addCell(PDFUtil.createPdfPCell(amountFormat.format(totalNAFAmount),  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		summaryOfTransactionsTable.addCell(PDFUtil.createPdfPCell(amountFormat.format(0),  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		summaryOfTransactionsTable.addCell(PDFUtil.createPdfPCell(amountFormat.format(0),  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		
		summaryOfTransactionsTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		summaryOfTransactionsTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		mainTable.getDefaultCell().setBorderColor(WHITE);
		summaryOfTransactionsTable.getDefaultCell().setBorderColor(WHITE);
		mainTable.addCell(summaryOfTransactionsTable);
		
		summaryOfTransactionsTable = new PdfPTable(5);
		summaryOfTransactionsTable.setWidthPercentage(100);
		
		cell = new PdfPCell();
		cell.setBorderColor(BLACK);
		
		summaryOfTransactionsTable.addCell(PDFUtil.createPdfPCell(TOTAL,  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		summaryOfTransactionsTable.addCell(PDFUtil.createPdfPCell(totalPrincipalCount + totalDepCount + "",  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		summaryOfTransactionsTable.addCell(PDFUtil.createPdfPCell(amountFormat.format(totalNAFAmount),  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		summaryOfTransactionsTable.addCell(PDFUtil.createPdfPCell(amountFormat.format(0),  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		summaryOfTransactionsTable.addCell(PDFUtil.createPdfPCell(amountFormat.format(0),  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		
		cell.addElement(summaryOfTransactionsTable);
		table.addCell(cell);
		
		
		mainTable.getDefaultCell().setBorderColor(WHITE);
		mainTable.addCell(table);
		
		return mainTable;		
	}
	
	private static PdfPTable createPlanSummaryTable() {
		PdfPTable planSummaryTable = new PdfPTable(4);
		int colspan = planSummaryTable.getNumberOfColumns();
		
		planSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		planSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		PdfPCell cell = PDFUtil.createPdfPCell(PLAN_SUMMARY,  helvetica6Bold, ALIGN_CENTER, padding, colspan, true, WHITE, GRAY);
		
		planSummaryTable.addCell(cell);
		planSummaryTable.addCell(PDFUtil.createBlankPdfPCell(padding, colspan, WHITE));
		
		planSummaryTable.addCell(PDFUtil.createPdfPCell(PLAN_CLASS,  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		planSummaryTable.addCell(PDFUtil.createPdfPCell(PREMIUM,  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		planSummaryTable.addCell(PDFUtil.createPdfPCell(CODE,  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		planSummaryTable.addCell(PDFUtil.createPdfPCell(SHORT_NAME,  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		
		for(int i= 0; i<3; i++) {
			planSummaryTable.addCell(PDFUtil.createPdfPCell("Plan " + i + " UP TO 1,000",  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
			planSummaryTable.addCell(PDFUtil.createPdfPCell(amountFormat.format(i),  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
			planSummaryTable.addCell(PDFUtil.createPdfPCell("HCB"+i,  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
			planSummaryTable.addCell(PDFUtil.createPdfPCell("P UP TP 1,000",  helvetica6, ALIGN_CENTER, padding,  true, WHITE));
		}
		
		return planSummaryTable;
	}
}