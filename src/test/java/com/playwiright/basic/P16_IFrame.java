package com.playwiright.basic;

import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;

public class P16_IFrame {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        List<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));

        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

        Page page = browserContext.newPage();

        page.navigate("https://testpages.eviltester.com/styled/iframes-test.html");
        Locator iframes = page.locator("iframe");
        System.out.println("Total iframe present on webpage is= " + iframes.count());


        //Handle famre
        FrameLocator iframeLocator = page.frameLocator("#thedynamichtml");

        System.out.println(iframeLocator.locator("#iframe1").innerText());


        //Handling second frame
        System.out.println("printing inside message in frame 2 " + page.frameLocator("#theheaderhtml").locator("h1").innerText());
        System.out.println("counting link in frame 2 " + page.frameLocator("#theheaderhtml").locator("a").count());
        page.close();
        browser.close();
        playwright.close();
    }
}
