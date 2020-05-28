package com.hit.memory;

import com.hit.algorithm.IalgoCache;
import com.hit.algorithm.LRUAlgoCacheImpl;
import com.hit.dao.DaoFileImpl;
import com.hit.dao.IDao;
import com.hit.dm.DataModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

class CacheUnitTest {

   // @org.junit.jupiter.api.Test
    void getDataModels()throws IOException, ClassNotFoundException
    {
        HashMap<Long,DataModel<String>> map = new HashMap<Long, DataModel<String>>();
        DataModel dm1 = new DataModel((long)1,'A');
        map.put((long)1,dm1);
        DataModel dm2 = new DataModel((long)2,'B');
        map.put((long)2,dm2);
        DataModel dm3 = new DataModel((long)3,'C');
        map.put((long)3,dm3);
        DataModel dm4 = new DataModel((long)4,'D');
        map.put((long)4,dm4);
        DataModel dm5 = new DataModel((long)5,'E');
        map.put((long)5,dm5);
        DataModel dm6 = new DataModel((long)6,'F');
        map.put((long)6,dm6);
        DataModel dm7 = new DataModel((long)7,'G');
        map.put((long)7,dm7);

        File file=new File("test.dat");
        FileOutputStream fos=new FileOutputStream(file);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(map);
        oos.flush();
        oos.close();
        fos.close();

        IalgoCache <Long,String> algo = null;
        algo = new LRUAlgoCacheImpl<Long,String>(3);
        IDao dao = null;
        dao = new DaoFileImpl<String>("Test.dat");

        CacheUnit<String> CU = new CacheUnit(algo,dao);
        Long[] ids = new Long[]{(long) 3,(long) 5,(long) 2};
        DataModel[] DMs = CU.getDataModels(ids);


        assertEquals('E',DMs[1].getContent());


    }
}