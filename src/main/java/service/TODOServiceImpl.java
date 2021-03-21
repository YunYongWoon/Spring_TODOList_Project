package service;

import domain.ArchiveList;
import domain.TODOList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TODOMapper;
import util.DateUtil;
import util.JwtUtil;

import java.util.List;

@Service
public class TODOServiceImpl implements TODOService {
    @Autowired
    private TODOMapper todoMapper;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private DateUtil dateUtil;

    //TodoList 생성
    @Override
    public void CreateList(TODOList todoList) {
        if(todoList == null)
            throw new RuntimeException("리스트가 존재하지 않습니다!");

        todoList.setUser_ID(jwtUtil.getIdByToken());
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
            throw new RuntimeException("id 정보가 입력되지 않았습니다.");

        if(todoList == null)
            throw new RuntimeException("리스트가 입력되지 않았습니다.");

        if(checkList(id) == null)
            throw new RuntimeException("해당 리스트의 id 정보 존재하지 않습니다.");

        todoList.setId(id);
        todoMapper.Update(todoList);
    }

    //TodoList 삭제(Soft Delete)
    @Override
    public void DeleteList(Long id) {
       if(id == null)
           throw new RuntimeException("id 정보가 입력되지 않았습니다.");

       todoMapper.Delete(id);
    }

    @Override
    public void ArchiveList(Long id) {
        if(id == null)
            throw new RuntimeException("id 정보가 입력되지 않았습니다.");

        if(checkListDeleted(id))
            throw new RuntimeException("삭제되거나 아카이브된 리스트는 아카이브가 불가능합니다.");

        TODOList list = ReadArchive(id);

        ArchiveList archiveList = new ArchiveList();
        archiveList.setTodo(list.getTodo());
        archiveList.setTodoType(list.getTodoType());
        archiveList.setUser_ID(list.getUser_ID());
        if(list.getScheduled_at() != null)
            archiveList.setScheduled_at(dateUtil.DateToTimestamp(list.getScheduled_at()));

        todoMapper.Archive(archiveList);
        todoMapper.deleteArchive(id);
    }

    public TODOList ReadArchive(Long id) {
        if(id == null)
            throw new RuntimeException("id 정보가 입력되지 않았습니다.");

        return todoMapper.readArchive(id);
    }

    public TODOList checkList(Long id){
        if(id == null)
            throw new RuntimeException("id 정보가 입력되지 않았습니다.");

        return todoMapper.checkList(id);
    }

    public boolean checkListDeleted(Long id) {
        if (id == null)
            throw new RuntimeException("id 정보가 입력되지 않았습니다.");

        TODOList checkList = todoMapper.checkListDeleted(id);
        if (checkList.isIs_deleted() || checkList.isIs_archived())
            return true;
        else
            return false;
    }
}
