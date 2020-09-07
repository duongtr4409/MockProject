package com.duongnv30.mock_v1.main.admin.service.impl;

import java.util.List;
import java.util.Scanner;

import com.duongnv30.mock_v1.main.admin.service.AdminRoleService;
import com.duongnv30.mock_v1.main.user.service.impl.UserRoleServiceImpl;
import com.duongnv30.mock_v1.model.Book;
import com.duongnv30.mock_v1.service.impl.BookServiceImpl;

public class AdminRoleServiceImpl implements AdminRoleService {

	/*
	 * Thêm Book mới
	 */
	@Override
	public void createBook(Scanner sc) {
		String bookName, bookTitle, author, brief, publisher, content, category;
		System.out.println("Please enter the number(Press '0.exit' to exit function): ");
		do {
			System.out.println("1. Enter the name: ");
			bookName = sc.nextLine().trim();
			if (bookName.isEmpty())
				System.out.println("name must not empty!");
			if ("0.exit".equalsIgnoreCase(bookName)) return;
		} while (bookName.isEmpty());

		do {
			System.out.println("2. Enter the author: ");
			author = sc.nextLine().trim();
			if (author.isEmpty())
				System.out.println("author must not empty!");
			if ("0.exit".equalsIgnoreCase(author)) return;
		} while (author.isEmpty());

		do {
			System.out.println("3. Enter the category: ");
			category = sc.nextLine().trim();
			if (category.isEmpty())
				System.out.println("category  must not empty!");
			if ("0.exit".equalsIgnoreCase(category)) return;
		} while (category.isEmpty());

		do {
			System.out.println("4. Enter the brief: ");
			brief = sc.nextLine().trim();
			if (brief.isEmpty())
				System.out.println("brief must not empty!");
			if ("0.exit".equalsIgnoreCase(brief)) return;
		} while (brief.isEmpty());

		do {
			System.out.println("5. Enter the title: ");
			bookTitle = sc.nextLine().trim();
			if (bookTitle.isEmpty())
				System.out.println("title must not empty!");
			if ("0.exit".equalsIgnoreCase(bookTitle)) return;
		} while (bookTitle.isEmpty());

		do {
			System.out.println("6. Enter the publisher: ");
			publisher = sc.nextLine().trim();
			if (publisher.isEmpty())
				System.out.println("publisher must not empty!");
			if ("0.exit".equalsIgnoreCase(publisher)) return;
		} while (publisher.isEmpty());

		do {
			System.out.println("7. Enter the content: ");
			content = sc.nextLine().trim();
			if (content.isEmpty())
				System.out.println("content must not empty!");
			if ("0.exit".equalsIgnoreCase(content)) return;
		} while (content.isEmpty());

		Book book = new Book(bookName, bookTitle, author, brief, publisher, content, category);
		Integer idInsert = BookServiceImpl.getInstance().insert(book);
		if (idInsert != null && idInsert > 0) {
			System.out.println("book successfully created!\n");
		} else {
			System.out.println("book fail created!\n");
		}
	}

	/*
	 * Xóa Book
	 */
	@Override
	public void deleteBook(Scanner sc) {
		Book book = choiceBookToDeleteOrUpdate(sc);
		if (book != null) {
			Integer countRemove = BookServiceImpl.getInstance().deleteByID(book.getId());
			if (countRemove != null) {
				System.out.println("book successfully deleted!");
			} else {
				System.out.println("Delete faid!");
			}
		} else {
			System.out.println("Delete faid!(id not exitst)");
		}
	}

	/*
	 * Thay đổi Content của Book
	 */
	@Override
	public void updateContentBook(Scanner sc) {
		Book book = choiceBookToDeleteOrUpdate(sc);
		if (book != null) {
			String content;
			System.out.println("Please enter new book's content: ");
			content = sc.nextLine().trim();
			if (!content.isEmpty()) {
				Integer countUpdate = BookServiceImpl.getInstance().updateBookByID(book.getId(), content);
				if (countUpdate != null) {
					System.out.println("book successfully updated!");
				} else {
					System.out.println("book fail updated!");
				}
			} else {
				System.out.println("Content not be empty!");
			}
		} else {
			System.out.println("Delete faid!(id not exitst)");
		}
		System.out.println();
	}

	/*
	 * Hỗ trợ cho Xóa và Update Book
	 */
	public static Book choiceBookToDeleteOrUpdate(Scanner sc) {
		String idString;
		// Lấy danh sách Book đang có trong hệ thống
		List<Book> listBook = BookServiceImpl.getInstance().findAll();
		System.out.println("\t\t----List Book of application----\n");
		UserRoleServiceImpl.showListBook(listBook);
		System.out.print(">>Please enter book's id: ");
		idString = sc.nextLine().trim();
		try {
			int id = Integer.parseInt(idString);
			// tìm Book có id tương ứng trong listBook
			Book book = listBook.stream().filter(b -> b.getId() == id).findFirst().get();
			return book;
		} catch (Exception e) {
			return null;
		}
	}
}
