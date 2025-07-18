package com.playwiright.basic;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class P5_LaunchInChromeBrowser {
    public static void main(String[] args) throws InterruptedException {
        //Create Playwright Instance
        Playwright playwright = Playwright.create();


        //Launch Browser without headless mode
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().
                setHeadless(false).setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")));

        //From Browser create Page object
        Page page = browser.newPage();

        //Navigate to URL

        page.navigate("https://playwright.dev/java/");
        Thread.sleep(10000);

        //print title
        System.out.println("Title of Page is " + page.title());
        Thread.sleep(10000);
        page.close();
        playwright.close();
    }
}
