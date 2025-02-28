import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

def verData = TestDataFactory.findTestData('Data Files/GoPro_UI_Verification')

Date eventDate

Date today = new Date()

use(groovy.time.TimeCategory, { 
        eventDate = (today + 11.weeks)
    })


WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

if (GlobalVariable.caseType == 'Hearing') {
    WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal - Hearing'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
    WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('GoPro UI/Programming/link_Programming'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Programming/title_Programming'), 5)

WebUI.verifyElementVisible(findTestObject('GoPro UI/Programming/dropdown_Event'))

WebUI.verifyElementText(findTestObject('GoPro UI/Programming/dropdown_Event'), verData.getValue(1, 4))

WebUI.selectOptionByValue(findTestObject('GoPro UI/Programming/dropdown_Event'), 'USV', false)

WebUI.waitForElementVisible(findTestObject('GoPro UI/Programming/date_Event'), 5)

WebUI.setText(findTestObject('GoPro UI/Programming/date_Event'), eventDate.format('dd/MM/yyyy').toString())

WebUI.scrollToElement(findTestObject('GoPro UI/Case Summary/button_Save'), 3)

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Save'))

WebUI.click(findTestObject('GoPro UI/Case Summary/link_Timeline'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/title_Timeline'), 5)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Programming/date_Event'), 'value', eventDate.format('dd/MM/yyyy').toString(), 
    1)

WebUI.click(findTestObject('GoPro UI/Case Summary/link_Processing'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Summary/label_Processing'), 5)

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Decision_Pending'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Summary/label_Processing'), 5)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Decision_Pending'), 'defaultSelected', 
    'true', 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.callTestCase(findTestCase('GoPro UI/Generic/File Upload - Actions Menu'), [('menuOption'):'GoPro UI/Actions Menu/option_Appeal_Decision', ('templateLetter'): verData.getValue(1, 14)], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('GoPro UI/Generic/File Upload - Actions Menu'), [('menuOption'):'GoPro UI/Actions Menu/option_Cover_Letter', ('templateLetter'): verData.getValue(1, 16)], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('GoPro UI/Generic/File Upload - Actions Menu'), [('menuOption'):'GoPro UI/Actions Menu/option_Appeal_Decision_Letter', ('templateLetter'): verData.getValue(1, 13)], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.refresh()

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Summary/input_Search'), 20)

WebUI.click(findTestObject('GoPro UI/Case Summary/input_Search'))

WebUI.sendKeys(findTestObject('GoPro UI/Case Summary/input_Search'), verData.getValue(1, 14))

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Search'))

if (WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_Appeal_Highlight'), 10) == false) {
    CustomKeywords.'custom.WriteExcel.waitForObject'(180, 'GoPro UI/Case Documents/link_Appeal_Highlight', 'GoPro UI/Case Summary/button_Search')
}

WebUI.verifyElementText(findTestObject('GoPro UI/Case Documents/link_Appeal_Highlight'), verData.getValue(1, 14))

WebUI.click(findTestObject('GoPro UI/Case Documents/link_Appeal_Highlight'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/status_Appeal_InDraft'), 5)

WebUI.delay(2)

WebUI.click(findTestObject('GoPro UI/Case Documents/status_Appeal_InDraft'))

WebUI.selectOptionByIndex(findTestObject('GoPro UI/Case Documents/dropdown_Status_Change'), 4, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('GoPro UI/Case Documents/button_Primary'))

WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Summary/input_Search'), 20)

WebUI.clearText(findTestObject('GoPro UI/Case Summary/input_Search'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('GoPro UI/Case Summary/input_Search'))

WebUI.sendKeys(findTestObject('GoPro UI/Case Summary/input_Search'), verData.getValue(1, 13))

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Search'))

if (WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'), 10) == false) {
	CustomKeywords.'custom.WriteExcel.waitForObject'(180, 'GoPro UI/Case Documents/link_LPA_Statement', 'GoPro UI/Case Summary/button_Search')
}

WebUI.verifyElementText(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'), verData.getValue(1, 13))

WebUI.click(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/status_Appeal_InDraft'), 5)

WebUI.delay(2)

WebUI.click(findTestObject('GoPro UI/Case Documents/status_Appeal_InDraft'))

WebUI.selectOptionByIndex(findTestObject('GoPro UI/Case Documents/dropdown_Status_Change'), 4, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('GoPro UI/Case Documents/button_Primary'))

WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Summary/input_Search'), 20)

WebUI.clearText(findTestObject('GoPro UI/Case Summary/input_Search'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('GoPro UI/Case Summary/input_Search'))

WebUI.sendKeys(findTestObject('GoPro UI/Case Summary/input_Search'), verData.getValue(1, 16))

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Search'))

if (WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'), 10) == false) {
	CustomKeywords.'custom.WriteExcel.waitForObject'(180, 'GoPro UI/Case Documents/link_LPA_Statement', 'GoPro UI/Case Summary/button_Search')
}

WebUI.verifyElementText(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'), verData.getValue(1, 16))

WebUI.click(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/status_Appeal_InDraft'), 5)

WebUI.delay(2)

WebUI.click(findTestObject('GoPro UI/Case Documents/status_Appeal_InDraft'))

WebUI.selectOptionByIndex(findTestObject('GoPro UI/Case Documents/dropdown_Status_Change'), 4, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('GoPro UI/Case Documents/button_Primary'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'), 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.closeWindowIndex(1)

WebUI.closeBrowser()

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

if (GlobalVariable.caseType == 'Hearing') {
    WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal - Hearing'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
    WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Publish Decision - Actions Menu'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

