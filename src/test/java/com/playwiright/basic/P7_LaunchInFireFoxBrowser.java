package com.playwiright.basic;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class P7_LaunchInFireFoxBrowser {
    public static void main(String[] args) {
        //Create Playwright Instance
        Playwright playwright = Playwright.create();

        //Launch Browser without headless mode
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().
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
