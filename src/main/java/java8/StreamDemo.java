package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/5/9 13:28
 */
public class StreamDemo {
	public static void main(String[] args) {
		String str = "1,2,3,4,10,11,9,66,222,12";
		List<Integer> list = Stream.of(str.split(","))
			.map(Integer::valueOf)
			.filter(x->!Objects.equals(x,3))
			.sorted(Comparator.reverseOrder())
			.limit(4)
			.collect(Collectors.toList());

		System.out.println(list);
		System.out.println(list.stream().count());

		String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
		Stream<String[]> stream = Arrays.stream(data).filter(x -> "a".equals(x.toString()));
		System.out.println(stream.collect(Collectors.toList()));

		List<String> items = Arrays.asList("Apple", "Apple", "orange",
			"Apple", "orange", "banana", "papaya");
		Map<String, Long> collect = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect);
	}
}
