package hu.ak_akademia.oop.cf;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Statistic {
	private final List<Integer> data;
	private final SortedSet<Integer> range;
	private final double average;
	private final double median;
	private final  Set<Integer> mode; 

	public Statistic(List<Integer> data) {
		this.data = data;
		Collections.sort(data);
		range = calculateRange();
		average = calculateAverage();
		median = calculateMedian();
		mode = calculateMode();
	}

	private SortedSet<Integer> calculateRange() {
		return new TreeSet<>(Set.of(data.get(0), data.get(data.size() - 1)));
	}

	private Set<Integer> calculateMode() {
		Map<Integer, Integer> frequencies = new HashMap<>();
		for (int d : data) {
			Integer frequency = frequencies.putIfAbsent(d, 1);
			if (frequency != null) {
				frequencies.replace(d, frequency + 1);
			}
		}
		int maxFrequency = 0;
		for (int f : frequencies.values()) {
			maxFrequency = Math.max(maxFrequency, f);
		}
		SortedSet<Integer> mode = new TreeSet<>();
		for (Map.Entry<Integer, Integer> e : frequencies.entrySet()) {
			if (e.getValue() == maxFrequency) {
				mode.add(e.getKey());
			}
		}
		return mode;
	}


	private double calculateMedian() {
		return data.size() % 2 == 0 ? (data.get(data.size() / 2 - 1) + data.get(data.size() / 2)) / 2d
				: data.get((data.size() - 1) / 2);
	}

	private double calculateAverage() {
		int sum = 0;
		for (int d : data) {
			sum += d;
		}
		return (double) sum / data.size();
	}

	List<Integer> getData() {
		return data;
	}

	SortedSet<Integer> getRange() {
		return range;
	}

	double getAverage() {
		return average;
	}

	double getMedian() {
		return median;
	}

	Set<Integer> getMode() {
		return mode;
	}

}
