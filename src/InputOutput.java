import java.util.Scanner;

static void main() {
    int age = -1, height = -1;
    Scanner reader = new Scanner(System.in);
    IO.print("Enter your name: ");
    String name = reader.nextLine();
    IO.println("Hello " + name);
    boolean runLoop = true;

    while (runLoop) {
        try {
            IO.println(age);
            IO.print("Enter your age: ");
            age = reader.nextInt();
            IO.print("Enter your height(cm): ");
            height = reader.nextInt();
            IO.println("You are " + age + " years old.");
            IO.println("You are " + height + " cm tall.");
            runLoop = false;

        } catch (Exception e) {
            IO.println("Invalid input");
            reader.nextLine();
        }
    }

    reader.close();
}
