package system;

public class PriceModule {
	
    private final double baseCost = 2.19;
    
    public double calculatePrice(String state, boolean hasRequestHistory, double gallonsRequested) {
    	double locationFactor;
    	double rateHistoryFactor;
    	double gallonsRequestedFactor;
    	final double companyProfitFactor = 0.05;
    	final double rateFluctuation = 0.04;
    	
    	
    	if (state.equalsIgnoreCase("TX")) {
    		locationFactor = 0.02;
    	}
    	else {
    		locationFactor = 0.04;
    	}
    	
    	if (hasRequestHistory) {
    		rateHistoryFactor = 0.02;
    	}
    	else {
    		rateHistoryFactor = 0.03;
    	}
    	
    	if (gallonsRequested > 1000) {
    		gallonsRequestedFactor = 0.02;
    	}
    	else {
    		gallonsRequestedFactor = 0.03;
    	}
    	
    	
    	return this.baseCost + (this.baseCost * (locationFactor + rateHistoryFactor + gallonsRequestedFactor + companyProfitFactor + rateFluctuation));
    }
}
