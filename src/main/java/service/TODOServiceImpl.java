package service;

import domain.TODOList;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TODOMapper;
import repository.UserMapper;

@Service
public class TODOServiceImpl implements TODOService {
    @Autowired
    private TODOMapper todoMapper;

    @Override
    public boolean CreateList(TODOList todoList) {
        return todoMapper.Create(todoList) == true;
    }

    @Override
    public boolean ReadList(User user) {
        return false;
    }

    @Override
    public boolean UpdateList() {
        return false;
    }

    @Override
    public boolean DeleteList() {
        return false;
    }
}
