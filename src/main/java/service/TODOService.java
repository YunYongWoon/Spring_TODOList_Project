package service;

import domain.TODOList;
import domain.User;

import java.util.List;

public interface TODOService {
    boolean CreateList(TODOList todoList, String schedule);
    List<TODOList> ReadList(Long id);
    boolean UpdateList(TODOList todoList, String schedule);
    boolean DeleteList(Long id);
}
