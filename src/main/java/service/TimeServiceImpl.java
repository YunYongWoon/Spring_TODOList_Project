package service;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class TimeServiceImpl implements TimeService{
    @Override
    public Timestamp CheckTime() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp;
    }
}
