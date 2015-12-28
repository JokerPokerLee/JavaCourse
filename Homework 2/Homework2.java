import java.util.*;
import java.io.*;

public class Homework2
{
	static Scanner in = new Scanner(new BufferedInputStream(System.in));
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	private static void printCommand()
	{
		out.println("*************************************************");
		out.println("*Command List:                                  *");
		out.println("*   *askIndex k                                 *");
		out.println("*    ---querry the k-th number in the list.     *");
		out.println("*   *askValue x                                 *");
		out.println("*    ---querry if x is in the list.             *");
		out.println("*   *insert k x                                 *");
		out.println("*    ---insert a number x after the k-th number *");
		out.println("*       in the LinkList.                        *");
		out.println("*   *insertArray k n a1 a2 ... an               *");
		out.println("*    ---insert an array with length n whose     *");
		out.println("*       elements are {a1 a2 ... an} after k-th  *");
		out.println("*       number in the LinkList.                 *");
		out.println("*   *deleteIndex k                              *");
		out.println("*    ---delete the k-th number in the list.     *");
		out.println("*   *deleteValue x                              *");
		out.println("*    ---delete all the numbers in the list which*");
		out.println("*       equal to x.                             *");
		out.println("*   *print                                      *");
		out.println("*    ---print the whole list.                   *");
		out.println("*   *help                                       *");
		out.println("*    ---print the command list.                 *");
		out.println("*   *exit                                       *");
		out.println("*    ---quit the process.                       *");
		out.println("*************************************************");
		out.println();
		out.flush();
	}
	public static void main(String argv[])
	{
		printCommand();

		LinkList list = new LinkList();
		out.println("LinkList initialized.");
		out.println("Size:\t" + list.size() + "\n");
		out.flush();

		boolean run = true;
		while (run)
		{
			int x, n, k;
			int[] arr = new int[20];
			String str = new String();
			str = in.next();
			switch (str)
			{
				case "askValue":
					x = in.nextInt();
					int pos = list.findByValue(x);
					if (pos == -1)
						out.println("There is no " + x + " in the list.");
					else
						out.println(x + " is the NO." + pos + " number in the list.");
					out.flush();
					break;
				case "askIndex":
					k = in.nextInt();
					if (k <= 0 || k > list.size())
					{
						out.println("Out of range!");
						out.flush();
						break;
					}
					x = list.findByIndex(k);
					out.println("The NO." + k + " number in the list is " + x + ".");
					out.flush();
					break;
				case "insert":
					k = in.nextInt();
					x = in.nextInt();
					if (k <= 0 || k > list.size())
					{
						out.println("Out of range!");
						out.flush();
						break;
					}
					list.insert(x, k);
					break;
				case "insertArray":
					k = in.nextInt();
					n = in.nextInt();
					for (int i = 0; i < n; i++)
						arr[i] = in.nextInt();
					if (k <= 0 || k > list.size())
					{
						out.println("Out of range!");
						out.flush();
						break;
					}
					list.insert(arr, n, k);
					break;
				case "deleteIndex":
					k = in.nextInt();
					if (k <= 0 || k > list.size())
					{
						out.println("Out of range!");
						out.flush();
						break;
					}
					list.deleteByIndex(k);
					break;
				case "deleteValue":
					x = in.nextInt();
					list.deleteByValue(x);
					break;
				case "print":
					list.print();
					break;
				case "help":
					printCommand();
					break;
				case "exit":
					run = false;
					break;
				default:
					out.println("Invalid command.");
					out.flush();
					break;
			}
		}
	}
}

class LinkList
{
	private int size;
	private Node head;
	static int INF = 0x3f3f3f3f;
	LinkList()
	{
		size = 0;
		head = new Node(INF, null);
	}
/*	void destroy()
	{

	}*/
	int size()
	{
		return size;
	}
	void insert(int x, int k)					//insert a new number x after the k-th number
	{
		Node newNode = new Node(x, null);
		Node now = head;
		while (k-- > 0)
			now = now.next();
		if (k < size)
			newNode.attach(now.next());
		now.attach(newNode);
		size++;
	}
	void insert(int arr[], int n, int k)		//insert an array of n numbers after k-th number
	{
		if (k < 0 || k > size)
			return;
		for (int i = 0; i < n; i++)
			insert(arr[i], k + i);
	}
	int findByIndex(int k)						//find k-th number
	{
		if (k > size)
			return INF;
		Node now = head;
		while (k > 0)
		{
			now = now.next();
			k--;
		}
		return now.value();
	}
	int findByValue(int x)						//find if there exist x
	{
		int res = 1;
		Node now = head.next();
		while (now != null)
		{
			if (now.value() == x)
				return res;						//if found x return the first position
			now = now.next();
			res++;
		}
		return -1;								//if not found return -1
	}
	void deleteByIndex(int k)					//delete k-th number
	{
		if (k < 0 || k > size)
			return;
		Node now = head, pre = head;
		while (k-- > 0)
		{
			pre = now;
			now = now.next();
		}
		pre.attach(now.next());
		//now.destroy();
		size--;
	}
	void deleteByValue(int x)					//delete number x
	{
		Node now = head.next(), pre = head;
		while (now != null)
		{
			if (now.value() == x)
			{
				pre.attach(now.next());
				//now.destroy();
				size--;
			} else
				pre = now;
			now = now.next();
		}
	}
	void print()
	{
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		out.println("Size:\t" + size);
		out.flush();
		Node now = head.next();
		if (now == null)
			return;
		out.print(now.value());
		now = now.next();
		while (now != null)
		{
			out.print('\t');
			out.print(now.value());
			now = now.next();
		}
		out.println();
		out.flush();
	}
}

class Node
{
	int val;
	Node next;
	Node(int x, Node nex)
	{
		val = x;
		next = nex;
	}
/*	void destroy()
	{

	}*/
	int value()
	{
		return val;
	}
	Node next()
	{
		return next;
	}
	void attach(Node nextNode)
	{
		next = nextNode;
	}
}
