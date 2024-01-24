import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
	
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Person[] person = new Person[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			person[i] = new Person(age, name, i);
		}
		
		Arrays.sort(person);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(person[i].age + " " + person[i].name + "\n");
		}
		System.out.println(sb.toString());
	}

	static class Person implements Comparable<Person> {
		int age;
		String name;
		int order;
		
		public Person (int age, String name, int order) {
			this.age = age;
			this.name = name;
		}
		
		@Override
		public int compareTo(Person p) {
			if (this.age == p.age) {
				return this.order - p.order;
			}
			return this.age - p.age;
		}
	}
}
