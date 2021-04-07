package hu.ak_akademia.oop.bergengocy.sp;

import hu.ak_akademia.oop.bergengocy.ServiceProvider;

abstract class AbstractServiceProvider implements ServiceProvider {

	String companyName;
	String areaCode;
	String tariffType;
	String tariffDetails;

	@Override
	public String getCompanyName() {
		return companyName;
	}

	@Override
	public String getAreaCode() {
		return areaCode;
	}

	@Override
	public String getTariffDescription() {
		return String.format("a díjszámítás %s, %s", tariffType, tariffDetails);
	}

}
