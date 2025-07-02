package com.playwiright.basic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class P10_navigateMethod {
    public static void main(String[] args) throws InterruptedException {
        //Create Playwright Instance
        Playwright playwright = Playwright.create();

        //Launch Browser without headless mode
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").
                setHeadless(false));

        //From Browser create Page object
        Page page = browser.newPage();

        //Navigate to URL

        page.navigate("https://playwright.dev/java/");

        Thread.sleep(10000);
        page.navigate("https://www.google.com/");

        page.goBack();
        System.out.println("Title of Page is " + page.title());

        Thread.sleep(10000);

        page.goForward();
        //print title
        System.out.println("Title of Page is " + page.title());
        Thread.sleep(10000);
        page.reload();
        Thread.sleep(10000);

        page.close();
        playwright.close();
    }
}
