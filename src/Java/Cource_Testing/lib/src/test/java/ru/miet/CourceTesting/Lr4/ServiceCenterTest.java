package ru.miet.CourceTesting.Lr4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Модульный тест сервисного центра
 */
class ServiceCenterTest {
    private ServiceCenter serviceCenter;

    @BeforeEach
    public void setUp() {
	serviceCenter = new ServiceCenter("Сервисный Центр");
    }

    @Test
    public void testRegisterAndCompleteRepair() {
	var smartphone = new IOSSmartphone("Apple", "iPhone 13", 6.1, 0.7, "15", true);
	serviceCenter.registerRepair(smartphone);
	assertEquals(1, serviceCenter.getRepairedSmartphones().size());
	serviceCenter.completeRepair(smartphone);
	assertEquals(0, serviceCenter.getRepairedSmartphones().size());
    }
}
