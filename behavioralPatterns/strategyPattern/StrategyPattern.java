package strategyPattern;

import java.util.List;
import java.util.stream.Collectors;

public class StrategyPattern {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		List<Integer> intList = List.of(100, 2, 300, 67, 56, 34, 12, 34, 33, 21, 66, 78, 79, 98, 56, 78, 65);
		// Strategy-1 for filter()
		List<Integer> intListFilterd1 = intList.stream().filter(x -> x > 20).collect(Collectors.toList());
		// Strategy-2 for filter()
		List<Integer> intListFilterd2 = intList.stream().filter(x -> x % 20 == 0).collect(Collectors.toList());
		// Strategy-3 for filter()
		List<Integer> intListFilterd3 = intList.stream().filter(x -> x < 50020).collect(Collectors.toList());
		// Strategy-4 for filter()
		List<Integer> intListFilterd4 = intList.stream().filter(x -> x == 20).collect(Collectors.toList());
	}
}