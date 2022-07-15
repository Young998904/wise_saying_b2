package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;
    List<WiseSaying> wiseSayings;
    public App (Scanner sc) {
        this.sc = sc;
        wiseSayings = new ArrayList<>();
    }

    public void run() {
        System.out.println("== 명언 SSG ==");
        int wiseSayingLastId = 0;

        outer :
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "종료" :
                    break outer;
                case "등록" :
                    int id = ++wiseSayingLastId;
                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();

                    wiseSayings.add(new WiseSaying(id, content, author));

                    System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                    break;
                case "목록" :
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");
                    for (WiseSaying wiseSaying : wiseSayings) {
                        System.out.printf("%d / %s / %s\n",
                                wiseSaying.id, wiseSaying.author, wiseSaying.content);
                    }
            }
        }
    }
}
