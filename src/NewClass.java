
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.fasterxml.jackson.databind.ObjectMapper;

public class NewClass{
public static void main(String[] args) {
            String jobTitle,companyName,payment=null,summary;
        
            WebDriver driver = new HtmlUnitDriver(false);
            driver.get("http://www.indeed.com/q-*-jobs.html");
            String path="//div[@class='  row  result']";  //  "//tagName[@class='classname']//innertag"
            List<WebElement> ds = driver.findElements(By.xpath(path));
            List<PojoClass> webData=new ArrayList<PojoClass>();
            System.out.println("total size of records" + ds.size());
            int count=1;
            for(WebElement e:ds){
                System.out.println(e);
                System.out.println(count);
                jobTitle= e.findElement(By.className("turnstileLink")).getAttribute("title");
                companyName=e.findElement(By.className("company")).getText();
                summary=e.findElement(By.className("summary")).getText();
                try{
                payment=e.findElement(By.tagName("nobr")).getText();
                }
                catch(Exception ex){
                    payment=null;
                    ex.printStackTrace();
                }
                PojoClass wd=new PojoClass();
                wd.setName(companyName);
                wd.setDescription(summary);
                wd.setTitle(jobTitle);
                wd.setMoney(payment);
                webData.add(wd);
            count++;
            }
            convertJson(webData) ;
            driver.close();
    }
    
    private static void convertJson(List<PojoClass> wd) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(  new FileOutputStream("/home/neha/aa.json"), wd);
            String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(wd);
            System.out.println(s);
            
            File file = new File("test.txt");
            FileUtils.writeStringToFile(file, s,true);
        } catch (IOException e) {
            e.printStackTrace();
    }
        
    }
}