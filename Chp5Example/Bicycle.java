class Bicycle{
	public int cadence;
	public int speed;
	public int gear;
	public Bicycle(){
	}
	public Bicycle(int sC,int sS,int sG){
		gear=sG;
		speed=sS;
		cadence=sC;
	}
	public void setCadence(int newValue){
		cadence=newValue;
	}
	public void setGear(int newValue){
		gear=newValue;
	}
	public void applyBrake(int decrement){
		speed-=decrement;
	}
	public void speedUp(int increment){
		speed+=increment;
	}
}
class MountainBike extends Bicycle{
	public int seatHeight;
	public MountainBike(int sC,int sS,int sG,int sSH){
		gear=sG;
		speed=sS;
		cadence=sC;
		seatHeight=sSH;
	}
	public void setHeight(int newValue){
		seatHeight=newValue;
	}
}