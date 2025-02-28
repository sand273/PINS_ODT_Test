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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

def planData = TestDataFactory.findTestData('Data Files/Planning_Details')

def siteData = TestDataFactory.findTestData('Data Files/Site_Details')

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

WebUI.waitForElementVisible(findTestObject('Appeal Summary/status_Submitted'), 5)

WebUI.verifyElementAttributeValue(findTestObject('Appeal Summary/heading_Application_Ref'), 'innerText', GlobalVariable.ApplicationRef, 
    5)

WebUI.verifyElementText(findTestObject('Appeal Summary/status_Submitted'), verData.getValue(1, 77))

WebUI.verifyElementText(findTestObject('Appeal Summary/label_Appellant_Name'), planData.getValue(1, 1))

WebUI.verifyElementText(findTestObject('Appeal Summary/label_Application_Ref'), planData.getValue(2, 1))

WebUI.verifyElementText(findTestObject('Appeal Summary/links_Appeal_Data'), verData.getValue(1, 76))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

