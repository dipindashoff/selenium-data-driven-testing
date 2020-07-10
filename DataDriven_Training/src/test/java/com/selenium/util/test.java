package com.selenium.util;

public class test {
	static Xls_Reader xls=new Xls_Reader("D:\\ReddyWorkspace\\DataDriven\\src\\com\\selenium\\xls\\TestData.xlsx");
	public static void main(String[] args) {
		TestUtil u=new TestUtil();
		// TODO Auto-generated method stub
		//System.out.println(xls.getCellData("Sheet1", 0, 1));
		//System.out.println(xls.getRowCount("Sheet1"));
		//System.out.println(xls.getCellData("Sheet2","Object",2));
		u.getData("TC2", "Sheet1", xls);
	}

}
