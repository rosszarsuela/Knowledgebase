package com.oris.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.oris.base.BasePDFGenUtil;


public class PDFUtil extends BasePDFGenUtil {
	
	PdfTemplate template;
	private String headerImageUrl;
	
	public PDFUtil() {
		initBaseFont();
	}

    public static PdfPTable createPdfTable(int column, int alignment) throws DocumentException {

        PdfPTable table = new PdfPTable(column);
        table.setHorizontalAlignment(alignment);

        return table;
    }
    
    public static PdfPCell createPdfTableCell(PdfPTable table, int colspan, BaseColor color, int alignment) throws DocumentException {

    	PdfPCell cell = new PdfPCell();
    	cell.addElement(table);
        cell.setColspan(colspan);
        cell.setBorderColor(color);
        cell.setHorizontalAlignment(alignment);

        return cell;
    }

    public static PdfPTable createPdfTable(int column, int[] columnWidths, int alignment) throws DocumentException {

        PdfPTable table = new PdfPTable(column);
        table.setHorizontalAlignment(alignment);
        table.setWidths(columnWidths);

        return table;
    }

    public static PdfPCell createPdfPCell(String s, Font f) {
        PdfPCell cell = new PdfPCell(new Phrase(s, f));

        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(5f);
        cell.setBorder(1);
        
        return cell;
    }

    public static PdfPCell createPdfPCell(String s, Font f, Integer border) {
        PdfPCell cell = new PdfPCell(new Phrase(s, f));

        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(border);

        return cell;
    }
    
