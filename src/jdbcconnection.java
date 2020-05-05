import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import com.mysql.cj.jdbc.StatementImpl;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.ResultSet;



public class jdbcconnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String host="localhost";
		String port="3306";
		
		Connection con= DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qadbt", "root", "0414");
		
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * from employeeinfo where id=4");
		while(rs.next())
		{
			WebDriver driver = new ChromeDriver();
			System.setProperty("webdriver.chrome.driver", "C://Program Files//Java//chromedriver.exe");
			driver.get("https://login.salesforce.com/");
			
			
			driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("name"));	
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("location"));
		}
		

	}

}
