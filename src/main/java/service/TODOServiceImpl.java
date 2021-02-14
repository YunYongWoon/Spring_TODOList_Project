package service;

import domain.TODOList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TODOMapper;

import java.util.List;

@Service
public class TODOServiceImpl implements TODOService {
    @Autowired
    private TODOMapper todoMapper;

    @Override
    public boolean CreateList(TODOList todoList) {
        return todoMapper.Create(todoList) == true;
    }

    @Override
    public List<TODOList> ReadList(Long id) {
        return todoMapper.Read(id);
    }

    @Override
    public boolean UpdateList(Long id) {
        return false;
    }

    @Override
    public boolean DeleteList(Long id) {
        return todoMapper.Delete(id) == true;
    }
}
