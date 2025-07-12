package com.playwiright.basic;

import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class P13_checkBox {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        List<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));

        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions().setViewportSize(null)
        );
        Page page = context.newPage();

        page.navigate("https://artoftesting.com/samplesiteforselenium");

        Locator checkboxes = page.locator("//input[@type='checkbox']");
        System.out.println("Total Number of checkboxes are = " + checkboxes.count());

        checkboxes.nth(1).click();
        Thread.sleep(5000);

        page.close();
        browser.close();
        playwright.close();
    }
}
