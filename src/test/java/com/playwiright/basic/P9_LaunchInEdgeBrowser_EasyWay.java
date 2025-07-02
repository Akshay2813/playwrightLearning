package com.playwiright.basic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class P9_LaunchInEdgeBrowser_EasyWay {
    public static void main(String[] args) {
        //Create Playwright Instance
        Playwright playwright = Playwright.create();
        
        //Launch Browser without headless mode
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").
                setHeadless(false));

        //From Browser create Page object
        Page page = browser.newPage();

        //Navigate to URL

        page.navigate("https://playwright.dev/java/");

        //print title
        System.out.println("Title of Page is " + page.title());

        page.close();
        playwright.close();
    }
}
