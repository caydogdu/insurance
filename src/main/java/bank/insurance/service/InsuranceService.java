package bank.insurance.service;

import java.math.BigDecimal;

/**
 *
 * @author caydogdu
 *
 */
public interface InsuranceService {

    /**
     * 
     * @param module
     * @param coverage
     * @return calculated price for selected module
     */
    BigDecimal calculate(String module, BigDecimal coverage);

}
