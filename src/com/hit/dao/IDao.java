package com.hit.dao;

import java.io.IOException;
import java.io.Serializable;

public interface IDao<ID extends Serializable , T> {

    void delete (T entity) throws IOException;
    T find (ID id);
    void Save (T entity) throws IOException;
}