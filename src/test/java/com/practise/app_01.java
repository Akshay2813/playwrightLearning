package com.practise;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

public class app_01 {

    public  static  void main (String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://www.saucedemo.com/");

        System.out.println("Launched Page successfully with title = " + page.title());

        page.locator("//input[@name='user-name']").fill("standard_user");
        page.locator("//input[@name='password']").fill("secret_sauce");

        page.locator("//input[@name='login-button']").click();

        //<option value="lohi">Price (low to high)</option>
        page.selectOption("select[class='product_sort_container']","lohi");

        Thread.sleep(2000);
//        <option value="za">Name (Z to A)</option>
        page.selectOption("select[class='product_sort_container']", new SelectOption().setLabel("Name (Z to A)"));


//        Thread.sleep(5000);

        page.selectOption("select[class='product_sort_container']", new SelectOption().setIndex(0));


        Locator dropDown = page.locator("select[class='product_sort_container']>option");

        System.out.println("dropDown count is = " + dropDown.locator("Option").count());

        for(int i=0; i<dropDown.count();i++)
        {
            System.out.println("InnerText is " + dropDown.nth(i).innerText() +" and attribute value is " + dropDown.nth(i).getAttribute("value") );
        }

        System.out.println("Printing option in another way");
        List<ElementHandle> dropDownOptions = page.querySelectorAll("select[class='product_sort_container']>option");
        for (ElementHandle option : dropDownOptions)
        {
            System.out.println("InnerText is " + option.innerText() +" and attribute value is " + option.getAttribute("value") );
        }









    }
}
