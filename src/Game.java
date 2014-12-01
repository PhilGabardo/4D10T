package philgabardo.fourdigits10tries;


import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends Activity {
	
	private static int digit1;
	private static int digit2;
	private static int digit3;
	private static int digit4;
	private static int guessesLeft;
	private static int correctDigits;
	private static int correctPlaces;
	public NumberPicker D1;
	private static NumberPicker D2;
	private static NumberPicker D3;
	private static NumberPicker D4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game2);
        guessesLeft = 10;
        
        //Initialize number pickers
        NumberPicker D1 = (NumberPicker) findViewById(R.id.D1);
        D1.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        D1.setMaxValue(9);
        D1.setMinValue(0);
        NumberPicker D2 = (NumberPicker) findViewById(R.id.D2);
        D2.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        D2.setMaxValue(9);
        D2.setMinValue(0);
        NumberPicker D3 = (NumberPicker) findViewById(R.id.D3);
        D3.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        D3.setMaxValue(9);
        D3.setMinValue(0);
        NumberPicker D4 = (NumberPicker) findViewById(R.id.D4);
        D4.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        D4.setMaxValue(9);
        D4.setMinValue(0);
        
        //Initialize labels
        final TextView guessesLeftText = (TextView) findViewById(R.id.GuessesLeft);
        guessesLeftText.setText("Number of Guesses Left: 10");
        final TextView correctDigitsText = (TextView) findViewById(R.id.CorrectDigits);
        correctDigitsText.setText("Number of Correct Digits: ");
        final TextView correctPlacesText = (TextView) findViewById(R.id.CorrectPlaces);
        correctPlacesText.setText("Number of Correctly Placed Digits: ");
        final TextView pastGuessesText = (TextView) findViewById(R.id.PastGuesses);
        pastGuessesText.setText("Previous Guess:");
	
	//Generate digits to guess
        RandomInteger r = new RandomInteger();
        final int[]digits = r.generate();
        digit1 = digits[0];
        digit2 = digits[1];
        digit3 = digits[2];
        digit4 = digits[3];
        
        //Guess button disposition
        Button guess = (Button) findViewById(R.id.Guess);
        guess.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            //Retrieve digits from UI
            int[] localDigits = new int[]{digits[0],digits[1],digits[2],digits[3]};
            guessesLeft--;
            NumberPicker D1 = (NumberPicker) findViewById(R.id.D1);
            int guess1 = D1.getValue();	
            NumberPicker D2 = (NumberPicker) findViewById(R.id.D2);
            int guess2 = D2.getValue();	
            NumberPicker D3 = (NumberPicker) findViewById(R.id.D3);
            int guess3 = D3.getValue();
            NumberPicker D4 = (NumberPicker) findViewById(R.id.D4);
            int guess4 = D4.getValue();	
            
            correctDigits = 0;
            correctPlaces = 0;
            
            //Determine correctly placed digits
            if(guess1==digit1){
            	correctPlaces++;
            }
            if(guess2==digit2){
            	correctPlaces++;
            }
            if(guess3==digit3){
            	correctPlaces++;
            }
            if(guess4==digit4){
            	correctPlaces++;
            }
            
            //Determine correct digits (placement disregarded)
            if(guess1==localDigits[0]||guess1==localDigits[1]||guess1==localDigits[2]||guess1==localDigits[3]){
            	correctDigits++;
            	for(int i=0; i<4; i++){
            		if(guess1==localDigits[i]){
            			localDigits[i]=-1;
            			break;
            		}
            	}
            	
            	
            }
            if(guess2==localDigits[0]||guess2==localDigits[1]||guess2==localDigits[2]||guess2==localDigits[3]){
            	correctDigits++;
            	for(int i=0; i<4; i++){
            		if(guess2==localDigits[i]){
            			localDigits[i]=-1;
            			break;
            		}
            	}
            	
            	
            }
            if(guess3==localDigits[0]||guess3==localDigits[1]||guess3==localDigits[2]||guess3==localDigits[3]){
            	correctDigits++;
            	for(int i=0; i<4; i++){
            		if(guess3==localDigits[i]){
            			localDigits[i]=-1;
            			break;
            		}
            	}
            	
            	
            }
            if(guess4==localDigits[0]||guess4==localDigits[1]||guess4==localDigits[2]||guess4==localDigits[3]){
            	correctDigits++;
            	for(int i=0; i<4; i++){
            		if(guess4==localDigits[i]){
            			localDigits[i]=-1;
            			break;
            		}
            	}
            	
            	
            }
            
            //Updated labels
            String pastGuess=""+guess1+""+""+guess2+""+""+guess3+""+""+guess4+"";
            guessesLeftText.setText("Number of Guesses Left: " + guessesLeft);
            correctDigitsText.setText("Number of Correct Digits: "+ correctDigits);
            correctPlacesText.setText("Number of Correctly Placed Digits: "+ correctPlaces);
            pastGuessesText.setText("Previous Guess: " + pastGuess);
            
            //Player lost
            if(guessesLeft==0 && correctPlaces!=4){
            	Intent i = new Intent(getApplicationContext(), Loser.class);
				startActivity(i);  
            		
            }
            
            //Player won
            if(correctPlaces==4){
            	    Intent i = new Intent(getApplicationContext(), Winner.class);
            	    i.putExtra("WinningNumber", ""+digit1+""+digit2+""+digit3+""+digit4+"");
				startActivity(i);  
            		
            }
   
            }
        });
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    }

    @Override
    protected void onRestoreInstanceState(Bundle inState) {
    }
    
}
