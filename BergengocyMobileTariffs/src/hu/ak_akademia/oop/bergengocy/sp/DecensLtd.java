package hu.ak_akademia.oop.bergengocy.sp;

import hu.ak_akademia.oop.bergengocy.Duration;

class DecensLtd extends AbstractServiceProvider {

	private static final double CALL_FEE = 1.5;
	private static final double FEE_BEFORE = 0.5;
	private static final int BREAKPOINT_TIME = 120;

	{
		companyName = "Decens Távközlési Zrt.";
		areaCode = "876";
		tariffType = "másodperc alapú";
		tariffDetails = String.format("%d másodpercig %.2f peták, majd %.2f peták", BREAKPOINT_TIME, CALL_FEE,
				FEE_BEFORE);

	}

	@Override
	public int calculateCallFee(Duration duration) {
		int totalSeconds = duration.getTotalSeconds();
		double fee = totalSeconds <= BREAKPOINT_TIME ? totalSeconds * CALL_FEE
				: BREAKPOINT_TIME * CALL_FEE + (totalSeconds - BREAKPOINT_TIME) * FEE_BEFORE;
		return (int) Math.round(fee);
	}
}
