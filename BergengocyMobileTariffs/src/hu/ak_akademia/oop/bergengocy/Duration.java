package hu.ak_akademia.oop.bergengocy;

/**
 * <b>Exercise: Bergengocian Mobile Tariffs (Bergengóc mobiltelefon tarifák)</b>
 * <p>
 * Class for representing call duration. Extended with methods used by some
 * service providers.
 *
 * @author A&amp;K Akad&eacute;mia (Lajos Czuczor)
 */
public class Duration {

	private int minute;
	private int second;

	public Duration(int minute, int second) {
		this.minute = minute;
		this.second = second;
		if (minute < 0 || second < 0 || second >= 60) {
			throw new IllegalArgumentException("Az időtartam hibás");
		}
	}

	public int getMinute() {
		return minute;
	}

	public int getSecond() {
		return second;
	}

	public int getTotalSeconds() {
		return minute * 60 + second;
	}

	public int getStartedMinutes() {
		return minute + (second == 0 ? 0 : 1);
	}

}
