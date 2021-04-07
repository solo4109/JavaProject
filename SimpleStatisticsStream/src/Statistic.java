import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Statistic {
	private final List<Integer> data;
//	private final Integer min;
//	private final Integer max;
//	private final double average;
//	private final double median;
//	private final List<Integer> mode;

	public Statistic(List<Integer> data) {
		this.data = data;
		Collections.sort(data);
//		min = calculateMin();
//		max = calculateMax();
//		average = calculateAverage();
//		median = calculateMedian();
//		mode = calculateMode();
	}

	public List<Integer> calculateMode() {
		Map<Integer, Long> frequencies = data.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));

		long maxCount = frequencies.values().stream().mapToLong(Long::longValue).max().orElse(0);

		List<Integer> mode = frequencies.entrySet().stream().filter(e -> e.getValue() == maxCount)
				.map(Map.Entry::getKey).collect(Collectors.toList());

		return mode;
	}

	public double calculateMedian() {
		return data.stream().mapToDouble(d -> d).skip((data.size() - 1) / 2).limit(2 - data.size() % 2).average()
				.getAsDouble();
	}

	public double calculateAverage() {
		return data.stream().mapToInt(i -> i).average().getAsDouble();
	}

	public Integer calculateMin() {
		// return new TreeSet<>(Set.of(data.get(0), data.get(data.size() - 1)));
		// return data.stream().min((a, b) -> a.compareTo(b)).get();
		return data.stream().min(Integer::compare).get();
	}

	public Integer calculateMax() {
		return data.stream().max(Integer::compare).get();
		// return data.stream().max((a, b) -> a.compareTo(b)).get();
	}
}
