package service;

import domain.TODOList;
import domain.User;

import java.util.List;

public interface TODOService {
    void CreateList(TODOList todoList);
    List<TODOList> ReadList();
    void UpdateList(TODOList todoList);
    void DeleteList(Long id);
    void AchieveList(Long id);
    List<TODOList> ReadArchieve();
}
