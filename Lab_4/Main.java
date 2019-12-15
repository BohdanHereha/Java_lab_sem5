package com.company;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

		University[] univer = new University[4];

		univer[0] = new University("National Technical University of Ukraine \"Igor Sikorsky Kyiv " + "Polytechnic Institute\"",
				"FIOT", 456654,154, 45.45f);
		univer[1] = new University("Taras Shevchenko National University of Kyiv", "FIOT",
				124378, 111, 45f);
		univer[2] = new University("Borys Grinchenko University of Kyiv", "FIOT",
				98567, 78, 40.4559f);
		univer[3] = new University("Kyiv National University of Culture and Arts", "FPA",
				120459, 125, 0f);

		Arrays.sort(univer, (University a, University b) -> {return a.getNameUiver().toString().compareTo(b.getNameUiver().toString());});
        System.out.println("Сортуваня за алфавітом");
		printArray(univer);
		System.out.println("⚫⚪⚫⚪⚫⚪⚫⚪⚫⚪⚫⚪⚫⚪⚫⚪⚫⚪⚫⚪⚫⚪⚫⚪");

		Arrays.sort(univer, new Comparator<University>() {
			public int compare(University a, University b) {
				float p1 = a.getPercentage();
				float p2 = b.getPercentage();

				if (p1 > p2) {
					return -1;
				} else if (p1 < p2) {
					return 1;
				} else {
					return 0;
				}
			}
		});

        System.out.println("Сортуваня за відсотками степендіатів");
		printArray(univer);
        System.out.println("⚫⚪⚫⚪⚫⚪⚫⚪⚫⚪⚫⚪⚫⚪⚫⚪⚫⚪⚫⚪⚫⚪⚫⚪");

        Arrays.sort(univer, new Comparator<University>() {
            public int compare(University a, University b) {
                int d1 = a.getNumbStud();
                int d2 = b.getNumbStud();

                if (d1 > d2){
                    return 1;
                } else if (d1 < d2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println("Сортуваня за кількістю студентів");
		printArray(univer);
		//System.out.println(univer[0].getClass());
    }

	static void printArray(University[] univer) {
		for (int i = 0; i < univer.length; i++) {
			univer[i].printInfo();
			System.out.println();
		}
	}

}
