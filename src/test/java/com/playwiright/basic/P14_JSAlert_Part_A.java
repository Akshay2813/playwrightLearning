package com.playwiright.basic;

import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;

public class P14_JSAlert_Part_A {

    public static void main (String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        List<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));

        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browserContext.newPage();
        page.navigate("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

        page.onDialog(dialog -> {
            System.out.println(dialog.message());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            dialog.accept();
        });
        page.locator("//input[@id='alertexamples']").click();

        page.locator("//input[@id='confirmexample']").click();

        page.locator("//input[@id='promptexample']").click();


        page.close();
        browser.close();
        playwright.close();

    }
}
