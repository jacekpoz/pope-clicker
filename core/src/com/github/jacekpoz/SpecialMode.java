package com.github.jacekpoz;

import static com.github.jacekpoz.GlobalVars.*;

public class SpecialMode {

    private SpecialMode() {/*nope*/}

    private static boolean isOn = false;

    public static void specialMode() {
        isOn = !isOn;
        POPE.changePope();
    }

    public static boolean isOn() {
        return isOn;
    }
}
