package com.duongnv30.mock_v1.main.admin;

import java.util.Scanner;

import com.duongnv30.mock_v1.main.admin.service.AdminRoleService;
import com.duongnv30.mock_v1.main.admin.service.impl.AdminRoleServiceImpl;
import com.duongnv30.mock_v1.model.User;
import com.duongnv30.mock_v1.utils.constant.SystemConstant;

public class HomeOfAdmin {

	public static void homeOfAdmin(Scanner sc, User user) {
		String choice;
		AdminRoleService adminService = new AdminRoleServiceImpl();
		do {
			menu(user.getUserName());
			choice = sc.nextLine().trim();
			switch (choice) {
			case SystemConstant.ADMIN_CREATE_BOOK:
				System.out.println("\n\t\t----Create Book----\t\t\n");
				adminService.createBook(sc);
				System.out.println("\n\t\t    -----------    \t\t\n");
				break;
				
			case SystemConstant.ADMIN_DELETE_BOOK:
				System.out.println("\n\t\t----Delete Book----\t\t\n");
				adminService.deleteBook(sc);
				System.out.println("\n\t\t    -----------    \t\t\n");
				break;

			case SystemConstant.ADMIN_UPDATE_CONTENT_BOOK:
				System.out.println("\n\t\t----Update Content Book----\t\t\n");
				adminService.updateContentBook(sc);
				System.out.println("\n\t\t    -------------------    \t\t\n");
				break;

			case SystemConstant.ADMIN_LOGOUT:
				user = null;
				System.out.println("Logout done!\n\n");
				return;
			default:
				System.out.println("Choice invalid!");
				break;
			}
		} while (true);
	}

