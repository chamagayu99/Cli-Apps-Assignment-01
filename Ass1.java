import java.util.Scanner;

public class Ass1{
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final String clear = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_GREEN_BOLD = "\033[33;1m";
        final String RESET = "\033[0m";
        String title="💰 Welcome to Smart Banking App";
        String title1="➕ Open New Account";
        String[] names=new String[0];
        boolean flag0=false;
        boolean flag=false;
        boolean flag1=false;

        do{
            flag0=false;
            System.out.println(clear);
            System.out.println("-".repeat(32));
            System.out.printf("%s%s%s \n",COLOR_BLUE_BOLD,title,RESET);
            System.out.println("-".repeat(32));
            System.out.println("[1] Open New Account");
            System.out.println("[2] Exit");

        do{
            flag=false;
            
            System.out.print("Enter an option to continue:");
            int option=scanner.nextInt();
            scanner.nextLine();

            if(option<1 || option>2){
                System.out.printf("%sInvalid option%s \n",COLOR_RED_BOLD,RESET);
                flag=true;
            }

            switch(option){
                case 1:
                System.out.println(clear);
                System.out.println("-".repeat(32));
                System.out.printf("%s%s%s \n",COLOR_BLUE_BOLD,title1,RESET);
                System.out.println("-".repeat(32));
                System.out.printf("ID: SDB-%05d \n",names.length+1);
                
                do{
                    flag1=false;
                    System.out.print("Name: ");
                    String name=scanner.nextLine().strip();

                    if(name.isBlank()){
                        System.out.printf("%sName can't be empty%s \n",COLOR_RED_BOLD,RESET);
                        flag1=true;
                    }
                    for(int i=0;i<name.length();i++){
                        if(!Character.isLetter(name.charAt(i)) || Character.isSpaceChar(name.charAt(i))){
                            System.out.printf("%s%sInvalid Name%s ","\b".repeat(15),COLOR_RED_BOLD,RESET);
                            flag1=true;
                        }
                    }
                    System.out.println();

                    String[] newNames=new String[names.length+1];
                    for(int i=0;i<names.length;i++){
                        newNames[i]=names[i];
                    }
                    newNames[names.length]=name;
                    names=newNames;

                }while(flag1);

                System.out.println("Do you want to go back ? [y/n]");
                if (scanner.nextLine().strip().toUpperCase().equals("Y")){
                    flag0=true;
                    break;
                }

                case 2: System.exit(0);
            }

        }while(flag);
    }while(flag0);



    }
}