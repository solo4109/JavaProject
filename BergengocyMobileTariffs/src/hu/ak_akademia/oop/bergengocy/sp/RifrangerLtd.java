package hu.ak_akademia.oop.bergengocy.sp;

import hu.ak_akademia.oop.bergengocy.Duration;
import hu.ak_akademia.oop.bergengocy.ServiceProvider;

class RifrangerLtd extends AbstractServiceProvider {
	private static final double EXTRA = 0.08;

	{
		companyName = "Rifranger Kft.";
		areaCode = "99";
		tariffType = "a versenytársakétól függő";
		tariffDetails = String.format("a mindenkori legalacsonyabb hívásdíj %.1f%%-a", (1 + EXTRA) * 100d);
	}

	private ServiceProvider[] competitors = null;

	private ServiceProvider[] getCompetitors() {
		if (competitors == null) { 
			competitors = new ServiceProvider[ServiceProviderFactory.getProviders().length - 1];
			int i = 0;
			for (ServiceProvider sp : ServiceProviderFactory.getProviders())
				if (!(sp instanceof RifrangerLtd)) {
					competitors[i++] = sp;
				}
		}
		return competitors;
	}

	@Override
	public int calculateCallFee(Duration duration) {
		int minFee = Integer.MAX_VALUE;
		for (ServiceProvider sp : getCompetitors()) {
			minFee = Math.min(minFee, sp.calculateCallFee(duration));
		}
		return (int) Math.round(minFee * (1 + EXTRA));
	}

}