	public static void menu(String userName) {
		System.out.println(
				"Hello " + userName + ", Please select a function " + "bellow by entering the corresp onding number.");
		System.out.println("1. Create Book\n2. Update Content Book\n3. Delete Book");
		System.out.println("4. Logout");
	}
	
//	/*
//	 * Thêm Book mới
//	 */
//	public static void createBook(Scanner sc) {
//		String bookName, bookTitle, author, brief, publisher, content, category;
//		System.out.println("Please enter the number(Press '0.eixt' to exit function): ");
//		do {
//			System.out.println("1. Enter the name: ");
//			bookName = sc.nextLine().trim();
//			if(bookName.isEmpty()) System.out.println("name must not empty!");
//			if("0.eixt".equalsIgnoreCase(bookName));
//		} while (bookName.isEmpty());
//		
//		do {
//			System.out.println("2. Enter the author: ");
//			author = sc.nextLine().trim();
//			if(author.isEmpty()) System.out.println("author must not empty!");
//			if("0.eixt".equalsIgnoreCase(author));
//		} while (author.isEmpty());
//		
//		do {
//			System.out.println("3. Enter the category: ");
//			category = sc.nextLine().trim();
//			if(category.isEmpty()) System.out.println("category  must not empty!");
//			if("0.eixt".equalsIgnoreCase(category));
//		} while (category.isEmpty());
//		
//		do {
//			System.out.println("4. Enter the brief: ");
//			brief = sc.nextLine().trim();
//			if(brief.isEmpty()) System.out.println("brief must not empty!");
//			if("0.eixt".equalsIgnoreCase(brief));
//		} while (brief.isEmpty());
//		
//		do {
//			System.out.println("5. Enter the title: ");
//			bookTitle = sc.nextLine().trim();
//			if(bookTitle.isEmpty()) System.out.println("title must not empty!");
//			if("0.eixt".equalsIgnoreCase(bookTitle));
//		} while (bookTitle.isEmpty());
//		
//		do {
//			System.out.println("6. Enter the publisher: ");
//			publisher = sc.nextLine().trim();
//			if(publisher.isEmpty()) System.out.println("publisher must not empty!");
//			if("0.eixt".equalsIgnoreCase(publisher));
//		} while (publisher.isEmpty());
//		
//		do {
//			System.out.println("7. Enter the content: ");
//			content = sc.nextLine().trim();
//			if(content.isEmpty()) System.out.println("content must not empty!");
//			if("0.eixt".equalsIgnoreCase(content));
//		} while (content.isEmpty());
//		
//		Book book = new Book(bookName, bookTitle, author, brief, publisher, content, category);
//		Integer idInsert = BookServiceImpl.getInstance().insert(book);
//		if(idInsert != null && idInsert > 0) {
//			System.out.println("book successfully created!\n");
//		}else {
//			System.out.println("book fail created!\n");
//		}
//	}
//
////	public static void deleteBook(Scanner sc) {
////		String idString;
////		// Lấy danh sách Book đang có trong hệ thống
////		List<Book> listBook = BookServiceImpl.getInstance().findAll();
////		System.out.println("\t\t----List Book of application----\n");
////		HomeOfUser.showListBook(listBook);
////		System.out.print(">>Please enter book's id: ");
////		idString = sc.nextLine().trim();
////		try {
////			int id = Integer.parseInt(idString);
////			// tìm Book có id tương ứng trong listBook
////			Book book = listBook.stream().filter(b -> b.getId() == id).findFirst().get();
////			if (book != null) {
////				Integer countRemove = BookServiceImpl.getInstance().deleteByID(book.getId());
////				if (countRemove != null) {
////					System.out.println("book successfully deleted!");
////				} else {
////					System.out.println("Delete faid!");
////				}
////			} else { // không có Book với id đã nhập thì tạo ra Exception để in ra thông báo
////				throw new Exception();
////			}
////		} catch (Exception e) {
////			System.out.println("Delete faid!(id not exitst)");
////		}
////		System.out.println();
////	}
//	
//	/*
//	 * Xóa Book
//	 */
//	public static void deleteBook(Scanner sc) {
//		Book book = choiceBookToDeleteOrUpdate(sc);
//		if(book != null) {
//			Integer countRemove = BookServiceImpl.getInstance().deleteByID(book.getId());
//			if (countRemove != null) {
//				System.out.println("book successfully deleted!");
//			} else {
//				System.out.println("Delete faid!");
//			}
//		}else {
//			System.out.println("Delete faid!(id not exitst)");
//		}
//	}
//	
//	/*
//	 * Thay đổi Content của Book
//	 */
//	public static void updateContentBook(Scanner sc) {
//		Book book = choiceBookToDeleteOrUpdate(sc);
//		if(book != null) {
//			String content;
//			System.out.println("Please enter new book's content: ");
//			content = sc.nextLine().trim();
//			if(!content.isEmpty()) {
//				Integer countUpdate = BookServiceImpl.getInstance().updateBookByID(book.getId(), content);
//				if(countUpdate != null) {
//					System.out.println("book successfully updated!");
//				}else {
//					System.out.println("book fail updated!");
//				}
//			}else {
//				System.out.println("Content not be empty!");
//			}
//		}else {
//			System.out.println("Delete faid!(id not exitst)");
//		}
//		System.out.println();
//	}
//
//	/*
//	 * Hỗ trợ cho Xóa và Update Book
//	 */
//	public static Book choiceBookToDeleteOrUpdate(Scanner sc) {
//		String idString;
//		// Lấy danh sách Book đang có trong hệ thống
//		List<Book> listBook = BookServiceImpl.getInstance().findAll();
//		System.out.println("\t\t----List Book of application----\n");
//		HomeOfUser.showListBook(listBook);
//		System.out.print(">>Please enter book's id: ");
//		idString = sc.nextLine().trim();
//		try {
//			int id = Integer.parseInt(idString);
//			// tìm Book có id tương ứng trong listBook
//			Book book = listBook.stream().filter(b -> b.getId() == id).findFirst().get();
//			return book;
//		} catch (Exception e) {
//			return null;
//		}
//	}
}


