package ibatis.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by qiao on 2015/9/6.
 */
public interface BaseDao<T> {
    List<T> query(Map<String, Object> param);

    int save(T t);

    int update(T t);

    T get(Long id);
}
