package com.playwiright.basic;

import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;

public class P18_OpenLinkInNewTab {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        List<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));

        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

        Page page = browserContext.newPage();

        page.navigate("https://testpages.eviltester.com/styled/page?app=testpages&t=About");


        Page popupPage = page.waitForPopup(() -> {
            page.locator("//a[text()='I (Alan Richardson)']").click();
        });
//<a href="https://eviltester.com" target="_blank" rel="noopener noreferrer">I (Alan Richardson)</a>

        System.out.println("New link open in new tabl " + popupPage.title());
        System.out.println("Earlier  link  " + page.title());

        page.close();
        browser.close();
        playwright.close();

    }
}