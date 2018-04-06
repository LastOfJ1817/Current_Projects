package com.websystique.springmvc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
 
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.websystique.springmvc.model.Act;
import com.websystique.springmvc.model.Contragent;
import com.websystique.springmvc.model.Debit;

public class CreateExcel {
	private Workbook workbook;

	public void writeExcel(List<Debit> listDebits, String excelFilePath) throws IOException {
		File file = new File("/Users/alis/Documents/Проект/SpringMVCHibernateWithSpringSecurityExample/src/main/webapp/static/userforms/Template1.xlsx");
		FileInputStream inputStream_ED = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputStream_ED);
	    Sheet sheet = workbook.getSheet("Раздел 1");
	    
	    sheet.setDefaultColumnWidth(30);
	    // create style for header cells
	    XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        font.setBold(true);
        style.setFont(font);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        
       
        
	   /** XSSFRow header = (XSSFRow) sheet.createRow(0);
	    header.createCell(0).setCellValue("Дата записи");
	    header.getCell(0).setCellStyle(style);
	    header.createCell(1).setCellValue("Наименование документа, его номер и дата");
	    header.getCell(1).setCellStyle(style);
	    header.createCell(2).setCellValue("Содержание операции");
	    header.getCell(2).setCellStyle(style);
	    header.createCell(3).setCellValue("Выручка от реализации товаров, работ, услуг. Всего:");
	    header.getCell(3).setCellStyle(style);
	    header.createCell(4).setCellValue("В том числе НДС:");
	    header.getCell(4).setCellStyle(style);
	    header.createCell(5).setCellValue("Внереализационные доходы:");
	    header.getCell(5).setCellStyle(style);
	    header.createCell(6).setCellValue("Валовая выручка\n" + 
	    		"(графа (далее - гр.) 4 - - гр. 5 + гр. 6)");
	    header.getCell(6).setCellStyle(style);*/
	    
	    //int rowCount = 0;
        double itog = 0;
        double nds = 0;
        double summ = 0;
        
	    for (Debit debits : listDebits) {
	    	Row row = workbook.getSheetAt(0).createRow(sheet.getLastRowNum()+1);    
	    		writeDebit(debits, row);
	    		summ+= debits.getTotalAmount();
	    		itog+=debits.getIncomeAmount();
	    		nds+=debits.getIncludingNDS();
	    }
	    
	    Row row1 = workbook.getSheetAt(0).createRow(sheet.getLastRowNum()+1); 
	    
	    
	    Cell cell = row1.createCell(0);
	    cell.setCellStyle(style);
	    cell.setCellValue("ИТОГО");
	    
	    cell = row1.createCell(1);
	    cell.setCellStyle(style);
	    
	    cell = row1.createCell(2);
	    cell.setCellStyle(style);
	    
	    cell = row1.createCell(3);
	    cell.setCellStyle(style);
	    cell.setCellValue(itog);
	    
	    cell = row1.createCell(4);
	    cell.setCellStyle(style);
	    cell.setCellValue(nds);
	    
	    cell = row1.createCell(5);
	    cell.setCellStyle(style);
	    
	    cell = row1.createCell(6);
	    cell.setCellStyle(style);
	    cell.setCellValue(summ);
	 
