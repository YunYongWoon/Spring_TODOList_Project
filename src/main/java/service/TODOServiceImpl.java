package service;

import domain.TODOList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TODOMapper;
import util.JwtUtil;
import util.TimeUtil;

import java.util.List;

@Service
public class TODOServiceImpl implements TODOService {
    @Autowired
    private TODOMapper todoMapper;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private TimeUtil timeUtil;

    @Override
    public boolean CreateList(TODOList todoList,String schedule) {
        todoList.setUser_ID(jwtUtil.getIdByToken());
        todoList.setScheduled_at(timeUtil.getStringToTimestamp(schedule));
        return todoMapper.Create(todoList) == true;
    }

    @Override
    public List<TODOList> ReadList(Long id) {
        id = jwtUtil.getIdByToken();
        return todoMapper.Read(id);
    }

    @Override
    public boolean UpdateList(TODOList todoList) {
        return todoMapper.Update(todoList) == true;
    }

    @Override
    public boolean DeleteList(Long idx) {
        return todoMapper.Delete(idx) == true;
    }
}
