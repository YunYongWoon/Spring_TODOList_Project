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
    public void CreateList(TODOList todoList) {
        todoList.setUser_ID(jwtUtil.getIdByToken());

        if(todoList.getUser_ID() == null)
            throw new RuntimeException("ID is not exist");
        else if (todoList.getTodo() == null)
            throw new RuntimeException("TODO String is null");
        else if(todoList.getTodoType() == null)
            throw new RuntimeException("TODO Type is not choose");
        else
            todoMapper.Create(todoList);

    }

    //TodoList 조회
    @Override
    public List<TODOList> ReadList() {
        Long user_id = jwtUtil.getIdByToken();
        if(user_id == null)
            throw new RuntimeException("id is not exist");
        else {
            // 일정 지난게 있으면 알림
            todoMapper.checkScheduleTrue(user_id);
            // 일정 변경 후 false로 변경
            todoMapper.checkScheduleFalse(user_id);
            return todoMapper.Read(user_id);
        }
    }

    //TodoList 수정
    @Override
    public void UpdateList(TODOList todoList) {
        if(todoList.getId() == null)
            throw new RuntimeException("List ID is not exist");
        else if (todoList.getTodo() == null)
            throw new RuntimeException("TODO String is null");
        else if(todoList.getTodoType() == null)
            throw new RuntimeException("TODO Type is not choose");
        else{
            todoMapper.Update(todoList);
        }
    }

    //TodoList 삭제(Soft Delete)
    @Override
    public void DeleteList(Long id) {
        if(id == null)
            throw new RuntimeException("List ID is not exist");
        else
            todoMapper.Delete(id);
    }

    @Override
    public void AchieveList(Long id) {
        if(id == null)
            throw new RuntimeException("List ID is not exist");
        else
            todoMapper.Achieve(id);
    }

    @Override
    public List<TODOList> ReadArchieve() {
        Long user_id = jwtUtil.getIdByToken();
        if(user_id == null)
            throw new RuntimeException("ID is not exist");
        else
            return todoMapper.readArchieve(user_id);
    }
}
