package hu.ak_akademia.oop.bergengocy;

/**
 * <b>Exercise: Bergengocian Mobile Tariffs (Bergengóc mobiltelefon tarifák)</b>
 * <p>
 * Interface for mobile service providers: the abstraction that both main program and the service providers depend on -
 * as it is suggested by the Dependency Inversion of SOLID principles.
 *
 * @author A&amp;K Akad&eacute;mia (Lajos Czuczor)
 */
public interface ServiceProvider {

	String getCompanyName();

	String getAreaCode();

	String getTariffDescription();

	int calculateCallFee(Duration duration);

}
