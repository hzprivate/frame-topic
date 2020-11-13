package dao;

import org.springframework.stereotype.Component;

/**
 * @author hz
 * @create 2020-11-11
 */
@Component
public class QueryDao {
    public String[] query(){
        String[] strings = {"1", "2", "3"};
        return strings;
    }
}
