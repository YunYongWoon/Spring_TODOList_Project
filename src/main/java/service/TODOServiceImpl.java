package service;

import domain.TODOList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TODOMapper;
import util.JwtUtil;

import java.util.List;

@Service
public class TODOServiceImpl implements TODOService {
    @Autowired
    private TODOMapper todoMapper;
    @Autowired
    private JwtUtil jwtUtil;

    //TodoList 생성
    @Override
    public boolean CreateList(TODOList todoList) {
        todoList.setUser_ID(jwtUtil.getIdByToken());

        if(todoList.getUser_ID() == null || todoList.getTodo() == null || todoList.getTodoType() == null) {
            return false;
        }
        else {
            todoMapper.Create(todoList);
            return true;
        }
    }

    //TodoList 조회
    @Override
    public List<TODOList> ReadList() {
        Long user_id = jwtUtil.getIdByToken();
        if(user_id != null) {
            // 일정 지난게 있으면 알림
            todoMapper.checkScheduleTrue(user_id);
            // 일정 변경 후 false로 변경
            todoMapper.checkScheduleFalse(user_id);
            return todoMapper.Read(user_id);
        }
        else
            return null;
    }

    //TodoList 수정
    @Override
    public boolean UpdateList(TODOList todoList) {
        if(todoList.getId() == null || todoList.getTodo() == null || todoList.getTodoType() == null)
            return false;
        else{
            todoMapper.Update(todoList);
            return true;
        }
    }

    //TodoList 삭제(Soft Delete)
    @Override
    public boolean DeleteList(Long id) {
        if(id != null) {
            todoMapper.Delete(id);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean AchieveList(Long id) {
        if(id != null) {
            todoMapper.Achieve(id);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public List<TODOList> ReadArchieve() {
        Long user_id = jwtUtil.getIdByToken();
        if(user_id == null)
            return null;
        else
            return todoMapper.readArchieve(user_id);
    }
}
