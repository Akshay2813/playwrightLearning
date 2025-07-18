package com.playwiright.basic;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class P6_LaunchInEdgeBrowser {
    public static void main(String[] args) {
        //Create Playwright Instance
        Playwright playwright = Playwright.create();

        //Launch Browser without headless mode
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().
                setHeadless(false).
                setExecutablePath(Paths.get("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe")));

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
