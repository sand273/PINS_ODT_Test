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
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

GlobalVariable.AllocationMatrix = 3

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

WebUI.waitForElementVisible(findTestObject('Application Technical Reports/link_Technical_Reports'), 5)

WebUI.click(findTestObject('Application Technical Reports/link_Technical_Reports'))

WebUI.waitForElementVisible(findTestObject('Application Technical Reports/message_Technical_Reports', [('index') : 1]), 
    5)

WebUI.verifyElementText(findTestObject('Application Technical Reports/message_Technical_Reports', [('index') : 1]), verData.getValue(1, 62))

WebUI.click(findTestObject('Application Technical Reports/message_Technical_Reports', [('index') : 1]))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Technical Reports Post Decision/button_Add_Another_File'), 5)

WebUI.waitForElementVisible(findTestObject('Technical Reports Post Decision/dropdown_Select_Report_Type'), 5)

WebUI.selectOptionByValue(findTestObject('Technical Reports Post Decision/dropdown_Select_Report_Type'), 'Air Quality Assessment', 
    false)

WebUI.waitForElementClickable(findTestObject('Planning Application details/button_Save_Continue'), 5)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Technical Reports Post Decision/status_Complete_Technical_Reports'), 10)

WebUI.verifyElementText(findTestObject('Technical Reports Post Decision/status_Complete_Technical_Reports'), 'COMPLETED')

