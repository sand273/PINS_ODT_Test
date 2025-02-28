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

WebUI.click(findTestObject('GoPro UI/Actions Menu/menu_Actions'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Actions Menu/link_Documents_File'), 5)

WebUI.click(findTestObject('GoPro UI/Actions Menu/link_Documents_File'))

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('GoPro UI/File Upload PopUp/dropdown_Document_Template'), 5)

WebUI.click(findTestObject('GoPro UI/Actions Menu/dropdown_File_Upload_Type'))

WebUI.delay(1)

WebUI.setText(findTestObject('GoPro UI/Actions Menu/text_Template_Box'), templateLetter)

WebUI.waitForElementVisible(findTestObject(menuOption), 10)

WebUI.click(findTestObject(menuOption))

WebUI.waitForElementClickable(findTestObject('GoPro UI/File Upload PopUp/button_Create'), 10)

WebUI.click(findTestObject('GoPro UI/File Upload PopUp/button_Create'))

