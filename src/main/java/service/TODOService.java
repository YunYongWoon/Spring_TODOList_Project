package service;

import domain.TODOList;
import domain.User;

import java.util.List;

public interface TODOService {
    boolean CreateList(TODOList todoList);
    List<TODOList> ReadList();
    boolean UpdateList(TODOList todoList);
    boolean DeleteList(Long id);
    boolean AchieveList(Long id);
    List<TODOList> ReadArchieve();
}
