package hu.ak_akademia.oop.bergengocy.sp;

import hu.ak_akademia.oop.bergengocy.Duration;

class VerboseCo extends AbstractServiceProvider {

	private static final int CALL_FEE = 300; 
	
	{
		companyName = "Fecsegtető Telekom Zrt. (VerboseCo)";
		areaCode = "21";
		tariffType = "hívás alapú";
		tariffDetails = String.format("a hívás díja %d peták / hívás", CALL_FEE);
	}

	@Override
	public int calculateCallFee(Duration duration) {
		return CALL_FEE;
	}

}
