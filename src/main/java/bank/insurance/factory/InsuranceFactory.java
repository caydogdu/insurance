package bank.insurance.factory;

import java.util.HashMap;
import java.util.Map;

import bank.insurance.constant.Module;
import bank.insurance.model.Insurance;
import bank.insurance.module.BikeInsurance;
import bank.insurance.module.ElectronicsInsurance;
import bank.insurance.module.JewelryInsurance;
import bank.insurance.module.SportsEquipmentInsurance;

/**
 *
 * @author caydogdu
 *
 *         A factory class to create insurance module
 */
public class InsuranceFactory {

    private static Map<String, Insurance> factories = new HashMap<>();

    static {
        factories.put(Module.BIKE, new BikeInsurance());
        factories.put(Module.ELECTRONICS, new ElectronicsInsurance());
        factories.put(Module.JEWELRY, new JewelryInsurance());
        factories.put(Module.SPORTSEQUIPMENT, new SportsEquipmentInsurance());
    }

    public static Insurance getFactory(String factoryId) {
        return factories.get(factoryId);
    }

    private InsuranceFactory() {
    }

}
