package tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class Test_comparingsheets {

	public static void main(String[] args) throws IOException {

		// using FIS class to fetch my 2 files. 
		FileInputStream file1= new FileInputStream("/Users/kranthib.irlapati/Desktop/Sheet1_Veeva.xls");   
		FileInputStream file2= new FileInputStream("/Users/kranthib.irlapati/Desktop/Sheet2_Veeva.xls");
		
		HSSFWorkbook excel1= new HSSFWorkbook(file1);               		//the reason i used HSSF is because of .xls format. As i'm using mac and i dont have a Microsoft excel. I've created from Numbers application and thats the extension it has created. I've used .csv too, but- the console is throwing error stating" it can't get into the file" 
		HSSFSheet f1sheet1 = excel1.getSheet("ID Names1");                  //trying to fetch the data with the sheet name inside the file
		HSSFWorkbook excel2 = new HSSFWorkbook(file2);
		HSSFSheet f2sheet2 = excel2.getSheet("ID Names2");
		
		int f1TotalRows= f1sheet1.getLastRowNum();                          // to check how many rows are existing. Returns with the index value(3).
		int f2TotalRows= f2sheet2.getLastRowNum(); 																			 
		 
		 //i'd like to check my each row value against the 2 files and compare it. 										
		 
		 if(f1TotalRows==f2TotalRows) {								
			 for(int i=1; i<=f1TotalRows;i++) {
				HSSFRow row1= f1sheet1.getRow(i);							// fetching all the rows in both the sheets
				HSSFRow row2=f2sheet2.getRow(i);
				
				String f1idvalue= "";
				HSSFCell id1 = row1.getCell(0);								//the loop will go check for all the values of the rows of cell0 (7,8,9 will be returning)
				if(id1!=null) {
					id1.setCellType(CellType.STRING);						//i'm setting the cell value to a String. I can use .setCellValue(String) too but, as i grabbed .getCell in line 36 for the variable id1 and its type has to be HSSFCell.
					f1idvalue= id1.getStringCellValue();						// grabbing the cell value which is converted to a string. the values (7,8,9) will be returning.
				}
				String f2idvalue= "";
				HSSFCell id2 = row2.getCell(0);
				if(id2!=null) {
					id2.setCellType(CellType.STRING);
					f2idvalue= id2.getStringCellValue();						//the values 7,8,910 will be returning
					}
					if(f1idvalue.equals(f2idvalue)){
						System.out.println("Match: The id " +f1idvalue+ " in file1 and the id " +f2idvalue+ " in file2 are equal");
					}
					if(!f1idvalue.equals(f2idvalue)) {							//comparing the content in both idvalue and idvalue2.
						System.out.println("Mismatch: The Id " + f1idvalue + " in file1 and the Id " +f2idvalue+ " in file2 are not equal.");
					}
					
					String f1namevalue= "";
					HSSFCell name1=row1.getCell(1);								//grabbing the cell value which is converted.
					if(name1!=null) {
						name1.setCellType(CellType.STRING);
						f1namevalue=name1.getStringCellValue();
					}
					String f2namevalue= "";
					HSSFCell name2= row2.getCell(1);
					if(name2!=null) {
						name2.setCellType(CellType.STRING);
						f2namevalue=name2.getStringCellValue();
					}
					if(f1namevalue.equals(f2namevalue)) {
						System.out.println("Match: The name " +f1namevalue+ " in file1 and the name " +f2namevalue+ " in file2 are equal.");
					}
					if(!f1namevalue.equals(f2namevalue)) {
						System.out.println("Mismatch: The name " + f1namevalue + " in file1 and the name " +f2namevalue+ " in file2 are not equal.");
					}	
				}
			 }
		 }	

	}

