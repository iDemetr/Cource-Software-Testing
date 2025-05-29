package ru.miet.CourceTesting.Lr4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.miet.CourceTesting.Lr3.Smartphone;

/**
 * Интеграционный тест сервисного центра с Mock магазинами и реальными
 * телефонами
 */
class IntergationTestServiceCenter {
    private ServiceCenter serviceCenter;
    private Smartphone smartphone;

    @BeforeEach
    public void setUp() {
	serviceCenter = new ServiceCenter("Сервисный Центр");
	smartphone = new AndroidSmartphone("Samsung", "Galaxy S21", 6.2, 0.7, "11", true);

	var mockStore = new PhoneStoreMock("Mock-store", smartphone);
	serviceCenter.pushOfficialStore(mockStore);
    }

    @Test
    public void testRegisterAndCompleteRepair() {
	assertTrue(serviceCenter.registerRepair(smartphone));
	assertEquals(1, serviceCenter.getRepairedSmartphones().size());

	assertTrue(serviceCenter.completeRepair(smartphone));
	assertEquals(0, serviceCenter.getRepairedSmartphones().size());
    }

}

class PhoneStoreMock extends PhoneStore {
    public PhoneStoreMock(String storeName, Smartphone selled) {
	super(storeName);
	selledSmartphones.add(selled);
    }
}
