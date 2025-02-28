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

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

WebUI.waitForElementVisible(findTestObject('Other Appeals/link_Other_Appeals'), 5)

WebUI.click(findTestObject('Other Appeals/link_Other_Appeals'))

WebUI.waitForElementVisible(findTestObject('Other Appeals/question_Another_Appeal'), 5)

WebUI.verifyElementText(findTestObject('Other Appeals/question_Another_Appeal'), verData.getValue(1, 52))

WebUI.click(findTestObject('Other Appeals/input_No_Another_Appeal'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Other Appeals/question_Submit_Another_Appeal'), 5)

WebUI.verifyElementText(findTestObject('Other Appeals/question_Submit_Another_Appeal'), verData.getValue(1, 53))

WebUI.click(findTestObject('Other Appeals/option_Submit_Another_Appeal_Yes'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Other Appeals/status_Complete_Another_Appeal'), 10)

WebUI.verifyElementText(findTestObject('Other Appeals/status_Complete_Another_Appeal'), 'COMPLETED')

