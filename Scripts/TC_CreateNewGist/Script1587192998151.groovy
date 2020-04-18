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
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('TC_SignIn'), [('email') : email, ('password') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OR_CreateGist/Page_discoverGists/title_discoverGists'), 2)

WebUI.click(findTestObject('OR_CreateGist/Page_discoverGists/div_addItem'))

WebUI.setText(findTestObject('OR_CreateGist/Page_createNewGist/input_description'), description)

WebUI.setText(findTestObject('OR_CreateGist/Page_createNewGist/input_fileName'), fileName)

WebUI.setText(findTestObject('OR_CreateGist/Page_createNewGist/div_textArea'), text)

if(indentMode != ""){
WebUI.selectOptionByLabel(findTestObject('OR_CreateGist/Page_createNewGist/select_indentMode'), indentMode, false)
}

if(indentSize != ""){
WebUI.selectOptionByLabel(findTestObject('OR_CreateGist/Page_createNewGist/select_indentSize'), indentSize, true)
}

if(lineFormat != ""){
WebUI.selectOptionByLabel(findTestObject('OR_CreateGist/Page_createNewGist/select_wrapLine'), lineFormat, false)
}

if(testCase == 'Fail'){
WebUI.click(findTestObject('OR_CreateGist/Page_createNewGist/button_addFile'))

WebUI.click(findTestObject('OR_CreateGist/Page_createNewGist/button_createPublicGist'))

WebUI.verifyElementPresent(findTestObject('OR_CreateGist/Page_createNewGist/div_validationEmptyContent'), 2)

WebUI.click(findTestObject('OR_CreateGist/Page_createNewGist/button_removeFile'))

} else if (testCase == 'Success'){

WebUI.click(findTestObject('OR_CreateGist/Page_createNewGist/button_createPublicGist'))

WebUI.verifyTextPresent(description, false)

WebUI.verifyTextPresent(fileName, false)

}



