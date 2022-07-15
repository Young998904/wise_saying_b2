package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    @Test
    public void 프로그램_시작시_타이틀_출력_그리고_종료() { // 키보드 종료에서 문자열 종료
        Scanner sc = TestUtil.getScanner("종료");
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        // 프로그램 시작
        new App(sc).run();
        // 명령) 이 나오면 자동으로 종료를 입력하고 switch문을 돎
        // 프로그램 종료
        String rs = output.toString(); // 꺼지기 전에 문자열로 바꾸어 저장
        TestUtil.clearSetOutToByteArray(output);

        System.out.println(rs);

        assertTrue(rs.contains("== 명언 SSG =="));
        assertTrue(rs.contains("명령)"));

        assertTrue(true);
    }
    @Test
    public void 테스트() {
        assertTrue(1 == 1);
        assertEquals(1, 1);
    }
    @Test
    public void 스캐너에_키보드가_아닌_문자열을_입력으로_설정() {
        Scanner sc = TestUtil.getScanner("안녕");

        String cmd = sc.nextLine().trim();

        assertEquals("안녕", cmd);
    }
    @Test
    public void 출력을_모니터에_하지_않고_문자열로_얻기() {
        // 해당 상태에서는 출력이 모니터로 나오지 않음
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        System.out.print("안녕");
        String rs = output.toString(); // 꺼지기 전에 문자열로 바꾸어 저장
        TestUtil.clearSetOutToByteArray(output);

        assertEquals("안녕", rs);
    }

}
