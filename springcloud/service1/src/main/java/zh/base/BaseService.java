package zh.base;

import java.util.List;

public interface BaseService<T> {

    List<T> query(T t);

    T queryById(String id);

    boolean add(T t);

    boolean batchAdd(T t);

    boolean update(T t);

    boolean delete(T t);

    long count(T t);
}
