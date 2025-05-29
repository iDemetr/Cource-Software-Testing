package ru.miet.CourceTesting.Lr4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.miet.CourceTesting.Lr3.Smartphone;

/**
 * Интеграционный тест магазина с Mock сервисным центром и реальными телефонами
 */
class IntergationTestPhoneStore {
    private PhoneStore store;

    @BeforeEach
    public void setUp() {
	store = new PhoneStore("Тестовый Магазин");
    }

    @Test
    public void testAddAndRetrieveSmartphones() {
	Smartphone smartphone1 = new AndroidSmartphone("Samsung", "Galaxy S21", 6.2, 0.7, "11", true);
	Smartphone smartphone2 = new IOSSmartphone("Apple", "iPhone 13", 6.1, 0.7, "15", true);

	store.addSmartphone(smartphone1);
	store.addSmartphone(smartphone2);

	assertEquals(2, store.getSmartphones().size());
	assertEquals("Samsung", store.getSmartphones().get(0).getVendor());
	assertEquals("Apple", store.getSmartphones().get(1).getVendor());
    }

    @Test
    public void testServiceCenterIntegration() {
	store.pushServiceCenter(new ServiceCenterMock("Сервисный Центр")); // Создаем заглушку
	assertEquals(1, store.getCertifiedServiceCenter().size());
    }
}

class ServiceCenterMock extends ServiceCenter {
    public ServiceCenterMock(String centerName) {
	super(centerName);
	// TODO Auto-generated constructor stub
    }
}
