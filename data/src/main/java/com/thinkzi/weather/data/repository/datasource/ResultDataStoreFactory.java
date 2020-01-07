package com.thinkzi.weather.data.repository.datasource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ResultDataStoreFactory {

    @Inject
    public ResultDataStoreFactory() {
    }

    public IResultDataStore createResultDataStore() {
        return new CloudResultDataStore();
    }

}
