import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double total = 0;
		double creditSum = 0;
		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String subject = st.nextToken();
			double credit = Double.parseDouble(st.nextToken());
			creditSum += credit;
			String score = st.nextToken();
			double subjectScore = 0;
			switch (score) {
			case "A+":
				subjectScore = 4.5;
				break;
			case "A0":
				subjectScore = 4.0;
				break;
			case "B+":
				subjectScore = 3.5;
				break;
			case "B0":
				subjectScore = 3.0;
				break;
			case "C+":
				subjectScore = 2.5;
				break;
			case "C0":
				subjectScore = 2.0;
				break;
			case "D+":
				subjectScore = 1.5;
				break;
			case "D0":
				subjectScore = 1.0;
				break;
			case "F":
				subjectScore = 0.0;
				break;
			case "P":
				creditSum -= credit;
				subjectScore = 0;
				break;
			}
			total += credit * subjectScore;
		}
		System.out.println(total / creditSum);
	}

}
