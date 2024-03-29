import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("Users.txt"));
        int length = 0;
        while(sc.hasNextLine()) {
            sc.nextLine();
            length++;
        }
        Scanner ussc = new Scanner(new File("Users.txt"));
        User[] users = new User[length];

        for(int i = 0; i < length; i++){
            String[] array = ussc.nextLine().split(" ");
            User user = new User(array[0], array[1], Integer.parseInt(array[2]), Float.valueOf(array[3]), array[4].charAt(0));
            users[i] = user;
        }

        System.out.println("Before: \n");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "First Name", "Last Name:", "ID", "Grade Letter", "Grade %");

        for(int i = 0; i < length; i++){
            System.out.println(users[i].getUser());
        }

        getUserInput(users);






    }

    public static void getUserInput(User[] users){
        System.out.println("What do you want to sort by?");
        System.out.println("Options: 1. First Name 2. Last Name 3. User ID 4. Grade Percentage");

        Scanner userInput = new Scanner(System.in);

        System.out.print("Input Number to Choose: ");
        int inputOne = userInput.nextInt();
        System.out.println(inputOne);

        if(inputOne > 4 || inputOne < 1){
            getUserInput(users);
        }
        System.out.println("Choose What Order: 1. Ascending 2. Descending");

        System.out.print("Input Number to Choose: ");
        int inputTwo = userInput.nextInt();
        System.out.println(inputTwo);
        if(inputTwo > 2 || inputTwo < 1){
            getUserInput(users);
        }
        sort(inputOne, inputTwo, users);
    }

    public static void sort(int one, int two, User[] users){
        if(two == 1) {
            switch (one) {
                case 1:
                    Arrays.sort(users, new FirstNameComparator());
                    printArray(users);
                    break;
                case 2:
                    Arrays.sort(users, new LastNameComparator());
                    printArray(users);
                    break;
                case 3:
                    Arrays.sort(users, new IDComparator());
                    printArray(users);
                    break;
                case 4:
                    Arrays.sort(users, new PercentComparator());
                    printArray(users);
                    break;
            }
        }else{
            switch (one) {
                case 1:
                    Arrays.sort(users, new FirstNameComparator().reversed());
                    printArray(users);
                    break;
                case 2:
                    Arrays.sort(users, new LastNameComparator().reversed());
                    printArray(users);
                    break;
                case 3:
                    Arrays.sort(users, new IDComparator().reversed());
                    printArray(users);
                    break;
                case 4:
                    Arrays.sort(users, new PercentComparator().reversed());
                    printArray(users);
                    break;
            }
        }
    }

    public static void printArray(User[] users) {
        System.out.println("After: \n");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "First Name", "Last Name:", "ID", "Grade Letter", "Grade %");
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].getUser());
        }
    }


}