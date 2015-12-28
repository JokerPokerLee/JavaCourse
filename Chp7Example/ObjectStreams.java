//对象输入输出例程；

import java.io.*;
import java.math.*;
public class ObjectStreams{
	//二进制数据文件
	static final String dataFile = "invoicedata";
	//产品名称、单价、售出数量
	static final BigDecimal[] prices = {
									new BigDecimal("19.99"),
									new BigDecimal("9.99"),
									new BigDecimal("15.99"),
									new BigDecimal("3.99"),
									new BigDecimal("4.99"),
									};
	static final int[] units = { 12, 8, 13, 29, 50 };
	static final String[] descs = { "Java T-shirt",
									"Java Mug",
									"Duke Juggling Dolls",
									"Java Pin",
									"Java Key Chain" };
	//JVM读出一个对象时，若该对象所属的类还没装入，则首先装入该类，若该类不存在，则会抛出ClassNotFoundException
	public static void main(String args[])throws IOException,ClassNotFoundException{
		ObjectOutputStream out = null;
		//创建对象输出流，直接将上述数据以二进制格式写入文件invoicedata中；
		try{
			out = new ObjectOutputStream((new FileOutputStream(dataFile)));
			for (int i = 0; i < prices.length; i ++){
				//将BigDecimal对象写入；
				out.writeObject(prices[i]);
				out.writeInt(units[i]);
				out.writeUTF(descs[i]);
			}				
		}finally{
			out.close();
		}
		ObjectInputStream in = null;
		BigDecimal price;
		int unit;
		String desc;
		double total = 0.0;
		//创建对象输入流，从文件invoicedata中读出数值，并计算所有产品盈利；
		try{
			in = new ObjectInputStream(new FileInputStream(dataFile));
			while (true) {
				//将BigDecimal对象读出；
				price =(BigDecimal)(in.readObject());
				unit = in.readInt();
				desc = in.readUTF();
				System.out.format("You ordered %d units of %s at $%.2f%n",unit, desc, price);
        		total += unit * price.doubleValue();
			}
		}catch(IOException e){
			System.out.println(e.toString());
		}
		finally{
			System.out.format("For a TOTAL of: $%.2f%n",total);
			in.close();
		}
	}
}
