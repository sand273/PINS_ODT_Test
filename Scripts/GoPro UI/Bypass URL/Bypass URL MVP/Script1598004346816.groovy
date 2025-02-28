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

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('GoPro UI/My cases/link_My_Events'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Navigation/link_Cases'), 20)

WebUI.click(findTestObject('GoPro UI/Navigation/link_Cases'))

WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Summary/input_Search'), 5)

WebUI.waitForElementVisible(findTestObject('GoPro UI/Cases/select_First_Case'), 10)

WebUI.click(findTestObject('GoPro UI/Cases/select_First_Case'))

WebUI.delay(2)

WebUI.doubleClick(findTestObject('GoPro UI/Cases/select_First_Case'))

WebUI.switchToWindowIndex(1)

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/label_Processing'), 10)

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Bypass URL - Actions Menu'), [('AppealType') : 'string:100-MVP', ('writeFlag') : 'Y'], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.URLCheck = 'MVP'

WebUI.closeWindowIndex(1)

WebUI.closeBrowser()
