package annotations;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Annotations {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<String> elBooks = new ArrayList<String>(), audios = new ArrayList<String>(), videos = new ArrayList<String>(),
			images = new ArrayList<String>();
	public static void main(String[] args) {
		boolean isGot = false, contains = false;
		while (true) {
			Collection<String> gallery = new ArrayList<String>();
			System.out.println("тип вводимого медиа (при нажатии на 0 происходит выход из ввода, на 1 - вводится электронная книга, 2 - аудио, 3 - видео, 4 - изображение, 5 - удаление медиа)");
			int medType = scanner.nextInt();
			switch(medType) {
			case 0: {
				isGot = true;
				break;
			}
			case 1: {
				enter(elBooks);
				contains = true;
				break;
			}
			case 2: {
				enter(audios);
				contains = true;
				break;
			}
			case 3: {
				enter(videos);
				contains = true;
				break;
			}
			case 4: {
				enter(images);
				contains = true;
				break;
			}
			case 5: {
				System.out.println("название медиа, которое надо удалить");
				String item = scanner.next();
				remIt(item);
				break;
			}
			}
			String[] books = new String[elBooks.toArray().length], audios_ = new String[audios.toArray()
			                                                                            .length], videos_ = new String[videos.toArray().length],
					pictures = new String[images.toArray().length];
			for (int i = 0; i < elBooks.toArray().length; i++) books[i] = String.valueOf(elBooks
					.toArray()[i]);
			for (int i = 0; i < audios.toArray().length; i++) audios_[i] = String.valueOf(audios
					.toArray()[i]);
			for (int i = 0; i < videos.toArray().length; i++) videos_[i] = String.valueOf(videos
					.toArray()[i]);
			for (int i = 0; i < images.toArray().length; i++) pictures[i] = String.valueOf(images
					.toArray()[i]);
			String[][] medTyp = { books, audios_, videos_,
					pictures };
			Addendum addendum = new Addendum();
			int prevCollLength = gallery.toArray().length;
			for (int i = 0; i < medTyp.length; i++) for (int x = 0; x < medTyp[i].length; x++) addendum.addToColl(medTyp[i][x], gallery);
			for (int i = 0; i < gallery.toArray().length; i++) System.out
			.print(gallery.toArray()[i] + " ");
			int nextCollLength = gallery.toArray().length;
			if (prevCollLength >= nextCollLength) contains = true;
			if (gallery.toArray().length == 0) contains = false;
			if (contains) System.out.println();
			if (isGot) break;
		}
		Student student = new Student(), undergraduate = new Student(), classman = new Student();
		Student[] students = { student, undergraduate, classman };
		students[0].studName = "overyan";
		students[1].studName = "valera";
		students[2].studName = "genya";
		String[] names = { students[0].studName, students[1].studName, students[2].studName };
		isGot = false;
		while (true) {
			System.out.println("студент (при нажатии на 0 происходит выход из ввода, 1 - выбирается " + names[0] + ", 2 - " + names[1] + ", 3 - " + names[2] + ", 4 - удаление оценки)");
			int studNumb = scanner.nextInt();
			switch(studNumb) {
			case 0: {
				isGot = true;
				break;
			}
			case 1: {
				introduse(students[0].marks);
				break;
			}
			case 2: {
				introduse(students[1].marks);
				break;
			}
			case 3: {
				introduse(students[2].marks);
				break;
			}
			case 4: {
				System.out.println("выбор студента (при нажатии на 0 происходит выход из удаления, 1 - выбирается " + names[0] + ", 2 - " + names[1] + ", 3 - " + names[2] + ")");
				int number = scanner.nextInt();
				switch(number) {
				case 0: break;
				case 1: {
					remMark(students[0].marks);
					break;
				}
				case 2: {
					remMark(students[1].marks);
					break;
				}
				case 3: {
					remMark(students[2].marks);
					break;
				}
				}
			}
			}
			for (int i = 0; i < students.length; i++) System.out.println(students[i]
					.studName + ": " + Arrays.toString(students[i].marks.toArray()));
			if (isGot) break;
		}
	}
	static void enter(ArrayList<String> list) {
		System.out.println("название");
		String sake = scanner.next();
		Media media = new Media();
		media.name = sake;
		list.add(sake);
	}
	/**
	 * @deprecated (удаление запрещено).
	 */
	@Deprecated
	static void remIt(String thing) {
		Removal removal = new Removal();
		removal.remThing(elBooks, thing);
		removal.remThing(audios, thing);
		removal.remThing(videos, thing);
		removal.remThing(images, thing);
	}
	static void introduse(ArrayList<Integer> estimators) {
		System.out.println("оценка");
		int estimate = scanner.nextInt();
		if (estimate < 1) {
			System.out.println("минимальная оценка - 1");
			return;
		}
		if (estimate > 12) {
			System.out.println("максимальная оценка - 12");
			return;
		}
		StudAdd studAdd = new StudAdd();
		studAdd.addToList(estimators, estimate);
	}
	/**
	 * @deprecated (устаревшая функция).
	 */
	@Deprecated
	static void remMark(ArrayList<Integer> assessments) {
		System.out.println("номер оценки по порядку");
		int markNumb = scanner.nextInt();
		if (markNumb < 1) {
			System.out.println("минимальная оценка - первая");
			return;
		}
		if (markNumb > assessments.toArray().length) {
			System.out.println("переполнение списка. количество оценок студента - " + assessments.toArray()
					   .length);
			return;
		}
		assessments.remove(markNumb - 1);
	}
}
