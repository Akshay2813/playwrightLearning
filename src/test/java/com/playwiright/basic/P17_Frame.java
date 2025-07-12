package com.playwiright.basic;

import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;

public class P17_Frame {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        List<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));

        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

        Page page = browserContext.newPage();

        page.navigate("https://testpages.eviltester.com/styled/frames/frames-test.html");
        //<frame name="middle" src="get-list?name=Middle&amp;list=40" scrolling="yes">

        Frame frame = page.frame("middle");
        System.out.println(frame.locator("#middle3").textContent());
        page.close();
        browser.close();
        playwright.close();
    }
}
