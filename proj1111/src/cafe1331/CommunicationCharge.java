package cafe1331;

import java.util.Scanner;
import java.util.Vector;

public class CommunicationCharge {
   public static void main(String[] args) {
      Business business =new Business();
      business.run();
   }
}

class Business {
   Scanner sc = new Scanner(System.in);
   Vector<Grade> v = new Vector<>();

   public void run() {
      while (true) {
         System.out.print("1. 입력 2. 출력 3. 종료 : ");
         int select = sc.nextInt();

         switch (select) {
         case 1:
            inputData();
            break;
         case 2:
            showInfo();
            break;
         case 3:
            System.exit(0);
         }
      }
   }

   public void inputData() {
      while (true) {
         System.out.println("고객정보 입력");
         System.out.print("고객명 : ");
         String name = sc.next();
         System.out.print("등급코드 : ");
         String code = sc.next();
         System.out.print("사용시간 : ");
         int time = sc.nextInt();

         Grade temp = null;

         switch (code) {
         case "A":
            temp = new AGrade(name, time);
            break;
         case "B":
            temp = new BGrade(name, time);
            break;
         case "C":
            temp = new CGrade(name, time);
            break;
         case "D":
            temp = new DGrade(name, time);
            break;
         default:
            System.out.println("Iuput Error");
         }

         if (temp != null) {
            v.add(temp);
         }

         System.out.print("1. 계속 입력 2. 입력 종료 : ");
         int off = sc.nextInt();
         if(off==2)
            break;
      }
   }

   public void showInfo() {
      System.out.println("고객명\t등급코드\t시간당단가\t기본요금\t사용시간\t할인요금\t이번달 통신요금");
      for (int i = 0; i < v.size(); i++) {
         Grade temp = v.get(i);
         System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%d\n", temp.getName(), temp.getCode(), temp.getPerCost(),
               temp.getBaseRate(), temp.getTime(), temp.getDiscount(), temp.getCharge());
      }
   }
}

abstract class Grade {
   private String name;
   private String code;
   private int perCost;
   private int baseRate;
   private int time;
   private double discountRate = 0.1;

   public Grade(String name, int time) {
      super();
      this.name = name;
      this.time = time;
   }

   public String getName() {
      return name;
   }

   public String getCode() {
      return code;
   }

   public int getPerCost() {
      return perCost;
   }

   public int getBaseRate() {
      return baseRate;
   }

   public int getTime() {
      return time;
   }

   public double getDiscountRate() {
      return discountRate;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public void setPerCost(int perCost) {
      this.perCost = perCost;
   }

   public void setBaseRate(int baseRate) {
      this.baseRate = baseRate;
   }

   public void setDiscountRate(double discountRate) {
      this.discountRate = discountRate;
   }

   public int getDiscount() {
      return (int) (this.baseRate * this.discountRate);
   }

   public int getCharge() {
      return perCost * time + baseRate - getDiscount();
   }
}

class AGrade extends Grade {

   public AGrade(String name, int time) {
      super(name, time);
      super.setCode("A");
      super.setBaseRate(10000);
      super.setPerCost(86);
   }
}

class BGrade extends Grade {

   public BGrade(String name, int time) {
      super(name, time);
      super.setCode("B");
      super.setBaseRate(12000);
      super.setPerCost(81);
   }
}

class CGrade extends Grade {

   public CGrade(String name, int time) {
      super(name, time);
      super.setCode("C");
      super.setBaseRate(15000);
      super.setPerCost(104);
   }
}

class DGrade extends Grade {

   public DGrade(String name, int time) {
      super(name, time);
      super.setCode("D");
      super.setBaseRate(20000);
      super.setPerCost(52);
   }
}