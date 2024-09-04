import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Country> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new Country(index, gold, silver, bronze));
        }
        Collections.sort(list);

        list.get(0).rank = 1;
        int answer = 0;
        for (int i = 1; i < N; i++) {
            int tmp_gold = list.get(i - 1).gold;
            int tmp_silver = list.get(i - 1).silver;
            int tmp_bronze = list.get(i - 1).bronze;
            Country now = list.get(i);
            if (list.get(i).index == K) {  // 국가의 번호가 K번이면 answer를 찾고 마지막 정답 출력 할 때 사용
                answer = i;
            }
            if (now.gold == tmp_gold && now.silver == tmp_silver && now.bronze == tmp_bronze) {
                list.get(i).rank = list.get(i - 1).rank;
            } else {
                list.get(i).rank = i + 1;
            }
        }

        System.out.println(list.get(answer).rank);
    }

    static class Country implements Comparable<Country> {
        int index;
        int gold;
        int silver;
        int bronze;
        int rank;

        public Country(int index, int gold, int silver, int bronze) {
            this.index = index;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.rank = 0;
        }

        @Override
        public int compareTo(Country c) {
            if (this.gold == c.gold) {
                if (this.silver == c.silver) {
                    return c.bronze - this.bronze;
                } else {
                    return c.silver - this.silver;
                }
            } else {
                return c.gold - this.gold;
            }
        }
    }
}