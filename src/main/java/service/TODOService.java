package service;

import domain.TODOList;
import domain.User;

import java.util.List;

public interface TODOService {
    boolean CreateList(TODOList todoList);
    List<TODOList> ReadList(Long id);
    boolean UpdateList(Long id);
    boolean DeleteList(Long id);
}
