package com.playwiright.basic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class P1_headlessModeLaunch {
    public static void main (String args[])
    {
        //Create Playwright Instance
        Playwright playwright= Playwright.create();

        //Launch Browser in headless mode by default
        Browser browser= playwright.chromium().launch();

        //From Browser create Page object
        Page page = browser.newPage();

        //Navigate to URL

        page.navigate("https://playwright.dev/java/");

        //print title
        System.out.println("Title of Page is " + page.title());

        //Close Browser
        page.close();

        //Close Session
        playwright.close();



    }
}
