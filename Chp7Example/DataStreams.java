//支持基本数据类型和String值的二进制输入输出例程；

import java.io.*;
public class DataStreams{
	//二进制数据文件
	static final String dataFile = "invoicedata";
	//产品名称、单价、售出数量
	static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
	static final int[] units = { 12, 8, 13, 29, 50 };
	static final String[] descs = { "Java T-shirt",
									"Java Mug",
									"Duke Juggling Dolls",
									"Java Pin",
									"Java Key Chain" };
	public static void main(String args[])throws IOException{
		DataOutputStream out = null;
		//创建二进制输出流，直接将上述数据以二进制格式写入文件invoicedata中；
		try{
			out = new DataOutputStream((new FileOutputStream(dataFile)));
			for (int i = 0; i < prices.length; i ++){
				out.writeDouble(prices[i]);
				out.writeInt(units[i]);
				out.writeUTF(descs[i]);
			}				
		}finally{
			out.close();
		}
		DataInputStream in = null;
		double price;
		int unit;
		String desc;
		double total = 0.0;
		//创建二进制输入流，从文件invoicedata中读出数值，并计算所有产品盈利；
		try{
			in = new DataInputStream(new FileInputStream(dataFile));
			while (true) {
				price = in.readDouble();
				unit = in.readInt();
				desc = in.readUTF();
				System.out.format("You ordered %d units of %s at $%.2f%n",unit, desc, price);
        		total += unit * price;
			}
		}catch(EOFException e){
			System.out.println(e.toString());
		}
		finally{
			System.out.format("For a TOTAL of: $%.2f%n",total);
			in.close();
		}
	}
}
