import java.util.Scanner;

public class Ex226 {
    static void FirstDegreeEqn(){
        Scanner heso= new Scanner(System.in);
        double a= heso.nextDouble();
        double b= heso.nextDouble();

        if(a!=0){
            System.out.printf("x= %.2f", -b/a);
        }
        else if(b==0){
            System.out.println("Vo han ket qua");
        }
        else{
            System.out.println("Khong co ket qua");
        }
        heso.close();
    }

    static void LinearSystem(){
        Scanner heso= new Scanner(System.in);
        double a11= heso.nextDouble();
        double a12= heso.nextDouble();
        double b1= heso.nextDouble();
        double a21= heso.nextDouble();
        double a22= heso.nextDouble();
        double b2= heso.nextDouble();

        double detA= a11*a22- a12*a21;
        double detA1B= b1*a22 - a12*b2;
        double detA2B= a11*b2- a21*b1;
        
        if(detA!=0){
            System.out.printf("x1= %.2f", detA1B/detA);
            System.out.printf(" x2= %.2f", detA2B/detA);
        }
        else if(detA1B!=0 && detA2B!=0){
            System.out.println("Khong co ket qua");
        }
        else{
            System.out.println("Vo han ket qua");
        }
        heso.close();
    }

    static void SecondDegreeEqn(){
        Scanner heso= new Scanner(System.in);
        double a= heso.nextDouble();
        double b= heso.nextDouble();
        double c= heso.nextDouble();
        
        double delta= b*b- 4*a*c;
        if(a!=0){
            if(delta>0){
                System.out.printf("x1= %.2f x2=%.2f", (-b+Math.sqrt(delta))/(2*a), (-b-Math.sqrt(delta))/(2*a));
            }
            else if(delta==0){
                System.out.printf("x= %.2f", -b/(2*a));
            }
            else{
                System.out.println("Khong co ket qua");
            }
        }
        else{
            if(b!=0){
                System.out.printf("x= %.2f", -c/b);
            }
            else if(c==0){
                System.out.println("Vo han ket qua");
            }
            else{
                System.out.println("Khong co ket qua");
            }
        }
        heso.close();
    }

    public static void main(String[] args){
        System.out.println("Choose option: \n1. FirstDegreeEqn \n2. Linear system \n3. SecondDegreeEqn");
        Scanner option= new Scanner(System.in);
        int opt= option.nextInt();
        System.out.println(opt);
        if(opt==1){
            System.out.println("Enter values a= b=");
            FirstDegreeEqn();
        }
        else if(opt==2){
            System.out.println("Enter values a11= a12= b1= \na21= a22= b2=");
            LinearSystem();
        }
        else{
            System.out.println("Enter values a= b= c=");
            SecondDegreeEqn();
        }
        option.close();
    } 
}