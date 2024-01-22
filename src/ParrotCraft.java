//Author: Jay Patel, 000881881
import java.util.Scanner;

public class ParrotCraft {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Parrot p1 = new Parrot();
        Parrot p2 = new Parrot();
        Parrot p3 = new Parrot();
        System.out.println ("Enter name for Parrot 1");
        String parrot1 = input.next();
        System.out.println ("Enter name for Parrot 2");
        String parrot2 = input.next();
        System.out.println ("Enter name for Parrot 3");
        String parrot3  = input.next();

        p1.setName(parrot1);
        p2.setName(parrot2);
        p3.setName(parrot3);

        while (true){
            System.out.println(p1.toString());
            System.out.println(p2.toString());
            System.out.println(p3.toString());
            System.out.println("1.Feed 2.Command 3.Play 4.Hit 5.Quit");
            System.out.println("Please choose option from above");

            //to select input from options
            int choice = input.nextInt();

            if (choice==5)
                break;
            //will target particular parrot
            System.out.println("Which one?: ");
            int p = input.nextInt();

            Parrot choosenParrot = new Parrot();
            switch (p){
                case 1: choosenParrot = p1;
                    break;
                case 2: choosenParrot = p2;
                    break;
                case 3: choosenParrot = p3;
                    break;

                default:
                    System.out.println("Choose appropriate Parrot");
                    continue;
            }

            switch(choice){
                case 1:
                    //if you select feed
                    System.out.println("How much?");
                    double food = input.nextDouble();
                    System.out.println(choosenParrot.feed(food));
                    break;

                case 2:
                    //if you want to give command
                    System.out.println("Fly or Stay?");
                    String flying = input.next();
                    System.out.println(choosenParrot.command(flying));
                    break;

                case 3:
                    if (choosenParrot.alive=="dead"){
                        System.out.println("Dead parrot can not play.");
                    }
                    else {
                        System.out.println("Which parrot do you want to play with?: ");
                        //to choose other parrot to play with main parrot
                        int otherParrot = input.nextInt();
                        if (otherParrot == p) {
                            System.out.println("Please choose other parrot. it can not play with itself.");
                            continue;
                        } else if (otherParrot == 1) {
                            System.out.println(choosenParrot.play(p1));
                        } else if (otherParrot == 2) {
                            System.out.println(choosenParrot.play(p2));
                        } else if (otherParrot == 3) {
                            System.out.println(choosenParrot.play(p3));
                        }

                        break;
                    }
                case 4:
                    //if user select option 4 than it will hit that parrot and will damage its health
                    System.out.println(choosenParrot.hit());
                    break;
                default:
                    System.out.println("Choose appropriate option! ");
            }

        }
    }
}
