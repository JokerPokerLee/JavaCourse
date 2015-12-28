/**
 * @(#)CloneEx.java
 *
 *
 * @author 
 * @version 1.00 2014/3/19
 */

class CloneSimp{
	int data;
	public CloneSimp(int data){
		this.data=data;
	}
	void setDataDouble(){
		data=2*data;
	}
	public String toString(){
		return ""+data;
	}
}

class CloneNoSimp implements Cloneable{
	int data;
	CloneSimp c=new CloneSimp(5);
	public CloneNoSimp(int data){
		this.data=data;
	}
	public Object clone(){
		CloneNoSimp cns=null;
		try{
			cns=(CloneNoSimp)super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return cns;
	}	
}


public class CloneEx {

    public CloneEx() {
    }
    public static void main(String args[]){
    	CloneNoSimp source=new CloneNoSimp(10);
    	System.out.println("before clone:source:data="+source.data+";c="+source.c);
    	
    	CloneNoSimp dest=(CloneNoSimp)source.clone();    	
    	System.out.println("after clone:dest:data="+dest.data+";c="+dest.c);
    	
    	dest.data=20;
    	dest.c.setDataDouble();
    	
    	System.out.println("after clone&double:source:data="+source.data+";c="+source.c);
    	System.out.println("after clone&double:dest:data="+dest.data+";c="+dest.c);
    	
    }
    
    
}