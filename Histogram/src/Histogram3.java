import java.util.Arrays;

public class Histogram3 {
	private static final double INTERVAL = 15d;

	public static void main(String[] args) {
		double[] parameters = new double[] { 280.43, 228.52, 266.31, 269.13, 320.65, 231.99, 215.12, 289.53, 296.91,
				298.13, 305.97, 304.64, 295.67, 258.91, 312.93, 255.31, 293.43, 295.39, 303.73, 251.0, 290.94, 231.17,
				314.3, 278.61, 291.5, 303.76, 329.26, 258.88, 241.08, 257.56, 261.6, 247.8, 270.49, 319.36, 242.99,
				228.95, 328.53, 289.8, 291.13, 300.03, 365.2, 228.9, 289.55, 235.36, 241.56, 270.17, 244.59, 319.05,
				259.89, 236.47, 347.28, 250.71, 252.66, 235.24, 270.57, 252.43, 274.84, 269.4, 273.67, 290.65, 240.61,
				245.15, 272.73, 295.3, 248.53, 322.77, 254.34, 277.49, 269.99, 266.43, 259.52, 268.1, 209.35, 280.6,
				322.19, 280.05, 208.75, 243.74, 329.09, 315.28, 251.07, 269.18, 315.67, 295.13, 277.86, 246.33, 284.0,
				308.35, 243.76, 342.4, 345.71, 293.46, 323.51, 275.67, 319.9, 291.69, 240.71, 257.3, 281.77, 297.49,
				265.07, 253.76, 233.91, 251.93, 380.87, 279.94, 346.55, 257.91, 289.67, 267.5, 254.69, 250.33, 285.75,
				229.86, 257.02, 250.01, 220.24, 338.41, 267.46, 251.2, 252.6, 222.86, 245.74, 255.31, 202.07, 248.25,
				257.98, 216.05, 250.78, 249.84, 260.76, 296.12, 224.66, 197.87, 236.09, 254.65, 309.47, 267.77, 258.07,
				249.62, 382.53, 271.86, 317.77, 282.68, 305.43, 285.3, 319.89, 237.32, 253.91, 219.1, 273.31, 231.88,
				280.31, 288.91, 224.57, 235.18, 297.9, 271.89, 259.92, 298.24, 234.28, 232.87, 305.54, 284.76, 240.91,
				257.05, 233.18, 233.44, 248.42, 252.75, 276.94, 277.9, 236.58, 268.73, 280.52, 241.56, 298.2, 282.63,
				241.41, 233.59, 297.37, 322.71, 246.74, 285.12, 237.8, 297.03, 410.4, 283.62, 329.37, 251.99, 325.49,
				266.42, 261.97, 272.28, 273.51, 275.32, 312.18, 231.77, 276.39, 285.99, 275.9, 281.02, 241.38, 258.36,
				232.5, 287.04, 269.4, 343.27, 269.21, 269.98, 243.0, 287.27, 229.23, 242.44, 305.83, 329.63, 467.93,
				483.16, 497.46, 462.21, 471.97, 535.15, 520.81, 465.17, 517.7, 486.14, 463.82, 475.45, 466.57, 413.38,
				463.6, 503.98, 438.08, 493.6, 447.34, 470.26, 489.0, 446.4, 446.54, 469.96, 473.17, 470.16, 481.48,
				462.49, 457.59, 464.91, 452.86, 429.83, 458.64, 463.26, 474.21, 473.8, 474.94, 450.29, 458.99, 443.53,
				471.9, 487.3, 472.19, 512.58, 488.41, 510.99, 459.71, 503.04, 467.58, 460.15, 487.24, 485.88, 475.15,
				450.39, 500.14, 517.71, 478.81, 468.62, 477.59, 449.56, 433.29, 421.57, 474.76, 490.52, 497.46, 495.49,
				478.77, 512.32, 517.47, 442.12, 452.57, 447.83, 465.48, 470.03, 489.95, 453.23, 429.31, 442.62, 462.76,
				459.68, 457.7, 471.03, 485.9, 457.45, 465.84, 449.67, 514.01, 494.4, 498.42, 480.39, 477.07, 453.99,
				454.27, 530.71, 449.36, 421.67, 563.95, 460.24, 481.58, 517.56, 476.97, 487.3, 506.51, 423.3, 416.42,
				462.88, 506.99, 456.68, 490.58, 536.55, 454.51, 411.78, 455.03, 460.86, 461.16, 453.02, 424.02, 462.63,
				426.89, 535.43, 454.57, 486.03, 469.67, 471.12, 444.98 };
		Arrays.sort(parameters);

		int minRangeNumber = (int) Math.floor(parameters[0] / INTERVAL); // 13
		int maxRangeNumber = (int) Math.floor(parameters[parameters.length - 1] / INTERVAL); // 37

		int[] floorParameters = new int[maxRangeNumber - minRangeNumber + 1];

		for (int i = 0; i < parameters.length - 1; i++) {
			floorParameters[(int) Math.floor(parameters[ i] / INTERVAL) - minRangeNumber]++;
		}
		assert Arrays.stream(floorParameters).sum() == parameters.length; // check point

		int maxFreq = 0;
		int modusRange = 0;

		for (int rangeInt = minRangeNumber; rangeInt <= maxRangeNumber; rangeInt++) {
			if (floorParameters[rangeInt - minRangeNumber] > maxFreq) {
				maxFreq = floorParameters[rangeInt - minRangeNumber];
				modusRange = rangeInt;
			}
		}
		System.out.printf("%n A sokaság eloszlása:%n");
		System.out.printf("%9s %10s %8s%n", "tartomány", "gyakoriság", "rel.gyak");
		for (int rangeInt = minRangeNumber; rangeInt <= maxRangeNumber; rangeInt++) {
			System.out.printf("%3.0f - %3.0f %10d %7.1f%%%n", rangeInt * INTERVAL, (rangeInt + 1) * INTERVAL,
					floorParameters[rangeInt - minRangeNumber],
					100d * floorParameters[rangeInt - minRangeNumber] / parameters.length);
		}
		
		System.out.printf("%nA legtöbb adatot tartalmazó %.0f cm-es tartomány tehát: %.0f-%.0f cm (%d adat).%n", INTERVAL, modusRange * INTERVAL,
                (modusRange + 1) * INTERVAL, maxFreq);
		System.out.printf("%nA sokaság átlaga %.2f cm, a mediánja %.2f cm.%n", average(parameters), median(parameters));
		 
		
		 System.out.printf("%nA hisztogram:%n");
	        for (int rangeInt = minRangeNumber; rangeInt <= maxRangeNumber; rangeInt++) {
	            System.out.printf("%3.0f - %3.0f  %s%n", rangeInt * INTERVAL, (rangeInt + 1) * INTERVAL, "▒".repeat(floorParameters[rangeInt - minRangeNumber]));
	        }        
	
	}
	private static double average(double[] array) {
		double sum = 0d;
		for (double element : array) {
			sum += element;
		}
		return sum / array.length;
	}
	
	 private static double median(double[] sortedArray) {
	        if (sortedArray.length % 2 == 0) {
	            return (sortedArray[sortedArray.length / 2 - 1] + sortedArray[sortedArray.length / 2]) / 2;
	        } else {
	            return sortedArray[(sortedArray.length - 1) / 2];
	        }
	    }

}
