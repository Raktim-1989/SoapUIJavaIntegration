package soap;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class RunByTestCase {
	
	@Test
	public void run() throws XmlException, IOException, SoapUIException
	{
	  WsdlProject project = new WsdlProject("D:\\SOAPUI\\LibraryAPIFramework-soapui-project.xml");
	  WsdlTestSuite testSuite = project.getTestSuiteByName("TestSuite");
	 
		 WsdlTestCase testCase =  testSuite.getTestCaseByName("GetBookByAuthorTestCase");
		 TestRunner runner = testCase.run(new PropertiesMap(), false);
		 System.out.println(runner.getStatus());
		 Assert.assertEquals(runner.getStatus(),Status.FINISHED);		 
		  
	  
	}

}
