package com.playwiright.basic;

import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class P12_link {

    public static void main(String[] args)
    {
        Playwright playwright = Playwright.create();
        List<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
        Page page = browser.newPage();
        page.navigate("https://practice.expandtesting.com/dropdown");
        Locator links = page.locator("a");
        System.out.println("total Numbers of links present on page are "+links.count());
        page.close();
        browser.close();
        playwright.close();
    }
}
