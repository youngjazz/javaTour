package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

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
			.collect(toList());

		System.out.println(list);
		System.out.println(list.stream().count());

		String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
		Stream<String[]> stream = Arrays.stream(data).filter(x -> "a".equals(x.toString()));
		System.out.println(stream.collect(toList()));

		List<String> items = Arrays.asList("Apple", "Apple", "orange",
			"Apple", "orange", "banana", "papaya");
		Map<String, Long> collect = items.stream().collect(groupingBy(Function.identity(), counting()));
		System.out.println(collect);
		System.out.println("-----------join-----------");
		System.out.println(items.stream().collect(joining()));

		List<String> sortedList = items.parallelStream()
				.sorted(Comparator.comparing(String::toString))
				.collect(toList());
		System.out.println(sortedList);

		String[] words = {"Hello", "World"};
		Arrays.asList(words).stream()
				.map(s->s.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(toList());

        System.out.println("-------斐波那锲---------");
        //Stream.iterate 可以产生一个无限流, 并每次对新的流应用函数
		Stream.iterate(new int[]{0,1}, t->new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

		//generate也是无限流, 但不会对新生成的流应用函数
		Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
	}
}
