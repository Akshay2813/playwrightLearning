package com.playwiright.basic;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class P7_LaunchInFireFoxBrowser {
    public static void main(String[] args) {
        //Create Playwright Instance
        Playwright playwright = Playwright.create();

        List<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");

        //Launch Browser without headless mode
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().
                setHeadless(false).setArgs(arguments));

        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        //From Browser create Page object
        Page page = browserContext.newPage();

        //Navigate to URL

        page.navigate("https://playwright.dev/java/");

        //print title
        System.out.println("Title of Page is " + page.title());

        page.close();
        playwright.close();


    }
}
