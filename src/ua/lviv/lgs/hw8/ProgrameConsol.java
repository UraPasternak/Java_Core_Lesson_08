package ua.lviv.lgs.hw8;

import java.util.Scanner;

public class ProgrameConsol {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str;

		Months[] months = Months.values();
		menu();
		while (true) {

			str = scanner.nextLine();
			switch (str) {
			case "1": {
				System.out.println("Введіть місяць англійською: ");
				str = scanner.nextLine();

				if (isMonth(str))
					System.out.println("Так, такий місяць існує");
				else
					System.out.println("Ні, такого місяця нема");

				System.out.println("==========================================================================");
				break;
			}
			case "2": {
				System.out.println("Введіть сезон англійською: ");
				str = scanner.nextLine();

				if (isSeason(str)) {
					for (Months month : Months.values()) {
						if (month.getSeason().name().equalsIgnoreCase(str))
							System.out.println(month);
					}
				} else
					System.out.println("Не існує такого сезону!");
				System.out.println("==========================================================================");
				break;
			}
			case "3": {
				System.out.println("Введіть місяць англійською: ");
				str = scanner.nextLine();

				if (isMonth(str)) {
					System.out.println("Місяці з такими ж днями: ");
					Months month = Months.valueOf(str.toUpperCase());
					for (Months m : Months.values()) {
						if (m.getDay() == month.getDay())
							System.out.println(m);
					}
				} else
					System.out.println("Це не місяць!");
				System.out.println("==========================================================================");
				break;
			}
			case "4": {
				System.out.println("Введіть місяць англійською: ");
				str = scanner.nextLine();

				if (isMonth(str)) {
					System.out.println("Місяці у яких є менше днів: ");
					Months month = Months.valueOf(str.toUpperCase());
					for (Months m : Months.values()) {
						if (m.getDay() < month.getDay())
							System.out.println(m);
					}
				} else
					System.out.println("Це не місяць!");
				System.out.println("==========================================================================");
				break;
			}
			case "5": {
				System.out.println("Введіть місяць англійською: ");
				str = scanner.nextLine();

				if (isMonth(str)) {
					System.out.println("Місяці у яких є більше днів: ");
					Months month = Months.valueOf(str.toUpperCase());
					for (Months m : Months.values()) {
						if (m.getDay() > month.getDay())
							System.out.println(m);
					}
				} else
					System.out.println("Це не місяць!");
				System.out.println("==========================================================================");
				break;
			}
			case "6": {
				System.out.println("Введіть сезон англійською: ");
				str = scanner.nextLine();

				if (isSeason(str)) {
					System.out.println(Seasons.values()[(Seasons.valueOf(str.toUpperCase()).ordinal() + 1) % 4]);
				} else
					System.out.println("Не існує такого сезону!");
				System.out.println("==========================================================================");
				break;
			}
			case "7": {
				System.out.println("Введіть сезон англійською: ");
				str = scanner.nextLine();

				if (isSeason(str)) {
					int ord = Seasons.valueOf(str.toUpperCase()).ordinal() - 1;
					System.out.println(Seasons.values()[ord < 0 ? 3 : ord]);
				} else
					System.out.println("Не існує такого сезону!");
				System.out.println("==========================================================================");
				break;
			}
			case "8": {
				for (Months month : months) {
					if (month.getDay() % 2 == 0)
						System.out.println(month);

				}
				System.out.println("==========================================================================");
				break;
			}
			case "9": {
				for (Months month : months) {
					if (month.getDay() % 2 != 0)
						System.out.println(month);

				}
				System.out.println("==========================================================================");
				break;
			}
			case "10": {
				System.out.println("Введіть місяць англійською: ");
				str = scanner.nextLine();

				if (isMonth(str)) {
					Months month = Months.valueOf(str.toUpperCase());
					if (month.getDay() % 2 == 0)
						System.out.println("Місяць має парну кількість днів");
					else
						System.out.println("Місяць має непарну кількість днів");

				} else
					System.out.println("Це не місяць!");
				System.out.println("==========================================================================");
				break;
			}
			}

		}
	}

	static void menu() {
		System.out.println("Введіть:");
		System.out.println("1 - Перевірити чи є такий місяць");
		System.out.println("2 - Вивести всі місяці з такою ж порою року");
		System.out.println("3 - Вивести всі місяці які мають таку саму кількість днів");
		System.out.println("4 - Вивести на екран всі місяці які мають меншу кількість днів");
		System.out.println("5 - Вивести на екран всі місяці які мають більшу кількість днів");
		System.out.println("6 - Вивести на екран наступну пору року");
		System.out.println("7 - Вивести на екран попередню пору року");
		System.out.println("8 - Вивести на екран всі місяці які мають парну кількість днів");
		System.out.println("9 - Вивести на екран всі місяці які мають непарну кількість днів");
		System.out.println("10 - Вивести на екран чи введений з консолі місяць має парну кількість днів");

	}

	static boolean isMonth(String str) {
		boolean isMonth = false;
		for (Months month : Months.values()) {
			if (str.equalsIgnoreCase(month.name())) {
				isMonth = true;
				break;
			}
		}
		return isMonth;

	}

	static boolean isSeason(String str) {
		boolean isSeason = false;
		for (Seasons seasons : Seasons.values()) {
			if (str.equalsIgnoreCase(seasons.name())) {
				isSeason = true;
				break;
			}
		}
		return isSeason;

	}
}
