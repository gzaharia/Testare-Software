package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompleteTask {

    public void goToNikeStoreAndCompleteTask(String page) throws InterruptedException, IOException {
        WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zaharia Gabriel\\Desktop\\AnulIII\\Testare Software\\edu-utm-gabi-testing\\src\\test\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www." + page);

        WebElement europe = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/button[3]"));
        europe.click();
        Thread.sleep(500);

        WebElement romania = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/ul/li[22]/a"));
        romania.click();
        System.out.println("---------------------------");
        Thread.sleep(500);

        WebElement men = driver.findElement(By.xpath("//*[@id=\"hotspot0\"]/a"));
        men.click();
        Thread.sleep(500);

        WebElement boys = driver.findElement(By.xpath("//*[@id=\"exp-gridwall-wrapper\"]/div[2]/div[1]/div/ul/li[2]/a"));
        boys.click();
        Thread.sleep(1000);

        WebElement redColor = driver.findElement(By.xpath("//*[@id=\"exp-gridwall-wrapper\"]/div[2]/div[1]/div[3]/div[6]/div[2]/ul/a[6]"));
        redColor.click();
        Thread.sleep(500);

        List<WebElement> allTitles = driver.findElements(By.className("product-name"));
        List<WebElement> allPrices = driver.findElements(By.className("prices"));

        int i = 0;
        String fileText = "";
        List<String> sortedPrices = new ArrayList<>();
        List<String> titles = new ArrayList<>();

        for (WebElement price : allPrices) {
            String priceText = price.getText();
            sortedPrices.add(priceText);
            String Url = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;", allTitles.get(i++));
            final Pattern pattern = Pattern.compile("class=\"product-display-name nsg-font-family--base edf-font-size--regular nsg-text--dark-grey\">(.+?)<");
            final Matcher matcher = pattern.matcher(Url);
            matcher.find();
            titles.add(matcher.group(1));

        }

        for (i = 0; i < sortedPrices.size(); i++) {
            Collections.sort(sortedPrices);
            fileText = fileText + titles.get(i) + ",  " + sortedPrices.get(i) + "\n";
        }

        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ListOfProducts.csv"), "utf-8"));
        writer.write(fileText);
        writer.close();


        System.out.println((char) 27 + "[32m" + "Product with lowest price: " + (char) 27 + "[30m");
        System.out.println(titles.get(1) + ",  " + sortedPrices.get(1));
        driver.close();

    }
}