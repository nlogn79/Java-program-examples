class Marathon {
	public static void main(String[] args) {

		String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James",
				"Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };

		int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };

		int indexOfRunner = bestRunner(names, times);

		System.out.println("The best runner is " + names[indexOfRunner] + ", time is " + times[indexOfRunner]);

		indexOfRunner = secondRunner(names, times);

		System.out.println("The second runner is " + names[indexOfRunner] + ", time is " + times[indexOfRunner]);

	}

	public static int bestRunner(String[] name, int[] min) {

		int leastMin = Integer.MAX_VALUE;
		int index = -1;

		for (int i = 0; i < name.length; i++) {
			if (leastMin > min[i]) {
				leastMin = min[i];
				index = i;
			}
		}

		return index;
	}

	public static int secondRunner(String[] name, int[] min) {

		int indexBest = bestRunner(name, min);

		int leastMin = Integer.MAX_VALUE;
		int index = -1;

		for (int i = 0; i < name.length; i++) {

			if (i == indexBest) {
				continue;
			}

			if (leastMin > min[i]) {
				leastMin = min[i];
				index = i;
			}
		}

		return index;
	}

}
