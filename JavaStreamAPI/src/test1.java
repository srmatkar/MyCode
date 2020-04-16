import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {

	@Test(enabled = false)
	public void regular() {
		int count = 0;

		List<String> li = new ArrayList<String>();
		li.add("Shailendra");
		li.add("Shalaka");
		li.add("Shama");
		li.add("Advait");
		li.add("Bharati");

		Iterator<String> itr = li.iterator();
		while (itr.hasNext()) {
			String a = itr.next();
			if (a.startsWith("S")) {

				count++;
			}

		}
		System.out.println("Number of Names starting with Alphabet S is: "
				+ count);

	}

	@Test(enabled = true)
	public void stream() {

		List<String> names = new ArrayList<String>();
		names.add("Shailendra");
		names.add("Shalaka");
		names.add("Shama");
		names.add("Advait");
		names.add("Bharati");
		names.add("Sai");

		Long count = names.stream().filter(s -> s.startsWith("S")).count();
		System.out.println("Number of Names starting with Alphabet S is: "
				+ count);
		names.stream().filter(s -> s.length() > 4)
				.forEach(s -> System.out.println(s));

		// Limiting the results at intermediate filter
		names.stream().filter(s -> s.length() > 4).limit(1)
				.forEach(s -> System.out.println(s));

		names.stream().filter(s -> s.length() > 4)
				.forEach(s -> System.out.println(s.toUpperCase()));

	}

	@Test(enabled = false)
	public void streamTypeCollections() {
		Optional<String> firstTwala = Stream
				.of("One", "Two", "Three", "Four", "Five", "Six")
				.filter(a -> a.startsWith("T")).findFirst();
		System.out.println(firstTwala);
	}

	@Test(description = "Manipulate stream" ,  enabled = true)
	public void mapAndStream() {
		// print the names ending with a and > 4 in upper case

		Stream.of("Ganesh", "Nikesh", "Varsha", "Shailendra", "Prisha", "Usha")
				.filter(s -> s.endsWith("a"))
				.filter(s -> s.length() >4)
				.map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
		// print the names ending with a and > 4 in upper case in sorted way
		// Concept of Arrays as list as well 
		
		List<String> names = Arrays.asList("Ganesh", "Nikesh", "Varsha", "Shailendra", "Prisha", "Usha");
		names.stream().filter(s -> s.endsWith("a"))
		.filter(s -> s.length()>4)
		.sorted()
		.forEach(s -> System.out.println(s.toUpperCase()));
		
		
	}
	
	@Test
	public void match(){
		List<String> number1 = Arrays.asList("One","Two","Three");
		List<String> number2 = Arrays.asList("Eleven","Twelve","Thirteen");
		
		Stream<String> newStream = Stream.concat(number1.stream()	, number2.stream());
		boolean isPresent = newStream.anyMatch(s-> s.equalsIgnoreCase("Four"));
		Assert.assertTrue(isPresent);
		
		
	}
	
	@Test
	public void streamToCpllection(){
		List<String> myList = Stream.of("Ganesh", "Nikesh", "Varsha", "Shailendra", "Prisha", "Usha")
		.filter(s -> s.endsWith("a")).map(s-> s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(myList.get(0));
	
		
		
	}
	
	@Test
	public void streamsUsage(){
		
		List<Integer> values = Arrays.asList(1,2,2,4,8,0,7,3,5,6,4,9);
	//	values.stream().distinct().forEach(s ->System.out.println(s));
		
		List<Integer> list = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(list.get(2));
		
	}
			

}
