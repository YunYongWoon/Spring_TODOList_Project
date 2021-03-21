package service;

import domain.ArchiveList;

import java.util.List;

public interface ArchiveService {
    List<ArchiveList> ReadList(Long currentPage);
}
