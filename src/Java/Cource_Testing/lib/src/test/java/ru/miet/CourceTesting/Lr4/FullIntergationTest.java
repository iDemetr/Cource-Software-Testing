package ru.miet.CourceTesting.Lr4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Интеграционный тест магазина и сервисного центра
 */
class FullIntergationTest {

    private PhoneStore store;
    private ServiceCenter serviceCenter;

    @BeforeEach
    public void setUp() {
	serviceCenter = new ServiceCenter("Сервисный Центр");
	store = new PhoneStore("Тестовый Магазин");
	store.pushServiceCenter(serviceCenter);
	serviceCenter.pushOfficialStore(store);
    }

    @Test
    public void defaultTestSellAndRestoreSmartphones() {
	var smartphone1 = new AndroidSmartphone("Samsung", "Galaxy S21", 6.2, 0.7, "11", true);
	var smartphone2 = new IOSSmartphone("Apple", "iPhone 13", 6.1, 0.7, "15", true);

	// Отправка устройств на прилавок магазина
	store.addSmartphone(smartphone1);
	store.addSmartphone(smartphone2);

	// Продажа одного из устройств
	store.sellSmartphone(smartphone1);

	var services = store.getCertifiedServiceCenter();
	// Отправка в сервисный центр устройства по гарантии
	assertTrue(services.stream().anyMatch(x -> x.registerRepair(smartphone1)));

	// Ремонт устройства
	assertTrue(serviceCenter.completeRepair(smartphone1));
    }

    @Test
    public void TestSellAndRestoreFakeSmartphones() {
	var smartphone1 = new AndroidSmartphone("Samsung", "Galaxy S21", 6.2, 0.7, "11", true);
	var smartphone2 = new IOSSmartphone("Apple", "iPhone 13", 6.1, 0.7, "15", true);
	var fakeStore = new PhoneStore("Фейковый магазин");

	// Магазин пытается скопировать сертификаты на ремонт в официанльных СЦ
	store.pushServiceCenter(serviceCenter);

	// Отправка устройств на прилавок магазина
	fakeStore.addSmartphone(smartphone1);
	fakeStore.addSmartphone(smartphone2);

	// Продажа одного из устройств
	fakeStore.sellSmartphone(smartphone1);

	var services = store.getCertifiedServiceCenter();
	// Отправка в сервисный центр устройства по гарантии
	assertFalse(services.stream().anyMatch(x -> x.registerRepair(smartphone1)));

	// Ремонт устройства
	assertThrows(IllegalArgumentException.class, () -> {
	    serviceCenter.completeRepair(smartphone1);
	});
    }
}