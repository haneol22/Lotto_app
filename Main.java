package lotto;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int MAX_ARRAY = 100;
    static int[][] arrayLotto = new int[MAX_ARRAY][6];
    static int idxCurrent = -1;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int menu = -1;
        while (menu != 0) {
            printMenu();
            menu = scn.nextInt();
            switch (menu) {
                case 0:
                    System.out.println("프로그램을 종료합니다");
                    break;
                case 1:
                    makeLotto1();
                    break;
                case 2:
                    makeLotto2();
                    break;
                case 3:
                    showLottoList();
                    break;
                default:
                    break;
            }
        }
    }

    private static void makeLotto2() {
        Random rnd = new Random();
        int[] lotto = new int[6];
        while(true){
            boolean isSame = false;
            //로또번호 생성
            for (int i = 0; i < 6; i++) {//로또번호 생성
                int myNumber = rnd.nextInt(45) + 1;
                lotto[i] = myNumber;
            }
            //생성된 번호에서 중복되는게 있는지 체크
            for (int i=0; i<6;i++){ //중복 체크
                for(int j=0;j<6;j++){
                    if(i !=j){
                        if(lotto[i]==lotto[j]){
                            isSame = true;
                        }
                    }
                }
            }
            //중복되는게 없으면 while문 나옴
            if(!isSame){//(isSame == false){
                break;
            }

        }

        saveLotto(lotto);
    }

    private static void showLottoList() {
        for (int i = 0; i <= idxCurrent; i++) {
            System.out.print((i+1) + "번째 로또번호 : ");
            for (int j = 0; j < 6; j++) {
                System.out.print(arrayLotto[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    private static void makeLotto1() {
        Random rnd = new Random();
        int[] lotto = new int[6];
        for (int i = 0; i < 6; i++) {
            int myNumber = rnd.nextInt(45) + 1;
            lotto[i] = myNumber;
        }
        saveLotto(lotto);
    }

    private static void saveLotto(int[] lotto) {
        idxCurrent++;
        if (idxCurrent == MAX_ARRAY) {
            System.out.println("저장 범위를 초가했습니다.");
            return;
        }
        for (int i=0; i<6; i++) {
            arrayLotto[idxCurrent][i] = lotto[i];
            System.out.println((i + 1) + ":" + lotto[i]);
        }
    }

    private static void printMenu() {
        System.out.println("+----------------------------+");
        System.out.println(" 1.로또 번호 생성 (중복 허용)");
        System.out.println(" 2.로또 번호 생성 (중복 불가)");
        System.out.println(" 3. 생성되 로또 번호 보기");
        System.out.println(" 0.종료");
        System.out.println("+——————————————+");
        System.out.print("   메뉴를 선택하세요: ");
    }
}
