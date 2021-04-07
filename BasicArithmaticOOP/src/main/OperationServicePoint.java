package main;

public interface OperationServicePoint {
	
	Operation[] getAvailableOperations();
	
	 default Operation get(String symbol) {
	        for (var op : getAvailableOperations()) {
	            if (op.getSymbol().equalsIgnoreCase(symbol)) {
	                return op;
	            }
	        }
	        throw new IllegalArgumentException("Nem létező művelet: \"" + symbol + "\"");
	    }
	 
	    
	    default Operation[] get(String... symbols) {
	        var result = new Operation[symbols.length];
	        int i = 0;
	        for (String symbol : symbols) {
	            result[i++] = get(symbol);
	        }
	        return result;
	    }

}
