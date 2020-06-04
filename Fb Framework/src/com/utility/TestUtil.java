package com.utility;

import java.util.ArrayList;

public class TestUtil {
	static Xls_Reader reader;

	public static ArrayList<Object[]> getExcelData() throws Exception {

		ArrayList<Object[]> Data = new ArrayList<Object[]>();

	try {
		    reader = new Xls_Reader("C:\\Users\\Kamal\\eclipse-workspace\\Fb Framework\\ExternalFiles\\FbExcel.xlsx");
			
	} 
		catch (Exception e) 
	{
	e.printStackTrace();
	
	}
			String Sheetname = "TestData";
		int totalrows = reader.getRowCount(Sheetname);
		for (int rowNum = 2; rowNum <= totalrows;rowNum++) 
		{
			String firstname = reader.getCellData(Sheetname,0, rowNum);
			String lastName = reader.getCellData(Sheetname,1, rowNum);
			String email = reader.getCellData(Sheetname,2, rowNum);
			String ConfirmEmail = reader.getCellData(Sheetname,3,rowNum);
			String password = reader.getCellData(Sheetname,4, rowNum);
			String month = reader.getCellData(Sheetname,5, rowNum);
			String day = reader.getCellData(Sheetname,6, rowNum);
			String year = reader.getCellData(Sheetname,7, rowNum);
			String gender = reader.getCellData(Sheetname,8, rowNum);
			//Object Obj[] = {firstname,lastName,email,password,month,day,year,gender};
			Data.add(new Object[] {firstname,lastName,email,ConfirmEmail,password,month,day,year,gender});
		}
		return Data;
	}

	/*
	  public static Object[][] getTestdata(String string) { 
		  // TODO Auto-generated
	     return null; */
	   //  }
	 

}
