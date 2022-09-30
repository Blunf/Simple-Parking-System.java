package WriteyourPackage;

import java.util.Scanner;

public class WriteyourClass {
    public static Scanner scanner = new Scanner(System.in);

    static final int ROW = 4;
    static final int COL = 3;

    public static void main(String[] args){
        System.out.println("Parking System");
        String[][] park = new String[ROW][COL];
        String[][] carnum = new String[ROW][COL];
        park[0][0]="@";
        park[0][1]="@";
        park[0][2]="@";
        park[1][0]="@";
        park[1][1]="@";
        park[1][2]="@";
        park[2][0]="@";
        park[2][1]="@";
        park[2][2]="@";
        park[3][0]="@";
        park[3][1]="@";
        park[3][2]="@";

        while(true){
        System.out.println("**** parking status ****");
        System.out.println("  1 2 3");
        System.out.println("1 "+park[0][0] +" "+park[0][1] +" "+park[0][2]);
        System.out.println("2 "+park[1][0] +" "+park[1][1] +" "+park[1][2]);
        System.out.println("3 "+park[2][0] +" "+park[2][1] +" "+park[2][2]);
        System.out.println("4 "+park[3][0] +" "+park[3][1] +" "+park[3][2]);

        System.out.print("(1)Park my car (2)Search (3)getting out of my car (4)exit\nchoose the menu: ");
        int num = scanner.nextInt();

        Label2:switch(num) {
            case 1:
            System.out.println("\n**** Parking ****");
            System.out.println("Loacte you want(ex:1 2): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if(0<x && x<5 && 0<y && y<4){
                if(park[x-1][y-1]=="℗" ){
                    System.out.println("Another vehicle is parked. Please start all over again.");
                    break;
                }
                System.out.println("Please enter the vehicle number (e.g. 20yj1234): ");
                String number = scanner.next();
                carnum[x-1][y-1]=number;
                System.out.println("vehicle number "+carnum[x-1][y-1]+".right? (y/n)");
                char ans = scanner.next().charAt(0);
                if(ans=='y'){
                    System.out.println(carnum[x-1][y-1]+"Finished parking.");
                    park[x-1][y-1]="℗";
                    break;
                }
                else if(ans =='n'){
                    System.out.println("Please start all over again.");
                    break;
                }
                else{
                    System.out.println("lease select only one between y and n.");
                    break Label2;
                }
            }
            else {
                System.out.println("Please check the location number. Please start all over again.");
                break;
            }
            
            case 2:
            System.out.println("**** Search ****");
            System.out.print("Please enter your vehicle number: ");
            String searchnumber = scanner.next();
            for(int i =0; i<4 ; i++){
                for(int k=0; k<3; k++){
                    if(carnum[i][k]!=null&&carnum[i][k].equals(searchnumber)){
                        System.out.println(searchnumber+"is located at ("+i+" "+k+").");
                        break Label2;
                    }
                    
                    else{
                        continue;
                    }
                }
            }
            System.out.println("Vehicle does not exist. Please check and proceed from the beginning again.");
            break;

            case 3:
            System.out.println("*** Getting out ****");
            System.out.println("Please enter your vehicle number: ");
            String outnumber = scanner.next();
            for(int i =0; i<4 ; i++){
                for(int k=0; k<3; k++){
                    if(carnum[i][k]!=null&&carnum[i][k].equals(outnumber)){
                        System.out.println(outnumber+" vehicle has been pulled out. Have a nice Day.");
                        park[i][k]="@";
                        break Label2;
                    }
                    else continue;
                }
                
            }
            System.out.println("Vehicle does not exist. Please check and proceed from the beginning again.");
            break;

            case 4:
            System.out.println("Shutting down the system.");
            return;
                

            default:
            System.out.println("Please check the menu number and enter it again.");
        }
        }

    }
}
