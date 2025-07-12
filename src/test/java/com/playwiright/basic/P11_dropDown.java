package com.playwiright.basic;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

public class P11_dropDown {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://practice.expandtesting.com/dropdown");

        System.out.println("Launched Page successfully with title = " + page.title());

        //Selecting values
        page.selectOption("Select[id='dropdown']", "2");

        //Selecting using Index
        page.selectOption("select[id='elementsPerPageSelect']", new SelectOption().setIndex(2));
        Thread.sleep(5000);
        //<option value="AS">American Samoa</option>
        page.selectOption("select[id='country']", new SelectOption().setLabel("American Samoa"));
        System.out.println("Using Inner text Selected Option " + page.locator("#country option:checked").innerText());

//        <option value="AX">Aland Islands</option>
        page.selectOption("select[id='country']", new SelectOption().setValue("AX"));
        System.out.println("Using Value Selected Option " + page.locator("#country option:checked").textContent());


        page.selectOption("select[id='country']", new SelectOption().setIndex(7));
        System.out.println("Using indexing Selected Option " + page.locator("#country option:checked").getAttribute("value"));

        //Using for loope seelct option
        Locator options = page.locator("//Select[@id = 'country']/option");
        System.out.println("total number of option available in options are " + options.count());

        for (int i=0; i<options.count();i++)
        {
            System.out.println("Inner text is "+options.nth(i).innerText()  +" and text content is" +
                    options.nth(i).textContent() +"and Values = " +  options.nth(i).getAttribute("value"));
            if(options.nth(i).innerText().equalsIgnoreCase("Viet Nam"))
            {
                String value = options.nth(i).getAttribute("value");
                page.selectOption("#country", value);

            }
        }
        System.out.println("Using indexing Selected Option " + page.locator("#country option:checked").getAttribute("value"));

        page.close();
        browser.close();
        playwright.close();
    }
}
