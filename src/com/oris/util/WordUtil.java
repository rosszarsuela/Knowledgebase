package com.oris.util;

import java.awt.Color;
import java.io.IOException;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Chunk;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;

public class WordUtil {
	
	public BaseFont courier ;
	
	public static Table createWordTable(int column,int alignment) throws BadElementException {
		Table table = new Table(column);
		table.setAlignment(alignment);
		return table;
	}
	
	public static Table createWordTable(int column,int[] columnWidths,int alignment) throws DocumentException {
		Table table = new Table(column);
		table.setAlignment(alignment);
		table.setWidths(columnWidths);
		return table;
	}
	
	public static Cell createWordCellNoBorder(String s, Font f) throws BadElementException {
		Chunk chunk = new Chunk(s, f);
		Cell cell = new Cell(chunk);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(0);
		return cell;
	}
	
	public static Cell createWordCellWithBorder(String s, Font f) throws BadElementException {
		Chunk chunk = new Chunk(s, f);
		Cell cell = new Cell(chunk);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setBorder(Rectangle.BOX);
		cell.setBorderColor(Color.BLACK);
		return cell;
	}
	
	public void initBaseFonts() throws DocumentException, IOException {
		courier = BaseFont.createFont(BaseFont.COURIER,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
	}
}
