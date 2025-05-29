package ru.miet.CourceTesting.Lr3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SmartphoneTest {

    private Smartphone samsungAndroid;
    private Smartphone xiaomiAndroid;
    private Smartphone samsungCustomOS;
    private Smartphone appleIOS;

    @Before
    public void setUp() {
	samsungAndroid = new Smartphone("Samsung", "S24", 6.2, "Android", 7.9);
	xiaomiAndroid = new Smartphone("Xiaomi", "Note 13", 6.6, "Android", 8.1);
	samsungCustomOS = new Smartphone("Samsung", "Fold", 7.6, "One UI", 6.9);
	appleIOS = new Smartphone("Apple", "iPhone 16", 6.1, "iOS", 7.4);
    }

    // Тестирование конструктора и базовой функциональности
    @Test
    public void testConstructorAndGetters() {
	assertEquals("Samsung", samsungAndroid.getVendor());
	assertEquals("S24", samsungAndroid.getModelName());
	assertEquals(6.2, samsungAndroid.getDisplaySize(), 0.001);
	assertEquals(7.9, samsungAndroid.getThickness(), 0.001);
    }

    // Тестирование сеттеров с валидацией (анализ граничных значений)
    @Test
    public void setVendor_EmptyValue_ThrowsException() {
	assertThrows(IllegalArgumentException.class, () -> {
	    samsungAndroid.setVendor("");
	});
	assertThrows(IllegalArgumentException.class, () -> {
	    samsungAndroid.setVendor(null);
	});
    }

    // Тестирование сеттеров с валидацией (анализ граничных значений)
    @Test
    public void setModelName_EmptyValue_ThrowsException() {
	assertThrows(IllegalArgumentException.class, () -> {
	    samsungAndroid.setModelName(null);
	});
	assertThrows(IllegalArgumentException.class, () -> {
	    samsungAndroid.setModelName("");
	});
    }

    // Тестирование сеттеров с валидацией (анализ граничных значений)
    @Test
    public void setOS_EmptyValue_ThrowsException() {
	assertThrows(IllegalArgumentException.class, () -> {
	    samsungAndroid.setOs("");
	});
	assertThrows(IllegalArgumentException.class, () -> {
	    samsungAndroid.setOs(null);
	});
    }

    // Тестирование сеттеров с валидацией (анализ граничных значений)
    @Test
    public void setThinckness_EmptyValue_ThrowsException() {
	assertThrows(IllegalArgumentException.class, () -> {
	    samsungAndroid.setThickness(0);
	});
	assertThrows(IllegalArgumentException.class, () -> {
	    samsungAndroid.setThickness(-1);
	});
	assertThrows(IllegalArgumentException.class, () -> {
	    samsungAndroid.setThickness(Double.NaN);
	});
    }

    // Тестирование сеттеров с валидацией (анализ граничных значений)
    @Test
    public void setDisplaySize_ZeroValue_ThrowsException() {
	assertThrows(IllegalArgumentException.class, () -> {
	    samsungAndroid.setDisplaySize(0);
	});
	assertThrows(IllegalArgumentException.class, () -> {
	    samsungAndroid.setDisplaySize(-1);
	});
	assertThrows(IllegalArgumentException.class, () -> {
	    samsungAndroid.setDisplaySize(Double.NaN);
	});
    }

    @Test
    public void setOs_ValidValue_UpdatesCorrectly() {
	samsungAndroid.setOs("Android 14");
	assertEquals("Android 14", samsungAndroid.getOs());
    }

    // Тестирование связывания (техника причина/следствие)
    @Test
    public void linkTo_SameOS_Success() throws Exception {
	samsungAndroid.linkTo(xiaomiAndroid);
	assertTrue(devicesAreLinked(samsungAndroid, xiaomiAndroid));
    }

    @Test
    public void linkTo_SameVendor_Success() throws Exception {
	samsungAndroid.linkTo(samsungCustomOS);
	assertTrue(devicesAreLinked(samsungAndroid, samsungCustomOS));
    }

    @Test(expected = InvalidLinkingException.class)
    public void linkTo_DifferentVendorAndOS_ThrowsException() throws Exception {
	samsungAndroid.linkTo(appleIOS);
    }

    @Test(expected = InvalidLinkingException.class)
    public void linkTo_SelfLinking_ThrowsException() throws Exception {
	samsungAndroid.linkTo(samsungAndroid);
    }

    @Test(expected = InvalidLinkingException.class)
    public void linkTo_DuplicateLinking_ThrowsException() throws Exception {
	samsungAndroid.linkTo(xiaomiAndroid);
	samsungAndroid.linkTo(xiaomiAndroid);
    }

    // Тестирование исключительных ситуаций (предугадывание ошибок)
    @Test
    public void linkTo_NullDevice_ThrowsNPE() {
	assertThrows(NullPointerException.class, () -> {
	    samsungAndroid.linkTo(null);
	});
    }

    // Вспомогательные методы
    private boolean devicesAreLinked(Smartphone a, Smartphone b) {
	return a.getLinkedDevices().contains(b) && b.getLinkedDevices().contains(a);
    }

    // Тестирование возвращаемой копии списка
    @Test
    public void getLinkedDevices_ReturnsCopy() throws Exception {
	samsungAndroid.linkTo(xiaomiAndroid);
	List<Smartphone> links = samsungAndroid.getLinkedDevices();
	links.clear();
	assertFalse(samsungAndroid.getLinkedDevices().isEmpty());
    }
}
