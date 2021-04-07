package hu.ak_akademia.oop.bergengocy.sp;

import hu.ak_akademia.oop.bergengocy.Duration;

class LukracioLtd extends AbstractServiceProvider {

	private static final int MINUTE_FEE = 50;
	
	{
		companyName = "LukRáció Kft.";
		areaCode = "7";
		tariffType = "perc alapú";
		tariffDetails = String.format("megkezdett percenként %d peták", MINUTE_FEE);
	}

	@Override
	public int calculateCallFee(Duration duration) {
		return (duration.getMinute() + (duration.getSecond() == 0 ? 0 : 1)) * MINUTE_FEE;
	}

}
