package philgabardo.fourdigits10tries;

import java.util.Random;

/** Generate 4 random integers in the range 0..9. */
public final class RandomInteger {
  
  int[] generate(){
    int[] numbers =  new int[4];
    Random randomGenerator = new Random();
    for (int idx = 0; idx < 4; ++idx){
      int randomInt = randomGenerator.nextInt(10);
      numbers[idx]=randomInt;
    }   
    return numbers;
  }
}
