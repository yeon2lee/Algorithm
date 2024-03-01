import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet enterMember = new HashSet(); //유저 닉네임둘 저장하는 (한 ENTER의)

        int N = Integer.parseInt(br.readLine()); //채팅방 기록 수
        int count = 0; // 곰곰 이모티콘을 사용한 횟수를 저장하는

        for (int i = 0; i < N; i++) {
            String chat = br.readLine(); //입력받은 문자열

            if (chat.equals("ENTER")) { //들어옴 (기존 유저 초기화)
                count += enterMember.size(); //기존에 저장된 유저의 닉네임 중복제거한 개수를 누적 더하기

                //누적 더하기 한 후에 초기화한다. (새로 세야하기 때문)
                enterMember = new HashSet();

            } else { //ENTER이 아닌 경우는 유저의 닉네임 저장
                enterMember.add(chat);
            }
        }

        //모두 입력 받았으면 마지막 ENTER의 곰곰임티 횟수(들어온 사람의 수)를 누적 더하기 해줘야함
        count += enterMember.size();

        bw.write(count + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}