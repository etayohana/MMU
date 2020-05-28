package com.hit.memory;

import com.hit.algorithm.IalgoCache;
import com.hit.dao.IDao;
import com.hit.dm.DataModel;

import java.util.ArrayList;
import java.util.List;

public class CacheUnit<T>
{
    IalgoCache<java.lang.Long,DataModel<T>> algo;
    IDao<java.io.Serializable,DataModel<T>> dao;

    public CacheUnit(IalgoCache<java.lang.Long, DataModel<T>> algo,
                     IDao<java.io.Serializable, DataModel<T>> dao)
    {
        this.algo = algo;
        this.dao = dao;
    }

    public DataModel<T>[] getDataModels(java.lang.Long[] ids)
            throws java.lang.ClassNotFoundException,
            java.io.IOException
    {
        DataModel<T> temp_DM;
        List<Long> PageError = new ArrayList<Long>();
        List<DataModel<T>> DMsToReturn = new ArrayList<DataModel<T>>();
        List<DataModel<T>> DMsFromCache = new ArrayList<DataModel<T>>();
        List<DataModel<T>> DMsToHandle = new ArrayList<DataModel<T>>();

        for(Long id : ids)  //look for DMs in cache
        {
            temp_DM = (DataModel<T>) algo.getElement(id);
            if(temp_DM==null)  //DM not in cache
                PageError.add(id);
            else
                DMsToReturn.add(temp_DM);
        }

        for(Long id : PageError) //take unfound DM's from Hard drive
            if(id != null)
            {
                DMsToHandle.add((DataModel<T>) dao.find(id));

            }

        for(DataModel dm : DMsToHandle) //add dms from cache and hard drive to one array
        {
            if (dm != null)
            {
                DMsToReturn.add(dm); //add Dms to the user
                DMsFromCache.add((DataModel<T>) algo.putElement(dm.getDataModelId(), dm));
                //if cache is full he returns dms that needs to be sent to hard drive
            }
        }

        for(DataModel dm : DMsFromCache)
            if(dm != null)
                dao.Save((DataModel<T>)dm);


        return DMsToReturn.toArray(new DataModel[0]);
    }


}