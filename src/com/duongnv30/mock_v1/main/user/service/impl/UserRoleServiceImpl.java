package com.duongnv30.mock_v1.main.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.duongnv30.mock_v1.main.user.service.UserRoleService;
import com.duongnv30.mock_v1.model.Book;
import com.duongnv30.mock_v1.model.BookCase;
import com.duongnv30.mock_v1.model.Contain;
import com.duongnv30.mock_v1.model.User;
import com.duongnv30.mock_v1.service.impl.BookCaseServiceImpl;
import com.duongnv30.mock_v1.service.impl.BookServiceImpl;
import com.duongnv30.mock_v1.service.impl.ContainServiceImpl;

public class UserRoleServiceImpl implements UserRoleService {

	/*
	 * Xem danh sách Book trong hệ thống
	 */
	@Override
	public void ViewListBook() {
		System.out.println("\n\t\t----View List Book----\t\t\n");
		System.out.println("STT  id    Name                Author              Category"
				+ "            Brief               Tile                Publisher");
		List<Book> listBook = BookServiceImpl.getInstance().findAll();
		if (listBook == null || listBook.isEmpty()) {
			System.out.println("    There is not any book in application");
		} else {
			int n = listBook.size();
			for (int i = 0; i < n; i++) {
				int index = i + 1;
				Book b = listBook.get(i);
				System.out.println(String.format(
						"%2d  |%1d    |%-15s    |%-15s    |%-15s" + "    |%-15s    |%-15s    |%-15s", index, b.getId(),
						subStringByMe(b.getName()), subStringByMe(b.getAuthor()), subStringByMe(b.getCategory()),
						subStringByMe(b.getBrief()), subStringByMe(b.getTitle()), subStringByMe(b.getPublisher())));
			}
		}
		System.out.println("\n\t\t--------\t\t\n\n");
	}

	/*
	 * Tìm kiếm sách theo các tiêu chí
	 */
	@Override
	public void SearchBook(Scanner sc) {
		System.out.println("\n\t\t----Search Book----\t\t\n");
		String keySearch, type;
		do {
			System.out.println("Please enter type: ");
			System.out.println("1.By name\n2.By author\n3.By category\n4.Press any key to exit");
			type = sc.nextLine().trim();
			List<Book> listBook = new ArrayList<>();
			switch (type) {
			case "1":
				System.out.print("Please enter book's name: ");
				keySearch = sc.nextLine().trim();
				listBook = BookServiceImpl.getInstance().findByName(keySearch);
				showListBook(listBook);
				break;
			case "2":
				System.out.print("Please enter book's author: ");
				keySearch = sc.nextLine().trim();
				listBook = BookServiceImpl.getInstance().findByAuthor(keySearch);
				showListBook(listBook);
				break;
			case "3":
				System.out.print("Please enter book's category: ");
				keySearch = sc.nextLine().trim();
				listBook = BookServiceImpl.getInstance().findByCategory(keySearch);
				showListBook(listBook);
				break;
			default:
				System.out.println("\n\t\t--------\t\t\n\n");
				return;
			}

		} while (true);
	}

