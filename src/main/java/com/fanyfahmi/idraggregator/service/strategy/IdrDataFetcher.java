package com.fanyfahmi.idraggregator.service.strategy;

public interface IdrDataFetcher {
    String getResourceType();

    Object getCachedData();
}
