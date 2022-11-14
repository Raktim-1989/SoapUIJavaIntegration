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

public class RunByMultipleTestSuite {
	
	@Test
	public void run() throws XmlException, IOException, SoapUIException
	{
	  WsdlProject project = new WsdlProject("D:\\SOAPUI\\LibraryAPIFramework-soapui-project.xml");
	  //String dir = system.getproperty("user.dir") + "/soapui-project.xml";
	  //project -> testsuite -> testcase -> teststep //groovy for automation 
	  
	  for(int j = 0; j<project.getTestSuiteCount(); j++)
	  {
		  WsdlTestSuite testSuite = project.getTestSuiteAt(j);
		  for(int i = 0 ; i<testSuite.getTestCaseCount(); i++)
		  {
			 WsdlTestCase testCase =  testSuite.getTestCaseAt(i);
			 TestRunner runner = testCase.run(new PropertiesMap(), false);
			 
			 System.out.println(runner.getStatus());
			 Assert.assertEquals(runner.getStatus(),Status.FINISHED);		 
			  
		  }
		  
		  
	  }
	  
	  

	}

}
