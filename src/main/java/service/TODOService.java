package service;

import domain.TODOList;
import domain.User;

public interface TODOService {
    boolean CreateList(TODOList todoList);
    boolean ReadList(User user);
    boolean UpdateList();
    boolean DeleteList();
}
