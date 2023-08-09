package my.day05.exam4;

public class SupersonicAirplaneExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SupersonicAirplane supersonicAirplane = new SupersonicAirplane();
		
		supersonicAirplane.takeOff();
		supersonicAirplane.fly();
		
		supersonicAirplane.flyMode = supersonicAirplane.SUPERSONIC;
		supersonicAirplane.fly();
		
		supersonicAirplane.flyMode = supersonicAirplane.NOMAL;
		supersonicAirplane.fly();
		
		supersonicAirplane.land();
	}

}
