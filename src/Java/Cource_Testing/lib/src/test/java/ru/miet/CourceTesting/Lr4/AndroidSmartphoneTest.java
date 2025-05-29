package ru.miet.CourceTesting.Lr4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Модульный тест андройд-устройств
 */
class AndroidSmartphoneTest {
    private AndroidSmartphone androidSmartphone;

    @BeforeEach
    public void setUp() {
	androidSmartphone = new AndroidSmartphone("Samsung", "Galaxy S21", 6.2, 0.7, "11", true);
    }

    @Test
    public void testCreateAndroidSmartphone() {
	assertEquals("Samsung", androidSmartphone.getVendor());
	assertEquals("Galaxy S21", androidSmartphone.getModelName());
	assertEquals(6.2, androidSmartphone.getDisplaySize());
	assertEquals("Android", androidSmartphone.getOs());
	assertEquals(0.7, androidSmartphone.getThickness());
	assertEquals("11", androidSmartphone.getAndroidVersion());
	assertTrue(androidSmartphone.isHasNFC());
    }

    @Test
    public void testEnableNFC() {
	androidSmartphone.enableNFC();
	assertTrue(androidSmartphone.getStateNFC());
    }
}
