
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String



def static "custom.WriteExcel.enterValues"(
    	String value	
     , 	String fileName	
     , 	String sheetName	) {
    (new custom.WriteExcel()).enterValues(
        	value
         , 	fileName
         , 	sheetName)
}


def static "custom.WriteExcel.APData"(
    	String value	
     , 	String fileName	
     , 	String sheetName	
     , 	int rowNum	
     , 	int cellNum	) {
    (new custom.WriteExcel()).APData(
        	value
         , 	fileName
         , 	sheetName
         , 	rowNum
         , 	cellNum)
}


def static "custom.WriteExcel.readValues"(
    	String fileName	
     , 	String sheetName	
     , 	String[] values	) {
    (new custom.WriteExcel()).readValues(
        	fileName
         , 	sheetName
         , 	values)
}


def static "custom.WriteExcel.clearValues"(
    	String fileName	
     , 	String sheetName	) {
    (new custom.WriteExcel()).clearValues(
        	fileName
         , 	sheetName)
}


def static "custom.WriteExcel.waitForObject"(
    	int timeOut	
     , 	String object	
     , 	String clickObj	) {
    (new custom.WriteExcel()).waitForObject(
        	timeOut
         , 	object
         , 	clickObj)
}


def static "custom.WriteExcel.readFileInList"(
    	String fileName	) {
    (new custom.WriteExcel()).readFileInList(
        	fileName)
}


def static "custom.RandomNumberGenerator.randomNumber"(
    	int minimum	
     , 	int maximum	) {
    (new custom.RandomNumberGenerator()).randomNumber(
        	minimum
         , 	maximum)
}


def static "custom.VerifyTable.verifyValues"(
    	String tableObj	
     , 	String expTable	) {
    (new custom.VerifyTable()).verifyValues(
        	tableObj
         , 	expTable)
}


def static "custom.VerifyTable.verifyContainsText"(
    	String object	
     , 	String expText	) {
    (new custom.VerifyTable()).verifyContainsText(
        	object
         , 	expText)
}


def static "custom.VerifyTable.verifyTableCount"(
    	String tableObj	
     , 	String expCount	) {
    (new custom.VerifyTable()).verifyTableCount(
        	tableObj
         , 	expCount)
}
