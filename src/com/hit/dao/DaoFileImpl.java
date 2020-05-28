package com.hit.dao;
import com.hit.dm.DataModel;

import java.io.*;
import java.util.HashMap;

public class DaoFileImpl<T> implements IDao <Long ,DataModel<T>>
{
    HashMap<Long, DataModel<T>> map = new HashMap<Long, DataModel<T>>();
    String filePath;


    public DaoFileImpl(String filePath) throws IOException, ClassNotFoundException {

        this.filePath = filePath;
        File file = new File(filePath);
        FileInputStream f = new FileInputStream(file);
        ObjectInputStream s = new ObjectInputStream(f);
        map = (HashMap<Long, DataModel<T>>)s.readObject();
        s.close();
    }

    public void update() throws IOException {
        File file=new File(filePath);
        FileOutputStream fos=new FileOutputStream(file);
        ObjectOutputStream oos=new ObjectOutputStream(fos);

        oos.writeObject(map);
        oos.flush();
        oos.close();
        fos.close();
    }

    @Override
    public void delete(DataModel<T> entity) throws IOException {
        map.remove(entity.getDataModelId());
        this.update();
    }

    @Override
    public DataModel<T> find(Long id)
    {
        return map.containsKey(id) ? new DataModel<T>(id,map.get(id).getContent()) : null;
    }

    @Override
    public void Save(DataModel<T> entity) throws IOException {
        map.put(entity.getDataModelId(),entity);
        this.update();
    }
}