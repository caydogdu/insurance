package bank.insurance;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import bank.insurance.constant.Module;
import bank.insurance.service.InsuranceService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class InsuranceServiceImplTest {

    @Autowired
    InsuranceService insuranceService;

    @Test
    public void calculateBikeTest() {

        String insurance = Module.BIKE;

        BigDecimal coverage = new BigDecimal(1000);
        assertEquals(300, insuranceService.calculate(insurance, coverage).longValue());

        // not in range
        BigDecimal coverage1 = new BigDecimal(10000);
        assertEquals(null, insuranceService.calculate(insurance, coverage1));

    }

    @Test
    public void calculateElectronicsTest() {

        String insurance = Module.ELECTRONICS;

        BigDecimal coverage = new BigDecimal(1000);
        assertEquals(350, insuranceService.calculate(insurance, coverage).longValue());

        // not in range
        BigDecimal coverage1 = new BigDecimal(0);
        assertEquals(null, insuranceService.calculate(insurance, coverage1));

    }

    @Test
    public void calculateJewelryTest() {

        String insurance = Module.JEWELRY;

        BigDecimal coverage = new BigDecimal(3000);
        assertEquals(150, insuranceService.calculate(insurance, coverage).longValue());

        // not in range
        BigDecimal coverage1 = new BigDecimal(3000);
        assertEquals(null, insuranceService.calculate(insurance, coverage1));

    }

    @Test
    public void calculateSportsEquipmentTest() {

        String insurance = Module.SPORTSEQUIPMENT;

        BigDecimal coverage = new BigDecimal(3000);
        assertEquals(900, insuranceService.calculate(insurance, coverage).longValue());

        // not in range
        BigDecimal coverage1 = new BigDecimal(25000);
        assertEquals(null, insuranceService.calculate(insurance, coverage1));

    }
}
