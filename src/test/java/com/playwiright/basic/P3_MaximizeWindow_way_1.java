package com.playwiright.basic;

import com.microsoft.playwright.*;

import java.awt.*;

public class P3_MaximizeWindow_way_1 {
    public static void main(String[] args) throws InterruptedException {
        //Create Playwright Instance
        Playwright playwright = Playwright.create();

        //Launch Browser without headless mode
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        //Maximize browser
//        BrowserContext browserContext= browser.newContext(
//                new Browser.NewContextOptions().setViewportSize(1528,720)
//        );

        // How to get screensize
        Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) scrnSize.getWidth();
        int height = (int) scrnSize.getHeight();
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
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
