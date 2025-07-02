package com.playwiright.basic;

import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;


public class P4_MaximizeWindow_way_2 {
    public static void main(String[] args) throws InterruptedException {
        //Create Playwright Instance
        Playwright playwright = Playwright.create();

        List<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");

        //Launch Browser without headless mode
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));


        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        //From Browser create Page object
        Page page = browserContext.newPage();

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
