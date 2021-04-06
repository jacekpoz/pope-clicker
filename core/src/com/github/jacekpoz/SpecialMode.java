package com.github.jacekpoz;

import com.github.jacekpoz.pope.Pope;

public class SpecialMode {

    private SpecialMode() {/*nope*/}

    private static boolean isOn = false;

    public static void specialMode(Pope pope) {
        isOn = !isOn;
        pope.changePope();
    }

    public static boolean isOn() {
        return isOn;
    }
}
