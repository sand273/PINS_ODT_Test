import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

String councilInfo

def rowsOnSpreadsheet = findTestData('Auto Programming/Cases_Data_AP_LPA').getRowNumbers()

def excelData = findTestData('Auto Programming/Cases_Data_AP_LPA')

def iRow = 1

for (def index : (iRow..rowsOnSpreadsheet)) {
    WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    WebUI.click(findTestObject('GoPro UI/My cases/link_My_Events'))

    WebUI.waitForElementVisible(findTestObject('GoPro UI/Navigation/link_Cases'), 20)

    WebUI.click(findTestObject('GoPro UI/Navigation/link_Cases'))

    WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Summary/input_Search'), 5)

    WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/input_Search'))

    WebUI.sendKeys(findTestObject('Object Repository/GoPro UI/Case Summary/input_Search'), excelData.getValue('Case Number',iRow))

    WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/button_Search'), 10)

    WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/button_Search'))

    try {
        if (WebUI.verifyElementText(findTestObject('GoPro UI/Case Summary/text_Row_Total'), 'Row total: 1') == false) {
            WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/button_Search'))
        }
    }
    catch (Exception ex) {
        WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/button_Search'))

        WebUI.waitForElementVisible(findTestObject('GoPro UI/Cases/select_First_Case'), 20)
    } 
    
    WebUI.delay(2)

    WebUI.click(findTestObject('GoPro UI/Cases/select_First_Case'))

    WebUI.delay(2)

    WebUI.doubleClick(findTestObject('GoPro UI/Cases/select_First_Case'))

    WebUI.switchToWindowIndex(1)

    WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/label_Processing'), 10)

    WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/link_Contacts'), 10)

    WebUI.delay(2)

    WebUI.click(findTestObject('GoPro UI/Case Summary/link_Contacts'))

    WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/label_Council_Info'), 10)

    councilInfo = WebUI.getText(findTestObject('GoPro UI/Case Summary/label_Council_Info'))
	
	println(excelData.getValue('Case Number',iRow))
	
	if (councilInfo == 'Arun District Council')
	{
		CustomKeywords.'custom.WriteExcel.enterValues'(excelData.getValue('Case Number',iRow), GlobalVariable.UploadFilePath + '\\Auto Programming\\CaseNumbersNew.xlsx',
			'Sheet1')
	}

    WebUI.delay(2)

    WebUI.closeWindowIndex(1)

    WebUI.closeBrowser()

    iRow++
}

