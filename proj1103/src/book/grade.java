package book;

import java.util.*;

public class grade{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int score;
        
        //숫자 입력받기(범위를 벗어나면 제대로 된 값을 받을때까지 반복)
        while(true) {
        	System.out.print("점수를 입력하세요(0~100) : ");
            score = sc.nextInt();
            
            if(score<=100 && score>=0)
            	break;
            
            System.out.println("잘못된 입력입니다.");
        }
        
        //A~F 판별
        String hakjum = null;
        if(score >= 90)
            hakjum = "A";
        else if(score >= 80)
        	hakjum = "B";
        else if(score >= 70)
        	hakjum = "C";
        else if(score >= 60)
        	hakjum = "D";
        else
        	hakjum = "F";
        
        //+,0 판별
        if(hakjum != "F" && score%10 >= 5)
        	hakjum = hakjum + "+";
        else if(hakjum != "F" && score%10 < 5)
        	hakjum = hakjum + "0";
        
        //출력
        System.out.println("당신의 점수는 " + score + "점입니다");
        System.out.println("당신의 학점은 " + hakjum + "학점입니다");
        sc.close();
    }
}