public class FooCorporation {

	public static void main(String[] args) {

		calculatePay(35, 7.5);
		calculatePay(47, 8.2);
		calculatePay(73, 10.00);
	}

	static void calculatePay(int hours, double pay) {
		int overTime = 0;
		double overTimePay = 0;
		double totalPay = 0;

		if (hours > 60) {
			System.out.println("Error in hours worked.");
			return;
		}

		if (pay < 8.0) {
			System.out.println("Error in base pay.");
			return;
		}

		if (hours > 40) {
			overTime = hours - 40;
			overTimePay = overTime * pay * 1.5;
			totalPay = 40 * pay + overTimePay;
		} else {
			totalPay = hours * pay;
		}

		System.out.println("Total pay is " + totalPay);

		return;
	}

}
