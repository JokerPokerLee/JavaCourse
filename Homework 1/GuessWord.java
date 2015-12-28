import java.util.*;
import java.io.*;

public class GuessWord
{
	static String[] voc;
	static int vocSize;
	static Scanner cin = new Scanner(new BufferedInputStream(System.in));
	static PrintWriter cout = new PrintWriter(new OutputStreamWriter(System.out));
	private static void prepare()
	{
		voc = new String[50];
		voc[vocSize++] = "hello";
		voc[vocSize++] = "world";
		voc[vocSize++] = "apple";
		voc[vocSize++] = "there";
		voc[vocSize++] = "witch";
		voc[vocSize++] = "touch";
		voc[vocSize++] = "javac";
		voc[vocSize++] = "worth";
		voc[vocSize++] = "yield";
		voc[vocSize++] = "until";
		voc[vocSize++] = "paste";
		voc[vocSize++] = "guess";
		voc[vocSize++] = "water";
		voc[vocSize++] = "birds";
		voc[vocSize++] = "booty";
		voc[vocSize++] = "unite";
	}
	private static void print(String word, int len, boolean a[])
	{
		cout.print("The word now looks like this: ");
    	for (int i = 0; i < len; i++)
    		if (a[i])
    			cout.print(word.charAt(i));
    		else
    			cout.print('-');
    	cout.println();
    	cout.flush();
    }
	public static void main(String[] args)
	{
		prepare();

		cout.print("If you want to add some word or not? (y/n): ");
		cout.flush();

		char op;
		op = cin.next().charAt(0);
		if (op == 'y' || op == 'Y')
		{
			cout.println("The original vocabulary mostly cantains words with five chars");
			cout.println("please input the words you want to add(mark the end by '#'):");
			cout.flush();
			String ns;
			while (!(ns = cin.next()).equals("#"))
				voc[vocSize++] = ns;
		}

		cout.println("--------Let's play!--------");
		cout.println("Note that you only have 15 chance~\n");
		cout.flush();

		while (true)
		{
	    	Random randomGenerator = new Random();
	    	String word = voc[randomGenerator.nextInt(vocSize)];
	    	int len = word.length();
	    	cout.println("I've choose a word with length " + len + "!");

	    	boolean[] a = new boolean[len];
	    	for (int i = 0; i < len; i++)
	    		a[i] = false;
	    	print(word, len, a);

			int cnt = 0;
			while (cnt < 15)
			{
				cout.println("Guess which character(s) is(are) in the chosen word?");
				cout.println("(input '0' to quit the game, input '1' to get a hint)");
				cout.flush();
				char ch = cin.next().charAt(0);
				if (ch == '0')
					return;
				if (ch == '1')
				{
					for (int i = 0; i < len; i++)
						if (!a[i])
						{
							a[i] = true;
							break;
						}
				}
				if (ch < 'a')
					ch += 'a' - 'A';
				if (ch >= 'a' && ch <= 'z')
				{
					for (int i = 0; i < len; i++)
						if (!a[i] && word.charAt(i) == ch)
							a[i] = true;
				}
				print(word, len, a);
				boolean flag = true;
				for (int i = 0; i < len; i++)
					flag = flag && a[i];
				if (flag)
				{
					cout.println("\n~~~~Congratulations! You WIN the game!~~~~\n");
					cout.flush();
					break;
				}
				cnt++;
			}

			if (cnt == 15)
			{
				cout.println("\nSorry you failed :(");
				cout.println("The word is '" + word + "'.");
				cout.flush();
			}

			cout.println("\nDo you want to play again?(y/n) ");
			cout.flush();
			op = cin.next().charAt(0);
			if (op != 'y' && op != 'Y')
				break;
		}
	}
}