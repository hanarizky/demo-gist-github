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

//WebUI.callTestCase(findTestCase('TC_SignIn'), [('email') : email, ('password') : password], FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyElementPresent(findTestObject('OR_CreateGist/Page_discoverGists/title_discoverGists'), 2)

WebUI.verifyElementClickable(findTestObject('Object Repository/OR_EditGist/Page_discoverGists/summary_HeaderName'))

WebUI.click(findTestObject('Object Repository/OR_EditGist/Page_discoverGists/summary_HeaderName'))

WebUI.verifyElementClickable(findTestObject('Object Repository/OR_EditGist/Page_discoverGists/a_YourGists'))

WebUI.click(findTestObject('Object Repository/OR_EditGist/Page_discoverGists/a_YourGists'))

TestObject linkFile = new TestObject('linkFile').addProperty('tag', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'strong').addProperty('text', com.kms.katalon.core.testobject.ConditionType.EQUALS, fileName, true)

WebUI.waitForElementVisible(linkFile, 2)

WebUI.scrollToElement(linkFile, 2)

WebUI.waitForElementClickable(linkFile, 2)

WebUI.click(linkFile)

if(testCase == 'DeleteFromView'){
	WebUI.click(findTestObject('Object Repository/OR_EditGist/Page_ListGist/button_Delete'))
	
		WebUI.verifyAlertPresent(3)
		
		WebUI.acceptAlert()
} else if(testCase == "Success"){
		
	WebUI.verifyElementClickable(findTestObject('Object Repository/OR_EditGist/Page_ListGist/a_Edit'))
	
	WebUI.click(findTestObject('Object Repository/OR_EditGist/Page_ListGist/a_Edit'))
	
	WebUI.verifyTextPresent('Editing ' + fileName, false)
	
	if (description != '') {
	    WebUI.clearText(findTestObject('OR_CreateGist/Page_createNewGist/input_description'))
	    WebUI.setText(findTestObject('OR_CreateGist/Page_createNewGist/input_description'), description)
	}
	
	if (fileNameEdit != '') {
	    WebUI.clearText(findTestObject('OR_CreateGist/Page_createNewGist/input_fileName'))
	    WebUI.setText(findTestObject('OR_CreateGist/Page_createNewGist/input_fileName'), fileNameEdit)
	}
	
	if (text != '') {
	    WebUI.clearText(findTestObject('OR_CreateGist/Page_createNewGist/div_textArea'))
	    WebUI.setText(findTestObject('OR_CreateGist/Page_createNewGist/div_textArea'), text)
	}
	
	if (indentMode != '') {
	    WebUI.selectOptionByLabel(findTestObject('OR_CreateGist/Page_createNewGist/select_indentMode'), indentMode, false)
	}
	
	if (indentSize != '') {
	    WebUI.selectOptionByLabel(findTestObject('OR_CreateGist/Page_createNewGist/select_indentSize'), indentSize, true)
	}
	
	if (lineFormat != '') {
	    WebUI.selectOptionByLabel(findTestObject('OR_CreateGist/Page_createNewGist/select_wrapLine'), lineFormat, false)
	}
	
	WebUI.click(findTestObject('Object Repository/OR_EditGist/Page_Editing/button_UpdatePublicGist'))
	
		if (description != '') {
			WebUI.verifyTextPresent(description, false)
		}
		
		if (fileNameEdit != '') {
			WebUI.verifyTextPresent(fileNameEdit, false)
		} else {
			WebUI.verifyTextPresent(fileName, false)
		}
		
	//    if (text != '') {
	//		The verify text area act as a table so it should be devide per row
	//      WebUI.verifyTextPresent(text, false)
	//    }
}
if (testCase == 'Fail') {
	
	WebUI.verifyElementClickable(findTestObject('Object Repository/OR_EditGist/Page_ListGist/a_Edit'))
	
	WebUI.click(findTestObject('Object Repository/OR_EditGist/Page_ListGist/a_Edit'))
	
	WebUI.verifyTextPresent('Editing ' + fileName, false)
	
    WebUI.click(findTestObject('OR_CreateGist/Page_createNewGist/button_addFile'))

    WebUI.click(findTestObject('Object Repository/OR_EditGist/Page_Editing/button_UpdatePublicGist'))

    WebUI.verifyElementPresent(findTestObject('OR_CreateGist/Page_createNewGist/div_validationEmptyContent'), 2)

    WebUI.click(findTestObject('OR_CreateGist/Page_createNewGist/button_removeFile'))
   
} else if(testCase == 'DeleteFromEditing'){
	
	WebUI.verifyElementClickable(findTestObject('Object Repository/OR_EditGist/Page_ListGist/a_Edit'))
	
	WebUI.click(findTestObject('Object Repository/OR_EditGist/Page_ListGist/a_Edit'))
	
	WebUI.verifyTextPresent('Editing ' + fileName, false)
	
	WebUI.click(findTestObject('Object Repository/OR_EditGist/Page_Editing/button_Delete'))

	WebUI.verifyAlertPresent(3)
	
	WebUI.acceptAlert()
}

WebUI.closeBrowser()

