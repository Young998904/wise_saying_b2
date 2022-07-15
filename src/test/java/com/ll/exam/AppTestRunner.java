package com.ll.exam;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {
    public static String run(String input) {
        // 원래 매번 해주던 작업을 run 으로 옮김
        Scanner sc = TestUtil.getScanner(input);
        //평소에는 표준출력(System.out)이 모니터를 향하고 있다.
        // 그것을 특정 바이트스트림에 쌓이도록 한다.
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        // 프로그램 시작
        new App(sc).run();
        // 명 {) 이 나오면 자동으로 종료를 입력하고 switch문을 돎
        // 프로그램 종료
        String rs = output.toString(); // 꺼지기 전에 문자열로 바꾸어 저장
        TestUtil.clearSetOutToByteArray(output);

        return rs;
    }
}
