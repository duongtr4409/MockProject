package com.duongnv30.mock_v1.utils.authority;

import java.util.ArrayList;
import java.util.List;

import com.duongnv30.mock_v1.model.User;
import com.duongnv30.mock_v1.utils.constant.SystemConstant;

public class CheckAuthority {
	private static List<String> listUserAction;
	private static List<String> listAdminAction;
	
	
	public CheckAuthority() {
		if(listUserAction == null) {
			listUserAction = new ArrayList<>();
			listUserAction.add(SystemConstant.USER_EDIT_BOOKCASE);
			listUserAction.add(SystemConstant.USER_READ_BOOK);
			listUserAction.add(SystemConstant.USER_SEARCH_BOOK);
			listUserAction.add(SystemConstant.USER_VIEW_BOOKCASE);
			listUserAction.add(SystemConstant.USER_VIEW_LIST_BOOK);
			listUserAction.add(SystemConstant.USER_LOGOUT);
		}
		if(listAdminAction == null) {
			listAdminAction.add(SystemConstant.ADMIN_CREATE_BOOK);
			listAdminAction.add(SystemConstant.ADMIN_UPDATE_CONTENT_BOOK);
			listAdminAction.add(SystemConstant.ADMIN_DELETE_BOOK);
			listAdminAction.add(SystemConstant.ADMIN_LOGOUT);
		}
	}

	public static boolean check(User user, String action) {
		new CheckAuthority();
		if(user.getRoles().get(0).getAuthority().equals(SystemConstant.USER)) {
			return listUserAction.contains(action);
		}else if(user.getRoles().get(0).getAuthority().equals(SystemConstant.ADMIN)) {
			return listAdminAction.contains(action);
		}
		return false;
	}
}
