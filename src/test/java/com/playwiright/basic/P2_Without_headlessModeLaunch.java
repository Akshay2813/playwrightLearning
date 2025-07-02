package com.playwiright.basic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class P2_Without_headlessModeLaunch {
    public static void main (String[] args) throws InterruptedException {
        //Create Playwright Instance
        Playwright playwright= Playwright.create();

        //Launch Browser without headless mode
        Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        //From Browser create Page object
        Page page = browser.newPage();

        //Navigate to URL

        page.navigate("https://playwright.dev/java/");

        //print title
        System.out.println("Title of Page is " + page.title());

        //adding delay here observer as playwright is very fast
        Thread.sleep(3000);
        //Close Browser
        page.close();

        //Close Session
        playwright.close();



    }
}
