import java.awt.*;
import java.util.*;
class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here
		int getid =emptyCellId;
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i] == buttonClicked) {
				getid = i;
				break;
			}
		}
		if ((getid + 1 == emptyCellId && (getid + 1) % 4 != 0)
				|| (getid - 1 == emptyCellId && (getid % 4 != 0))
				|| getid + 4 == emptyCellId || getid - 4 == emptyCellId) {
			swapButton(buttons[emptyCellId], buttonClicked);
			emptyCellId = getid;
		}
		
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		ArrayList<Integer> random=new ArrayList<Integer>(15);
		for(int i=1;i<=15;i++)
			random.add(i);
		for(int i=0;i<15;i++)
		{
			int a = getRandomNumber();
			int randomno = (int)(a*0.01*random.size());
			arr[i]=random.remove(randomno);
		}
		return arr;
	}
	
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] arr = getIntegerArrayOfButtonIds(buttons);
		for (int i = 1; i <= 15; i++) {
			if (arr[i - 1] != i) {
				winner = false;
			}
		}

		return winner;
	}
}