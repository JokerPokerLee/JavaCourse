//列出当前目录下文件名满足一定条件的文件清单
import java.io.*;
public class DirFilter implements FilenameFilter{
	private String prefix="",suffix="";
	public DirFilter(String filterstr)	{
		String fs=filterstr.toLowerCase();
		int i=fs.indexOf('*');
		int j=fs.indexOf('.');
		if(i>0)
			prefix=fs.substring(0,i);
		if(j>0)
			suffix=fs.substring(j+1);
	}
	public static void main(String args[])throws IOException{
		FilenameFilter filter=new DirFilter("test*.java");
		File f1=new File("");
		File curdir=new File(f1.getAbsolutePath(),"");
		System.out.println(curdir.getAbsolutePath());
		String str[]=curdir.list(filter);
		for(int i=0;i<str.length;i++)
			System.out.println("\t"+str[i]);
	}
	public boolean accept(File dir,String filename){
		boolean yes=true;
		try{
			filename=filename.toLowerCase();
			yes=(filename.startsWith(prefix))&(filename.endsWith(suffix));
		}catch(NullPointerException e){
			System.out.println(e.toString());
		}
		return yes;
	}
}