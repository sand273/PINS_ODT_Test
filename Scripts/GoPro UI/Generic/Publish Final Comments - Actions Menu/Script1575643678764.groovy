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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

WebUI.waitForElementClickable(findTestObject('GoPro UI/Actions Menu/menu_Actions'), 10)

WebUI.click(findTestObject('GoPro UI/Actions Menu/menu_Actions'))

WebUI.waitForElementClickable(findTestObject('GoPro UI/Actions Menu/button_Publish Final Comments'), 10)

try {
    WebUI.click(findTestObject('GoPro UI/Actions Menu/button_Publish Final Comments'))
}
catch (Exception ex) {
    WebUI.refresh()

    WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

    WebUI.click(findTestObject('GoPro UI/Actions Menu/menu_Actions'))

    WebUI.waitForElementClickable(findTestObject('GoPro UI/Actions Menu/button_Publish Final Comments'), 10)

    WebUI.click(findTestObject('GoPro UI/Actions Menu/button_Publish Final Comments'))
} 

WebUI.waitForElementPresent(findTestObject('GoPro UI/Actions Menu/message_Publish_Questionaire'), 10)

WebUI.click(findTestObject('GoPro UI/Programming/button_Publish'))

