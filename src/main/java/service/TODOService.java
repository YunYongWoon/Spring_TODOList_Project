package service;

import domain.TODOList;
import domain.User;

import java.util.List;

public interface TODOService {
    boolean CreateList(TODOList todoList, String schedule);
    List<TODOList> ReadList(Long user_ID);
    boolean UpdateList(TODOList todoList, String schedule);
    boolean DeleteList(Long id);
    boolean AchieveList(Long id);
    List<TODOList> ReadArchieve(Long user_Id);
}
