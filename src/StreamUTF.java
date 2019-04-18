import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUTF {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			count(reader.readLine());
		} catch (IOException e) {
			System.out.println("Wrong Input");
		}
	}

	public static void count(String array) {
		Stream.of(array.toLowerCase().split("[^\\p{L}\\p{Digit}_]+"))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.sorted(Map.Entry.<String, Long>comparingByKey())
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.limit(10)
				.forEachOrdered(o -> System.out.println(o.getKey()));
	}
}
