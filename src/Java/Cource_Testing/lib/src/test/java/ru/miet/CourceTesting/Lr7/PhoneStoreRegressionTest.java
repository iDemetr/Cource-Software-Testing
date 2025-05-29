package ru.miet.CourceTesting.Lr7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.miet.CourceTesting.Lr4.AndroidSmartphone;
import ru.miet.CourceTesting.Lr4.IOSSmartphone;
import ru.miet.CourceTesting.Lr4.PhoneStoreTest;

class PhoneStoreRegressionTest extends PhoneStoreTest {

    @Override
    @BeforeEach
    public void setUp() {
	store = new PhoneStoreEx("Тестовый Магазин");
    }

    @Test
    void testFeatures() {
	var smartphone = new AndroidSmartphone("Samsung", "Galaxy S21", 6.2, 0.7, "11", true);
	var smartphone1 = new IOSSmartphone("Apple", "iPhone 13", 6.1, 0.7, "15", true);

	store.addSmartphone(smartphone);
	store.addSmartphone(smartphone1);

	var ex = (PhoneStoreEx) store;
	assertEquals(1, ex.getSmartphonesByOS("iOS").size());
    }
}
