package bank.insurance.model;

import java.math.BigDecimal;

/**
 *
 * @author caydogdu
 *
 *         interface for insurance models
 */
public interface Insurance {

    /**
     * 
     * @param risk
     * @return calculated price for given coverage and risk
     */
    BigDecimal calculatePrice(BigDecimal coverage);

}