    public static PdfPCell createPdfPCell(String s, Font f, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(s, f));
        
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);

        return cell;
    }

    public static PdfPCell createPdfPCellNoBorder(String s, Font f) {
        PdfPCell cell = new PdfPCell(new Phrase(s, f));

        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setNoWrap(false);
        cell.setBorder(0);

        return cell;
    }

    public static PdfPCell createPdfPCell(String s, Font f, int alignment, int padding, boolean wrap, BaseColor c) {

        PdfPCell cell = new PdfPCell(new Phrase(s, f));
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(padding);
        cell.setNoWrap(wrap);
        cell.setBorderColor(c);

        return cell;
    }
    
    public static PdfPCell createPdfPCell(String s, Font f, int alignment, int padding, boolean wrap, BaseColor c, BaseColor bg) {

        PdfPCell cell = new PdfPCell(new Phrase(s, f));
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(padding);
        cell.setNoWrap(wrap);
        cell.setBorderColor(c);
        cell.setBackgroundColor(bg);

        return cell;
    }

    public static PdfPCell createPdfPCell(String s, Font f, int alignment, int padding, int colspan, boolean wrap, BaseColor c) {

        PdfPCell cell = new PdfPCell(new Phrase(s, f));
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(padding);
        cell.setNoWrap(wrap);
        cell.setBorderColor(c);
        cell.setColspan(colspan);
        return cell;
    }
    
    public static PdfPCell createPdfPCellTopBottomBorder(String s, Font f, int alignment, int padding, int colspan, boolean wrap) {

        PdfPCell cell = new PdfPCell(new Phrase(s, f));
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(padding);
        cell.setNoWrap(wrap);
        cell.setColspan(colspan);
        cell.setBorder(Rectangle.BOTTOM | Rectangle.TOP);
        return cell;
    }
    
    public static PdfPCell createPdfPCellTopBorderColor(String s, Font f, int alignment, int padding, int colspan, boolean wrap, BaseColor c) {

        PdfPCell cell = new PdfPCell(new Phrase(s, f));
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(padding);
        cell.setNoWrap(wrap);
        cell.setBorderColorTop(c);
        cell.setBorderColorBottom(WHITE);
        cell.setBorderColorLeft(WHITE);
        cell.setBorderColorRight(WHITE);
        cell.setColspan(colspan);
        return cell;
    }
    
    public static PdfPCell createPdfPCell(Image image, int alignment, int colspan) {
        PdfPCell cell = new PdfPCell(image);
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(colspan);
        cell.setBorder(0);
        return cell;
    }
    
    public static PdfPCell createPdfPCell(Image image, int alignment, int colspan, BaseColor c) {
        PdfPCell cell = new PdfPCell(image);
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(colspan);
        cell.setBorderColor(c);
        cell.setBorder(0);
        return cell;
    }
    
    public static PdfPCell createPdfPCell(String s, Font f, int alignment, int padding, int colspan, boolean wrap, BaseColor c, BaseColor bg) {

        PdfPCell cell = new PdfPCell(new Phrase(s, f));
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(padding);
        cell.setNoWrap(wrap);
        cell.setBorderColor(c);
        cell.setColspan(colspan);
        cell.setBackgroundColor(bg);
        
        return cell;
    }
    
    public static PdfPCell createPdfPCell(String s, Font f, int alignment, int padding, int colspan, boolean wrap) {

        PdfPCell cell = new PdfPCell(new Phrase(s, f));
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(padding);
        cell.setNoWrap(wrap);
		cell.setUseBorderPadding(true);
        cell.setColspan(colspan);
        cell.setBorder(Rectangle.TOP);
		cell.setBorder(Rectangle.LEFT);
		cell.setBorder(Rectangle.RIGHT);
		cell.setBorder(Rectangle.BOTTOM);
		cell.setBorderWidthTop(0.25f);
		cell.setBorderWidthLeft(0.25f);
		cell.setBorderWidthRight(0.25f);
		cell.setBorderWidthBottom(0.25f);
        return cell;
    }
    
    public static PdfPCell createPdfPCell(Phrase p, int alignment, int padding, int colspan, boolean wrap, BaseColor c) {

        PdfPCell cell = new PdfPCell(p);
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(padding);
        cell.setNoWrap(wrap);
        cell.setBorderColor(c);
        cell.setColspan(colspan);
        return cell;
    }

    public static PdfPCell createPdfPCell(String s, Font f, int alignment, int padding, int colspan, int rowspan, boolean wrap, BaseColor c) {

        PdfPCell cell = new PdfPCell(new Phrase(s, f));
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(padding);
        cell.setNoWrap(wrap);
        cell.setBorderColor(c);
        cell.setColspan(colspan);
        cell.setRowspan(rowspan);
        return cell;
    }

    public static PdfPCell createPdfPCell(String s, String param, Font f, int alignment, int padding, boolean wrap, BaseColor c) {

        PdfPCell cell = new PdfPCell(new Phrase(s + " " + param, f));
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(padding);
        cell.setNoWrap(wrap);
        cell.setBorderColor(c);

        return cell;
    }

    public static PdfPCell createPdfPCell(String s, String param, Font f, int alignment, int padding, int colspan, boolean wrap, BaseColor c) {

        PdfPCell cell = new PdfPCell(new Phrase(s + " " + param, f));
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(padding);
        cell.setNoWrap(wrap);
        cell.setBorderColor(c);
        cell.setColspan(colspan);

        return cell;
    }
    
    public static PdfPCell createBlankPdfPCell(int padding, int colspan, BaseColor c) {

        PdfPCell cell = new PdfPCell();
        cell.setPadding(padding);
        cell.setBorderColor(c);
        cell.setColspan(colspan);

        return cell;
    }
    
    public static PdfPCell createBlankPdfPCellTopBorderColor(int padding, int colspan) {

        PdfPCell cell = new PdfPCell();
        cell.setPadding(padding);
        cell.setBorder(Rectangle.BOTTOM | Rectangle.TOP);
        cell.setColspan(colspan);

        return cell;
    }
    
    public static PdfPCell createBlankPdfPCell(int padding, int colspan, BaseColor c, BaseColor bg) {

        PdfPCell cell = new PdfPCell();
        cell.setPadding(padding);
        cell.setBorderColor(c);
        cell.setColspan(colspan);
        cell.setBackgroundColor(bg);

        return cell;
    }
    
    public static PdfPCell createBorderedBlankPdfPCell(int padding, int colspan, BaseColor top, BaseColor bottom, BaseColor left, BaseColor right) {

        PdfPCell cell = new PdfPCell();
        cell.setPadding(padding);
        cell.setBorderColorTop(top);
        cell.setBorderColorBottom(bottom);
        cell.setBorderColorLeft(left);
        cell.setBorderColorRight(right);
        cell.setColspan(colspan);

        return cell;
    }

    public static Font getFont(int fontSize, int fontWeight) throws Exception {
        BaseFont courier = BaseFont.createFont(BaseFont.COURIER, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        Font font = new Font(courier, fontSize, fontWeight);

        return font;
    }

    public static Font getFontBold(int fontSize) throws Exception {
        BaseFont courier = BaseFont.createFont(BaseFont.COURIER, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        Font font = new Font(courier, fontSize, Font.BOLD);

        return font;
    }

    public static Font getFontNormal(int fontSize) throws Exception {
        BaseFont courier = BaseFont.createFont(BaseFont.COURIER, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        Font font = new Font(courier, fontSize, Font.NORMAL);

        return font;
    }
    
    public static PdfContentByte setContent(PdfWriter writer, BaseFont font, float size, int x, int y, String text) {
    	PdfContentByte cb = writer.getDirectContent();
		cb.beginText();
        cb.setFontAndSize(font, size);
        cb.setTextMatrix(x, y);
        cb.showText(text);
        cb.endText();
        return cb;
    }
    
    public static PdfContentByte setContent(PdfWriter writer, int align, BaseFont font, float size, float x, float y, String text, float rotation) {
    	PdfContentByte cb = writer.getDirectContent();
		cb.beginText();
		cb.setFontAndSize(font, size);
        cb.showTextAligned(align, text, x, y, rotation);
        cb.endText();
        return cb;
    }
    
    public static PdfPCell createBorderedCell(String s, Font f, int alignment, int padding, boolean wrap, BaseColor c){

        PdfPCell cell = new PdfPCell(new Phrase(s, f));
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(padding);
        cell.setNoWrap(wrap);
        cell.setBorder(Rectangle.TOP);
        cell.setBorder(Rectangle.LEFT);
		cell.setBorder(Rectangle.RIGHT);
		cell.setBorder(Rectangle.BOTTOM);
		cell.setUseBorderPadding(true);
		cell.setBorderWidthTop(1f);
		cell.setBorderWidthLeft(1f);
		cell.setBorderWidthRight(1f);
		cell.setBorderWidthBottom(1f);
        cell.setBorderColor(c);

        return cell;
    }
    
    public static PdfPCell createPdfPCell(String s, Font f, int alignment, int padding, boolean wrap, BaseColor c, Float grayFill) {

        PdfPCell cell = new PdfPCell(new Phrase(s, f));
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(padding);
        cell.setNoWrap(wrap);
        cell.setBorderColor(c);
        cell.setGrayFill(grayFill);
        
        return cell;
    }
    
    public static PdfPCell createBorderedPdfPCell(PdfPTable table, BaseColor c) {

        PdfPCell cell = new PdfPCell();
        cell.addElement(table);
        cell.setBorderColorTop(c);
        cell.setBorderColorBottom(c);
        cell.setBorderColorLeft(c);
        cell.setBorderColorRight(c);

        return cell;
    }

    @Override
	public void onOpenDocument(PdfWriter writer, Document document) {
		template = writer.getDirectContent().createTemplate(30, 16);
	}
    
//    @Override
//    public void onStartPage(PdfWriter writer, Document document) {
//    	    	
//    	Rectangle rect = writer.getBoxSize("box");
//    	Chunk img = null;
//		try {
//			img = new Chunk(Image.getInstance(getImageHeadr()), 0, 0);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    	ColumnText.showTextAligned(writer.getDirectContent(), ALIGN_CENTER, new Phrase(img), rect.getTop(), rect.getTop(), 0);
//    	ColumnText.showTextAligned(writer.getDirectContent(), ALIGN_CENTER, new Phrase("80 Main Horseshoe Drive, Cor N. Domingo St."), rect.getTop()- 20, rect.getTop() - 20, 0);
//    	ColumnText.showTextAligned(writer.getDirectContent(), ALIGN_CENTER, new Phrase("New Manila, Quezon City"), rect.getTop() + 20, rect.getTop() + 20, 0);
//    	ColumnText.showTextAligned(writer.getDirectContent(), ALIGN_CENTER, new Phrase("Contact No.: 411-4373"), rect.getTop() - 50, rect.getTop() - 50, 0);
//    	ColumnText.showTextAligned(writer.getDirectContent(), ALIGN_CENTER, new Phrase("TIN: 000-365-234-000"), rect.getTop() + 50, rect.getTop() + 50, 0);
//    }
	
	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		PdfContentByte cb = writer.getDirectContent();

		int pageN = writer.getPageNumber();
		String text = "Page " + pageN + " of ";
		cb.beginText();
		cb.setFontAndSize(helveticaNormal, 8);
		int endPageCount = writer.getPageNumber();
		
		//for legal doc size
		double pWidth = 72 * 13.5;// 14.87 inches = 1008 / 72
		float pageWidth = new Float(pWidth).floatValue();
		
		if(document.getPageSize().getWidth() == PageSize.LETTER.getWidth()) {
			if(endPageCount > 9 && endPageCount < 100) {
				cb.setTextMatrix(document.right() - document.rightMargin() - 24, document.bottom() - 10);
			} else if(endPageCount > 99) {
				cb.setTextMatrix(document.right() - document.rightMargin() - 28, document.bottom() - 10);
			} else {
				cb.setTextMatrix(document.right() - document.rightMargin() - 20, document.bottom() - 10);
			}
		} else if(document.getPageSize().getWidth() == PageSize.LETTER.rotate().getWidth()) {
			if(endPageCount > 9 && endPageCount < 100) {
				cb.setTextMatrix(document.right() - document.rightMargin() - 24, document.bottom());
			} else if(endPageCount > 99) {
				cb.setTextMatrix(document.right() - document.rightMargin() - 26, document.bottom());
			} else {
				cb.setTextMatrix(document.right() - document.rightMargin() - 22, document.bottom());
			}
		} else if(document.getPageSize().getWidth() == pageWidth) {
			if(endPageCount > 9 && endPageCount < 100) {
				cb.setTextMatrix(document.right() - document.rightMargin() - 20, document.bottom() - 10);
			} else if(endPageCount > 99) {
				cb.setTextMatrix(document.right() - document.rightMargin() - 25, document.bottom() - 10);
			} else {
				cb.setTextMatrix(document.right() - document.rightMargin() - 15, document.bottom() - 10);
			}
		}
		
		cb.showText(text);
		cb.endText();
		if(document.getPageSize().getWidth() == PageSize.LETTER.getWidth()) {
			cb.addTemplate(template, document.right() - 15, document.bottom() - 15);
		} else if(document.getPageSize().getWidth() == PageSize.LETTER.rotate().getWidth()) {
			cb.addTemplate(template, document.right() - 15, document.bottom() - 5);
		} else if(document.getPageSize().getWidth() == pageWidth) {
			cb.addTemplate(template, document.right() - 15, document.bottom() - 15);
		}
	}

	@Override
	public void onCloseDocument(PdfWriter writer, Document document) {
		template.beginText();
		template.setFontAndSize(helveticaNormal, 8);
		template.setTextMatrix(0,5);
		template.showText("" + (writer.getPageNumber() - 1));
		template.endText();
	}
	
	public void setHeaderImageUrl(String headerImageUrl) {
		this.headerImageUrl = headerImageUrl;
	}

	public String getHeaderImageUrl() {
		return headerImageUrl;
	}
}
