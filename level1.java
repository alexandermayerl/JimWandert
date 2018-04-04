import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class level1 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// Testdaten einlesen
		String input = "";
		if (args.length > 0) {
			String inputData = "";
			inputData = loadInputData(args[0]);
			if (!inputData.isEmpty()) {
				input = inputData;
			}
		}
		if (input.length() < 1) {
			System.out.println("no input data found.");
			System.exit(0);
		}
		input = input.replaceAll("\r\n", "");
		
		int y = 0;
		int numF = 0;
		int sumOfSteps = 0;
		
		String[] eingabe = input.split(" ");
		String[] commands = new String[Integer.parseInt(eingabe[0])];
		int[] numbers = new int[Integer.parseInt(eingabe[0])];
		int[] numOfF = new int[commands.length];
		int n = Integer.parseInt(eingabe[0]);
		
		
		for(int i = 1; i <= (n*2 - 1); i += 2)
		{
			commands[y] = eingabe[i];
			y ++;
		}
		y = 0;
		
		for (int i = 2; i <= n*2; i+=2)
		{
			numbers[y] = Integer.parseInt(eingabe[i]);
			y++;
		}
		
		for(int i = 0; i < commands.length; i ++) 
		{
			for(char c : commands[i].toCharArray())
			{
				if(c == 'F')
				{
					numF++;
				}
			}
			numOfF[i] = numF;
			numF = 0;
		}
		
		for(int i = 0; i < numOfF.length; i++)
		{
			sumOfSteps += numOfF[i]*numbers[i]; 
		}
		
		JOptionPane.showMessageDialog(null, sumOfSteps);
		
		
	}
	
	//_________________________________________________________________________________________
	public static String loadInputData(String datName) {
		String fileData = "";
		File file = new File(datName);

		if (!file.canRead() || !file.isFile()) {
			return "";
		}
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(datName));
			String zeile = null;
			while ((zeile = in.readLine()) != null) {
				fileData += zeile+"\r\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return fileData;
	}
}
