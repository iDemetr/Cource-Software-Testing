package ru.miet.CourceTesting.Lr4;

import java.util.ArrayList;
import java.util.List;

import ru.miet.CourceTesting.Lr3.Smartphone;

/**
 * 
 */
public class ServiceCenter {
    private String centerName;
    private List<Smartphone> repairedSmartphones;
    private List<PhoneStore> officialStores;

    public ServiceCenter(String centerName) {
	this.centerName = centerName;
	repairedSmartphones = new ArrayList<>();
	officialStores = new ArrayList<>();
    }

    public String getCenterName() {
	return centerName;
    }

    public void setCenterName(String centerName) {
	this.centerName = centerName;
    }

    public List<Smartphone> getRepairedSmartphones() {
	return repairedSmartphones;
    }

    public void pushOfficialStore(PhoneStore store) {
	if (store == null) {
	    throw new IllegalArgumentException("Магазин не может быть null");
	}

	officialStores.add(store);
    }

    /**
     * Метод для регистрации ремонта
     * 
     * @param smartphone
     */
    public boolean registerRepair(Smartphone smartphone) {
	if (officialStores.stream().anyMatch(x -> x.getSelledSmartphones().contains(smartphone))) {
	    repairedSmartphones.add(smartphone);
	    System.out
		    .println("Смартфон " + smartphone.getModelName() + " зарегистрирован для ремонта в " + centerName);
	    return true;
	}
	return false;
    }

    /**
     * Метод для завершения ремонта
     * 
     * @param smartphone
     */
    public boolean completeRepair(Smartphone smartphone) throws IllegalArgumentException {
	if (!repairedSmartphones.contains(smartphone)) {
	    throw new IllegalArgumentException("Устройство не принадлежит данному СЦ");
	}

	repairedSmartphones.remove(smartphone);
	System.out.println("Смартфон " + smartphone.getModelName() + " был успешно отремонтирован.");
	return true;
    }
}
