package hu.ak_akademia.oop.bergengocy.sp;

import hu.ak_akademia.oop.bergengocy.ServiceProvider;

/**
 * <b>Exercise: Bergengocian Mobile Tariffs (Bergengóc mobiltelefon tarifák)</b>
 * <p>
 * Class for a factory method through which the (array of) service providers can be accessed from outside. This is the
 * only public method in the package.
 *
 * @author A&amp;K Akad&eacute;mia (Lajos Czuczor)
 */
public class ServiceProviderFactory {

	private static final ServiceProvider[] providers = { new VerboseCo(), new LukracioLtd(), new DecensLtd(), new RifrangerLtd() };

	/**
	 * @return all available service providers
	 */
	public static ServiceProvider[] getProviders() {
		return providers;
	}

}
