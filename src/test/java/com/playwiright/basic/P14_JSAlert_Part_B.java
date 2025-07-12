package com.playwiright.basic;

import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;

public class P14_JSAlert_Part_B {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        List<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));

        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browserContext.newPage();
        page.navigate("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

        page.onDialog(dialog -> {
            System.out.println("Dialog type: " + dialog.type());
            System.out.println("Dialog message: " + dialog.message());

            try {
                Thread.sleep(3000); // Wait for visual confirmation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (dialog.type()) {
                case "alert":
                    dialog.accept();
                    break;
                case "confirm":
                    dialog.dismiss();
                    break;
                case "prompt":
                    dialog.accept("TESTNAME");
                    break;
            }
        });

        page.locator("//input[@id='alertexamples']").click();

        Thread.sleep(2000);

        page.locator("//input[@id='confirmexample']").click();
        Thread.sleep(2000);

        page.locator("//input[@id='promptexample']").click();
        Thread.sleep(2000);
        String promptResult = page.locator("#promptreturn").textContent();
        System.out.println("Prompt Result = " + promptResult);
        page.close();
        browser.close();
        playwright.close();

//        page.locator("//input[@value='Show alert box']").click();

    }
}
