package book;

import java.util.*;

public class grade{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int score;
        
        //���� �Է¹ޱ�(������ ����� ����� �� ���� ���������� �ݺ�)
        while(true) {
        	System.out.print("������ �Է��ϼ���(0~100) : ");
            score = sc.nextInt();
            
            if(score<=100 && score>=0)
            	break;
            
            System.out.println("�߸��� �Է��Դϴ�.");
        }
        
        //A~F �Ǻ�
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
        
        //+,0 �Ǻ�
        if(hakjum != "F" && score%10 >= 5)
        	hakjum = hakjum + "+";
        else if(hakjum != "F" && score%10 < 5)
        	hakjum = hakjum + "0";
        
        //���
        System.out.println("����� ������ " + score + "���Դϴ�");
        System.out.println("����� ������ " + hakjum + "�����Դϴ�");
        sc.close();
    }
}