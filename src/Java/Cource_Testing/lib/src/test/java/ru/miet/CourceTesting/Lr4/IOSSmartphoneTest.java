package ru.miet.CourceTesting.Lr4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Модульный тест IOS-устройств
 */
class IOSSmartphoneTest {
    private IOSSmartphone iosSmartphone;

    @BeforeEach
    public void setUp() {
	iosSmartphone = new IOSSmartphone("Apple", "iPhone 13", 6.1, 0.7, "15", true);
    }

    @Test
    public void testCreateIOSSmartphone() {
	assertEquals("Apple", iosSmartphone.getVendor());
	assertEquals("iPhone 13", iosSmartphone.getModelName());
	assertEquals(6.1, iosSmartphone.getDisplaySize());
	assertEquals("iOS", iosSmartphone.getOs());
	assertEquals(0.7, iosSmartphone.getThickness());
	assertEquals("15", iosSmartphone.getIosVersion());
	assertTrue(iosSmartphone.isHasFaceID());
    }

    @Test
    public void testEnableFaceID() {
	iosSmartphone.enableFaceID();
	assertTrue(iosSmartphone.getStateFaceID());
    }
}
