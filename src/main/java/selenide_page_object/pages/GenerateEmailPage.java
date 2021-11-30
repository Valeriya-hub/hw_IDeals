package selenide_page_object.pages;

import java.util.Random;

public class GenerateEmailPage {
    public static String getRandomEmail() {
        String name = "vperska";
        return name + "+" + getRandomOwnIdentifier() + "@gmail.com";
    }

    public static String getRandomOwnIdentifier() {
        final int ownIdentifier1 = 9;
        String s = "123456789";
        StringBuffer identifier = new StringBuffer();

        for (int i = 0; i < ownIdentifier1; i++) {
            identifier.append(s.charAt(new Random().nextInt(s.length())));
        }
        return identifier.toString();
    }
}
