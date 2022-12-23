
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportsGenerater {
	public ExtentReports ep;
	
	public void reports() {
		
		ExtentSparkReporter esp=new ExtentSparkReporter(System.getProperty("user.dir")+"//src//test//resources//repo.html");
		esp.config().setReportName("captialMangementsystem");
		esp.config().setTimeStampFormat("hh:mm:sec");
		esp.config().setDocumentTitle("Testing Reportes");
		 ep=new ExtentReports();
		 ep.attachReporter(esp);
		
	}
   
	
}
