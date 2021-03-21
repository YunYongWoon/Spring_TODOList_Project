package util;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class DateUtil {
    public Timestamp DateToTimestamp(Date date){
        Timestamp ts = new Timestamp(date.getTime());
        return ts;
    }
}
