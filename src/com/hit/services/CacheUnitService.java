
package com.hit.services;

import com.hit.algorithm.IalgoCache;
import com.hit.algorithm.LRUAlgoCacheImpl;
import com.hit.dao.DaoFileImpl;
import com.hit.dao.IDao;
import com.hit.dm.DataModel;
import com.hit.memory.CacheUnit;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class CacheUnitService<T>{
    CacheUnit<T> CU;
    public CacheUnitService() throws IOException, ClassNotFoundException {
        IalgoCache<Long, DataModel<T>> algo = new LRUAlgoCacheImpl<>(3);
        IDao<Long, DataModel<T>> dao = new DaoFileImpl<>("test.dat");
        CU = new CacheUnit(algo, dao);

    }
    public boolean update(DataModel<T>[] DMS) throws IOException,ClassNotFoundException {
        Long[] DMSIDS = new Long[DMS.length];
        Comparator<DataModel<T>> dataModelComparator = (o1, o2) -> (int) (o1.getDataModelId() - o2.getDataModelId());
        Arrays.sort(DMS, dataModelComparator);
        int q= 0;
        for(DataModel dataModel : DMS)
        {
            DMSIDS[q] = dataModel.getDataModelId();
            q++;
        }
        DataModel<T>[] dmRef = CU.getDataModels(DMSIDS);
        Arrays.sort(dmRef, dataModelComparator);

     //   for(q = 0 ; q < DMS.length;q++)
      //     dmRef[q].setContent(DMS[q].getContent());

        return true;
    }
    public boolean delete(DataModel<T>[] DMS) throws IOException, ClassNotFoundException {
        Long [] DMSIDS = new Long[DMS.length];
        int q = 0;
        for(DataModel dm : DMS)
        {
            DMSIDS[q] = dm.getDataModelId();
            q++;
        }
        DataModel<T>[] dmRef = CU.getDataModels(DMSIDS);
  //      for(q = 0 ; q < DMS.length;q++)
   //         dmRef[q].setContent(null);

        return true;
    }
    public DataModel<T>[] get(DataModel<T>[] DMS) throws IOException, ClassNotFoundException { //DMS
        Long [] DMSIDS = new Long[DMS.length];
        int i = 0;
        for(DataModel dm : DMS)
        {
            DMSIDS[i] = dm.getDataModelId();
            i++;
        }
        return (DataModel<T>[]) CU.getDataModels(DMSIDS);
    }
}
