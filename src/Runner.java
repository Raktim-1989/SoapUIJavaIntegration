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


public class Runner {

	@Test
	public void run() throws XmlException, IOException, SoapUIException
	{
	  WsdlProject project = new WsdlProject("D:\\SOAPUI\\calculator-soapui-project.xml");
	  WsdlTestSuite testSuite = project.getTestSuiteByName("TestSuite");
	  for(int i = 0 ; i<testSuite.getTestCaseCount();i++)
	  {
		 WsdlTestCase testCase =  testSuite.getTestCaseAt(i);
		 TestRunner runner = testCase.run(new PropertiesMap(), false);
		 System.out.println(runner.getStatus());
		 Assert.assertEquals(runner.getStatus(),Status.FINISHED);		 
		  
	  }
	  

	}

}
