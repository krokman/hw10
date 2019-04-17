import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUTF {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			Count(reader.readLine());
		} catch (IOException e) {
		}
	}

	public static void Count(String array) {
		Map<String, Long> finalMap = new LinkedHashMap<>();
		Stream.of(array.toLowerCase().split("[^\\p{L}\\p{Digit}_]+"))
				.sorted()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.sorted(Map.Entry.<String, Long>comparingByKey())
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.limit(10)
				.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

		finalMap.forEach((key, value) -> System.out.println(key));
	}
}
