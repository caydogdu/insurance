package bank.insurance.module;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bank.insurance.model.Insurance;

/**
 *
 * @author caydogdu
 *
 */
public class JewelryInsurance implements Insurance {

    private static final Logger logger = LoggerFactory.getLogger(JewelryInsurance.class);

    static final double RISK = 0.05;

    final BigDecimal minCoverage = BigDecimal.valueOf(500);

    final BigDecimal maxCoverage = BigDecimal.valueOf(10000);

    @Override
    public BigDecimal calculatePrice(BigDecimal coverage) {
        if (!(coverage.compareTo(minCoverage) > 0 && coverage.compareTo(maxCoverage) < 0)) {
            if (logger.isDebugEnabled()) {
                logger.error("coverage : " + coverage.toString() + ", range : [" + minCoverage.toString() + "-"
                        + maxCoverage + "]");
                logger.error("The coverage for Jewelry is not in the range");
            }
            return null;
        }
        return coverage.multiply(BigDecimal.valueOf(RISK));
    }

}
