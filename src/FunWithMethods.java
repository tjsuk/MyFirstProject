public class FunWithMethods {

    int x = 1;
    int y = 2;


    void main(){
        int total = add(2,3);  // function call
        print(add(2,3));  // procedure call and a function call

        double total2 = add(2.5f, 3);
        byte total3 = add((byte)2, (byte)3);
        int total4 = add(2,3,4);
    }

    int subtract (int number1, int number2){
        return number1 - number2;
    }

    // Method (Function)
    int add(int number1, int number2) {
        return number1 + number2;
    }

    int add(int number1, int number2, int number3) {
        return number1 + number2 + number3;
    }

    double add(float number1, int number2) {
        return number1 + number2;
    }

    double add(double number1, double number2) {
        return number1 + number2;
    }

    byte add(byte number1, byte number2) {
        return (byte)(number1 + number2);
    }


    // Method (Procedure)
    void print(int z) {
        System.out.println(z);
    }
}
