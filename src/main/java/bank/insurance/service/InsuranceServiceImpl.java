package bank.insurance.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import bank.insurance.factory.InsuranceFactory;
import bank.insurance.model.Insurance;

/**
 *
 * @author caydogdu
 *
 */
@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Override
    public BigDecimal calculate(String module, BigDecimal coverage) {
        Insurance ins = InsuranceFactory.getFactory(module);
        return ins.calculatePrice(coverage);
    }

}
