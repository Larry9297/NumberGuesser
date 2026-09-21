import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class guessNumber{
        public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int numberToGuess;
        //the halfway point in the range of -100 to 100 is 0..
        double currentGuess = 0;
        double guessFactor = 100;
        //User enters a number to be guessed. 
        System.out.println("Choose a number between -100 to 100 nonintegers will be truncated");
        //truncates decimals that get entered.
        numberToGuess = (int) (scanner.nextDouble()); 
        //returns an error if number is not in the range of 0-100
        if (numberToGuess < -100 || numberToGuess > 100) {
            System.out.println("Number not in range."); 
            scanner.close();
            return;
        }
        System.out.println("Ok! I'll guess it!"); 
        //loop that guesses the number. It adds a number that's half the possible range each time until it gets to the correct number.
        while (numberToGuess != currentGuess){
            guessFactor = guessFactor/2; //guess number gets halved each time.
            if (numberToGuess > currentGuess){
                currentGuess = currentGuess + Math.round(guessFactor); //If the actual number is greater than the guess it add the guess factor (rounded)
            } else {
                currentGuess = currentGuess - Math.round(guessFactor); // if the actual number is smaller than the guess it subtracts the guess factor.
            }
            //These print out the program's current guess and how much it'll add on to its guess. I added them for debugging.
            System.out.println("My next guess is " + currentGuess);
            System.out.println("Guess factor is " + guessFactor);
            //waits 250 milliseconds. This is to make the lines readable.
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        //prints out result. 
        System.out.println("I got it! It's " + currentGuess + ". Right?");
        scanner.close();
        return;
    }
}