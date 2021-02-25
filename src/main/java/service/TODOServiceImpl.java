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
        if(todoList == null || todoList.getScheduled_at() == null) {
            return false;
        }
        else
            return todoMapper.Create(todoList) == true;
    }

    @Override
    public List<TODOList> ReadList(Long user_id) {
        user_id = jwtUtil.getIdByToken();
        todoMapper.checkSchedule(user_id);
        return todoMapper.Read(user_id);
    }

    @Override
    public boolean UpdateList(TODOList todoList, String schedule) {
        if(todoList == null)
            return false;
        else
            return todoMapper.Update(todoList) == true;
    }

    @Override
    public boolean DeleteList(Long id) {
        return todoMapper.Delete(id) == true;
    }

    @Override
    public boolean AchieveList(Long id) {
        return todoMapper.Achieve(id) == true;
    }

    @Override
    public List<TODOList> ReadArchieve(Long user_id) {
        user_id = jwtUtil.getIdByToken();
        return todoMapper.readArchieve(user_id);
    }
}
