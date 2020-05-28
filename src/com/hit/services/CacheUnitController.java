package com.hit.services;

import com.hit.dm.DataModel;

import java.io.IOException;

public class CacheUnitController<T> {
    CacheUnitService<T> CUS = new CacheUnitService<T>();

    public CacheUnitController() throws IOException, ClassNotFoundException {
    }

    public boolean update(DataModel<T>[] dataModels) throws IOException, ClassNotFoundException {
        return CUS.update(dataModels);
    }

    public boolean delete(DataModel<T>[] dataModels) throws IOException, ClassNotFoundException {
        return CUS.delete(dataModels);
    }

    public DataModel<T>[] get(com.hit.dm.DataModel<T>[] dataModels) throws IOException, ClassNotFoundException {
        return CUS.get(dataModels);
    }
}
