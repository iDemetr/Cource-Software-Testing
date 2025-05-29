package ru.miet.CourceTesting.Lr4;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Модульный тест магазина
 */
public class PhoneStoreTest {
    protected PhoneStore store;

    @BeforeEach
    public void setUp() {
	store = new PhoneStore("Тестовый Магазин");
    }

    @Test
    public void testAddSmartphone() {
	var smartphone = new AndroidSmartphone("Samsung", "Galaxy S21", 6.2, 0.7, "11", true);
	store.addSmartphone(smartphone);
	assertEquals(1, store.getSmartphones().size());
	assertEquals("Galaxy S21", store.getSmartphones().get(0).getModelName());
    }

    @Test
    public void testAddNullSmartphone() {
	assertThrows(IllegalArgumentException.class, () -> {
	    store.addSmartphone(null);
	});
	assertEquals(0, store.getSmartphones().size());
    }

    @Test
    public void testInitStoreName() {
	assertEquals("Тестовый Магазин", store.getStoreName());
    }

    @Test
    public void testRenameStoreName() {
	store.setStoreName("New name");
	assertEquals("New name", store.getStoreName());
    }

    @Test
    public void testSellSmartphone() {
	var smartphone = new AndroidSmartphone("Samsung", "Galaxy S21", 6.2, 0.7, "11", true);
	store.addSmartphone(smartphone);
	store.sellSmartphone(smartphone);
	assertEquals(0, store.getSmartphones().size());
	assertEquals(1, store.getSelledSmartphones().size());
    }

    @Test
    public void testSellFakeSmartphone() {
	var smartphone = new AndroidSmartphone("Samsung", "Galaxy S21", 6.2, 0.7, "11", true);
	var smartphone1 = new AndroidSmartphone("Samsung", "Galaxy S433", 10.2, 0.1, "110", true);
	store.addSmartphone(smartphone);
	assertThrows(IllegalArgumentException.class, () -> {
	    store.sellSmartphone(smartphone1);
	});
	assertEquals(1, store.getSmartphones().size());
	assertEquals(0, store.getSelledSmartphones().size());
    }
}