	/*
	 * xem chi tiết của Book (hiển thị BookName và Content)
	 */
	@Override
	public void ReadBook(Scanner sc) {
		System.out.println("\n\t\t----Read Book----\t\t\n");
		String idString;
		System.out.println(">>List Book of System<<");
		showListBook(BookServiceImpl.getInstance().findAll());
		do {
			System.out.print("\n>>Please enter the book's id: ");
			idString = sc.nextLine().trim();
			try {
				int id = Integer.parseInt(idString);
				Book book = BookServiceImpl.getInstance().findByID(id);
				if (book != null) {
					System.out.println(book.getName().toUpperCase());
					System.out.println(" " + book.getContent());
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("This book is not exist!");
			}
			System.out.print("\n\nDo you continue readBook?(Y/N): ");
			idString = sc.nextLine().trim();
			if (idString.charAt(0) == 'N' || idString.charAt(0) == 'n')
				break;
		} while (true);
		System.out.println("\n\t\t--------\t\t\n\n");
	}

	/*
	 * Xem BookCase (danh sách Book trong BookCase)
	 */
	@Override
	public void viewBookCase(User user) {
		System.out.println("\n\t\t----View BookCase----\t\t\n");
		user.setBookCase(BookCaseServiceImpl.getInstance().findOne(user.getId()));
		if (user.getBookCase() == null || user.getBookCase().getListBook().isEmpty()) {
			System.out.println("Your BookCase is empty!");
		} else {
			showListBook(user.getBookCase().getListBook());
		}
		System.out.println("\n\t\t--------\t\t\n");
	}

	/*
	 * Chỉnh sửa BookCase (thêm Book, xóa 1 Book, làm trống BookCase)
	 */
	@Override
	public void editBookCase(Scanner sc, User user) {
		System.out.println("\n\t\t----Edit BookCase----\t\t\n");
		String choice;
		do {
			System.out.println(">>Please enter the number: ");
			System.out.println("1.Add a new book\n2.Remove a book\n3.Clear BookCase");
			System.out.println("4.Press any key to exit");
			choice = sc.nextLine().trim();
			switch (choice) {
			case "1":
				System.out.println("\n----Add a new book----");
				addBookToBookCase(sc, user);
				break;
			case "2":
				System.out.println("\n---Remove a book----");
				removeBookFromBookCase(sc, user);
				break;
			case "3":
				System.out.println("\n----Clear BookCase----");
				clearBookCase(user);
				break;
			default:
				System.out.println("\n\t\t--------\t\t\n");
				return;
			}
		} while (true);
	}

	/*
	 * Thêm Book vào BookCase
	 */
	public static void addBookToBookCase(Scanner sc, User user) {
		String idString;
		System.out.println("Please enter the id:");
		idString = sc.nextLine().trim();
		try {
			int id = Integer.parseInt(idString);
			if (BookCaseServiceImpl.getInstance().findOne(user.getId()) == null) {
				BookCase bookCase = BookCaseServiceImpl.getInstance().insert(user);
				user.setBookCase(bookCase);
			}
			BookCase myBookCase = user.getBookCase();
			Book book = BookServiceImpl.getInstance().findByID(id);
			if (book != null) {
				if (!myBookCase.getListBook().contains(book)) {
					Integer containID = ContainServiceImpl.getInstance().insert(new Contain(myBookCase.getId(), id));
					if (containID != null) {
						System.out.println("Add successfully!");
					} else {
						System.out.println("Add failed!");
					}
				} else {
					System.out.println("Book already exist in the BookCase!");
				}
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Add failed!(id not exist)");
		}
		System.out.println();
	}

	/*
	 * Xóa 1 Book khỏi BookCase
	 */
	public static void removeBookFromBookCase(Scanner sc, User user) {
		BookCase myBookCase = user.getBookCase();
		if (myBookCase == null || myBookCase.getListBook().isEmpty()) {
			System.out.println("Your BookCase is empty!");
		} else {
			String idString;
			System.out.print("Please enter book's id: ");
			idString = sc.nextLine().trim();
			try {
				int id = Integer.parseInt(idString);
				Book book = myBookCase.getListBook().stream().filter(b -> b.getId() == id).findFirst().get();
				if (book != null) {
					Integer countRemove = ContainServiceImpl.getInstance().removeByBookCaseIDBookID(myBookCase.getId(),
							book.getId());
					if (countRemove != null) {
						System.out.println("Remove is successfully!");
					}
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("id not exist your BookCase!");
			}
		}
		System.out.println();
	}

	/*
	 * Làm sạch BookCase (làm trống)
	 */
	public static void clearBookCase(User user) {
		BookCase myBookCase = user.getBookCase();
		if (myBookCase != null && !myBookCase.getListBook().isEmpty()) {
			Integer countRemove = ContainServiceImpl.getInstance().removeByBookCaseID(myBookCase.getId());
			if (countRemove != null && countRemove >= 0) {
				System.out.println("Clear successfully!\nYour BookCase is empty!");
			}
		} else {
			System.out.println("Your BookCase is empty!");
		}
		System.out.println();
	}

	/*
	 * Cắt chuỗi để hỗ trợ hiển thị cho đẹp
	 */
	public static String subStringByMe(String s) {
		if (s.length() > 15)
			return s.substring(0, 12) + "...";
		else
			return s;
	}

	/*
	 * Hiển thị
	 */
	public static void showListBook(List<Book> listBook) {
		int n = listBook.size();
		System.out.println("About " + n + " results:");
		System.out.println("STT  id    Name                Author              Category"
				+ "            Brief               Tile                Publisher");
		for (int i = 0; i < n; i++) {
			int index = i + 1;
			Book b = listBook.get(i);
			System.out.println(String.format(
					"%2d  |%1d    |%-15s    |%-15s    |%-15s" + "    |%-15s    |%-15s    |%-15s", index, b.getId(),
					subStringByMe(b.getName()), subStringByMe(b.getAuthor()), subStringByMe(b.getCategory()),
					subStringByMe(b.getBrief()), subStringByMe(b.getTitle()), subStringByMe(b.getPublisher())));
		}
		System.out.println("\n");
	}
}
