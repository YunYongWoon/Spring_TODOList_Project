package service;

import domain.ArchieveList;

import java.util.List;

public interface ArchieveService {
    List<ArchieveList> ReadList(int currentPage);
}
