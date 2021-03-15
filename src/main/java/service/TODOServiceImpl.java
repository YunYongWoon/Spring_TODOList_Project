package service;

import domain.TODOList;
import domain.User;
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
        if(todoList == null)
            throw new RuntimeException("리스트가 존재하지 않습니다!");
        todoMapper.Create(todoList);
    }

    //TodoList 조회
    @Override
    public List<TODOList> ReadList() {
        Long user_id = jwtUtil.getIdByToken();
        // 일정 지난게 있으면 알림
        todoMapper.checkScheduleTrue(user_id);
        // 일정 변경 후 false로 변경
        todoMapper.checkScheduleFalse(user_id);
        return todoMapper.Read(user_id);
    }

    //TodoList 수정
    @Override
    public void UpdateList(Long id, TODOList todoList) {
        if(id == null)
            throw new RuntimeException("해당 리스트의 id 정보 존재하지 않습니다.");
        else if(todoList == null)
            throw new RuntimeException("리스트가 입력되지 않았습니다.");
        else{
            todoList.setId(id);
            todoMapper.Update(todoList);
        }
    }

    //TodoList 삭제(Soft Delete)
    @Override
    public void DeleteList(Long id) {
       if(id == null)
           throw new RuntimeException("해당 리스트 정보가 존재하지 않습니다.");
       else
           todoMapper.Delete(id);
    }

    @Override
    public void AchieveList(Long id) {
        if(id == null)
            throw new RuntimeException("해당 리스트 정보가 존재하지 않습니다.");
        else
            todoMapper.Achieve(id);
    }

    @Override
    public List<TODOList> ReadArchieve() {
        Long user_id = jwtUtil.getIdByToken();
        if(user_id == null)
            throw new RuntimeException("해당 ID 정보가 존재하지 않습니다.");
        else
            return todoMapper.readArchieve(user_id);
    }
}