	    try (FileOutputStream outputStream = new FileOutputStream(new File(excelFilePath))) {
	        workbook.write(outputStream);
	    }
	}
	
	private void writeDebit(Debit debits, Row row) {
		Cell cell;
		XSSFCellStyle style1 = (XSSFCellStyle) workbook.createCellStyle();
		XSSFCellStyle style2 = (XSSFCellStyle) workbook.createCellStyle();
		style1.setBorderRight(BorderStyle.THIN);
        style1.setBorderLeft(BorderStyle.THIN);
        style1.setBorderTop(BorderStyle.THIN);
        style1.setBorderBottom(BorderStyle.THIN);
        style2.setShrinkToFit(true);
		
	    cell = row.createCell(0);
	    cell.setCellStyle(style1);
	  
	    cell.setCellValue(debits.getDate());
	 
	    cell = row.createCell(1, CellType.STRING);
	    cell.setCellStyle(style1);
	    
	    cell.setCellValue(debits.getDocument() + " от "+ debits.getDate());
	 
	    cell = row.createCell(2, CellType.STRING);
	    cell.setCellStyle(style1);
	    cell.setCellValue(debits.getDescription());
	    
	    cell = row.createCell(3);
	    cell.setCellStyle(style1);
	    cell.setCellValue(debits.getIncomeAmount());
	    
	    cell = row.createCell(4);
	    cell.setCellStyle(style1);
	    cell.setCellValue(debits.getIncludingNDS());
	    
	    cell = row.createCell(5);
	    cell.setCellStyle(style1);
	    cell.setCellValue(debits.getOtherAmount());
	    
	    cell = row.createCell(6);
	    cell.setCellStyle(style1);
	    cell.setCellValue(debits.getTotalAmount());
	}
	
	public void createTemplate (String userPath) throws FileNotFoundException {
	
		File file = new File("/Users/alis/Documents/Проект/SpringMVCHibernateWithSpringSecurityExample/src/main/webapp/static/userforms/Template1.xlsx");
		
		 byte[] buffer;
		try (FileInputStream inputStream = new FileInputStream(file);
				FileOutputStream outputStream = new FileOutputStream(new File (userPath));)
		{
			buffer = new byte[inputStream.available()];
			inputStream.read(buffer, 0, buffer.length);
			outputStream.write(buffer, 0, buffer.length);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	public void writeExcel2(List<Debit> listDebits, List<Contragent> contragents, List<Act> acts, String excelFilePath) throws IOException {
		File file = new File("/Users/alis/Documents/Проект/SpringMVCHibernateWithSpringSecurityExample/src/main/webapp/static/userforms/Template3.xlsx");
		FileInputStream inputStream_ED = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputStream_ED);
	    Sheet sheet = workbook.getSheet("Лист1");
	    
	    sheet.setDefaultColumnWidth(30);
	    // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        font.setBold(true);
        style.setFont(font);
        for (Debit debits : listDebits) {
	    	Row row = workbook.getSheetAt(0).createRow(sheet.getLastRowNum()+1);  
	    	
	    	
	    		String actDate = "";
			String actNumber = "";
			Double actSumm = null;
			Double actNDS = null;
			if (debits.getActId()==0) {
				actDate = "                  ";
				actNumber = "";
				actSumm = null;
				actNDS = null;
			} else {
				for (Act act : acts) {
					if (act.getActId()==debits.getActId()) {
						actDate = act.getDate();
						actNumber = act.getNumber();
						actSumm = act.getSumm();
						actNDS = act.getSumm()*20/120;
					} 	
				}
			}

			String contragentName = null;
			for (Contragent contragent : contragents) {
				if (contragent.getId()==debits.getContragentID()) {
					contragentName = contragent.getName();
				}
			}
			
			
			
		
			
			
			
			
	        writeDebit2(debits, contragentName, actDate, actNumber, actSumm, actNDS, row);
	    }
	    try (FileOutputStream outputStream = new FileOutputStream(new File(excelFilePath))) {
	        workbook.write(outputStream);
	    }
	}
	private void writeDebit2(Debit debits, String contragentName, String actDate, String actNumber, Double actSumm, Double actNDS, Row row) {
		Cell cell;
		
		 String month = actDate.substring(5, 7);
		
		cell = row.createCell(0);
	    cell.setCellValue(debits.getDate());
	    
	    cell = row.createCell(1);
	    cell.setCellValue(contragentName);
	    
	    cell = row.createCell(2, CellType.NUMERIC);
	    cell.setCellValue(debits.getTotalAmount());
	    
	    switch (month) {
	    case "01":
	    	cell = row.createCell(6);
		    cell.setCellValue("Акт от "+actDate+", №"+ actNumber);
		    
		    cell = row.createCell(7);
		    cell.setCellValue(actSumm);
		    
		    cell = row.createCell(8);
		    cell.setCellValue(actNDS);
		    break;
	    	
	    case "02":
	    		cell = row.createCell(9);
		    cell.setCellValue("Акт от "+actDate+", №"+ actNumber);
		    
		    cell = row.createCell(10);
		    cell.setCellValue(actSumm);
		    
		    cell = row.createCell(11);
		    cell.setCellValue(actNDS);
		    break;
	    case "03":
	    		cell = row.createCell(12);
		    cell.setCellValue("Акт от "+actDate+", №"+ actNumber);
		    
		    cell = row.createCell(13);
		    cell.setCellValue(actSumm);
		    
		    cell = row.createCell(14);
		    cell.setCellValue(actNDS);
		    break;
	    case "04":
	    		cell = row.createCell(15);
		    cell.setCellValue("Акт от "+actDate+", №"+ actNumber);
		    
		    cell = row.createCell(16);
		    cell.setCellValue(actSumm);
		    
		    cell = row.createCell(17);
		    cell.setCellValue(actNDS);
		    break;
	    
	    case "05":
	    		cell = row.createCell(17);
		    cell.setCellValue("Акт от "+actDate+", №"+ actNumber);
		    
		    cell = row.createCell(18);
		    cell.setCellValue(actSumm);
		    cell = row.createCell(19);
		    cell.setCellValue(actNDS);
		    break;
	   
	    case "06":
	    		cell = row.createCell(20);
		    cell.setCellValue("Акт от "+actDate+", №"+ actNumber);
		    
		    cell = row.createCell(21);
		    cell.setCellValue(actSumm);
		    cell = row.createCell(22);
		    cell.setCellValue(actNDS);
	    case "07":
	    		cell = row.createCell(23);
		    cell.setCellValue("Акт от "+actDate+", №"+ actNumber);
		    
		    cell = row.createCell(24);
		    cell.setCellValue(actSumm);
		    
		    cell = row.createCell(25);
		    cell.setCellValue(actNDS);
		    break;
	    case "08":
	    	
	    		cell = row.createCell(26);
		    cell.setCellValue("Акт от "+actDate+", №"+ actNumber);
		    
		    cell = row.createCell(27);
		    cell.setCellValue(actSumm);
		    cell = row.createCell(28);
		    cell.setCellValue(actNDS);
		    break;
	    case "09":
	    	
	    		cell = row.createCell(29);
		    cell.setCellValue("Акт от "+actDate+", #"+ actNumber);
		    
		    cell = row.createCell(30);
		    cell.setCellValue(actSumm);
		    cell = row.createCell(31);
		    cell.setCellValue(actNDS);
		    break;
	    case "10":
	    		cell = row.createCell(32);
		    cell.setCellValue("Акт от "+actDate+", №"+ actNumber);
		    
		    cell = row.createCell(33);
		    cell.setCellValue(actSumm);
		    cell = row.createCell(34);
		    cell.setCellValue(actNDS);
		    break;
	    case "11":
	    		cell = row.createCell(35);
		    cell.setCellValue("Акт от "+actDate+", №"+ actNumber);
		    
		    cell = row.createCell(36);
		    cell.setCellValue(actSumm);
		    cell = row.createCell(37);
		    cell.setCellValue(actNDS);
		    break;
	    case "12":
    			cell = row.createCell(38);
    			cell.setCellValue("Акт от "+actDate+", №"+ actNumber);
	    
    			cell = row.createCell(39);
    			cell.setCellValue(actSumm);
    			cell = row.createCell(40);
    		    cell.setCellValue(actNDS);
    			break;
	    case "  ":
	    	break;
	    default:
	    	
	    	break;
	    }
	    
	}

}
