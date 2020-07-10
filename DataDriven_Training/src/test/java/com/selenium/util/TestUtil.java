package com.selenium.util;

import java.util.Hashtable;

public class TestUtil {
	//reads data from excel based on test case and keep data in hashtable and the hashtable will be kept in 2 dim array
	public static Object [] [] getData(String tcName,String sheetName,Xls_Reader xls){
		int tcStartrowNum=1;
		System.out.println(xls.getCellData(sheetName, 0, tcStartrowNum));
		while(!xls.getCellData(sheetName, 0, tcStartrowNum).equals(tcName)){
			tcStartrowNum++;
		}
		System.out.println(tcStartrowNum);
		
		int colsstartRowNum=tcStartrowNum+1;
		int cols=0;
		while(!xls.getCellData(sheetName, cols, colsstartRowNum).equals("N")){
			cols++;
		}
		System.out.println(cols);
		
		int dataStartRow=tcStartrowNum+2;
		int rows=0;
		while(!xls.getCellData(sheetName, 0, dataStartRow+rows).equals("N")){
			rows++;
		}
		System.out.println(rows);
		Object [][] data=new Object[rows][1];
		int index=0;
		Hashtable<String,String> table=null;
		for(int rNum=dataStartRow;rNum<dataStartRow+rows;rNum++){
			table=new Hashtable<String,String>();
			for(int cNum=0;cNum<cols;cNum++){
				String key=xls.getCellData(sheetName, cNum, colsstartRowNum);
				String value=xls.getCellData(sheetName, cNum, rNum);
				System.out.println(key);
				table.put(key, value);
				//System.out.print(xls.getCellData(sheetName, cNum, rNum)+"--");
			}
			data[index][0]=table;
			index++;
			System.out.println();
		}
		return data;
	}

}
