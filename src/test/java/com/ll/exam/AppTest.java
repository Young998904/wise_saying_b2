package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    // 등록기능 구현 시작
    @Test
    public void 등록을_하면_명언과_작가를_물어본다() {
        String rs = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라
                이순신
                종료
                """);
//        // 매번 쓰기에 번잡 -> AppTestRunner 제작
//        Scanner sc = TestUtil.getScanner("""
//                등록
//                나의 죽음을 적들에게 알리지 말라
//                이순신
//                종료
//                """);
//        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
//        // 프로그램 시작
//        new App(sc).run();
//        // 명 {) 이 나오면 자동으로 종료를 입력하고 switch문을 돎
//        // 프로그램 종료
//        String rs = output.toString(); // 꺼지기 전에 문자열로 바꾸어 저장
//        TestUtil.clearSetOutToByteArray(output);

        assertTrue(rs.contains("명언 : "));
        assertTrue(rs.contains("작가 : "));
    }

    // 등록 발전
    @Test
    public void 등록을_하면_생성된_명언의_번호가_출력되어야_한다() {
        String rs = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라.
                이순신
                등록
                나에게 불가능이란 없다.
                나폴레옹
                종료
                """);

        assertTrue(rs.contains("1번 명언이 등록되었습니다."));
        assertTrue(rs.contains("2번 명언이 등록되었습니다."));
    }
    // 등록 기능 구현 종료

    // 목록 기능 구현 시작
    @Test
    public void 등록_후_목록에서_확인할_수_있어야_한다() {
        String rs = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라.
                이순신
                등록
                나에게 불가능이란 없다.
                나폴레옹
                목록
                종료
                """);

        assertTrue(rs.contains("번호 / 작가 / 명언"));
        assertTrue(rs.contains("----------------------"));
        assertTrue(rs.contains("2 / 나폴레옹 / 나에게 불가능이란 없다."));
        assertTrue(rs.contains("1 / 이순신 / 나의 죽음을 적들에게 알리지 말라."));
    }

    @Test
    public void 프로그램_시작시_타이틀_출력_그리고_종료() {
        String rs = AppTestRunner.run("""
                종료
                """);
//        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
//        // 프로그램 시작
//        new App(sc).run();
//        // 명 {) 이 나오면 자동으로 종료를 입력하고 switch문을 돎
//        // 프로그램 종료
//        String rs = output.toString(); // 꺼지기 전에 문자열로 바꾸어 저장
//        TestUtil.clearSetOutToByteArray(output);

        assertTrue(rs.contains("== 명언 SSG =="));
        assertTrue(rs.contains("명령)"));
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
