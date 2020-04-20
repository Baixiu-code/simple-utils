package com.craftsman.sample.domain.inventry;

import com.craftsman.sample.domain.common.DomainDispatch;
import com.craftsman.sample.domain.common.DomainEvent;

public class InventoryDomainObject {

    private Integer inventoryNum;

    private Boolean minusInventoryNum(InventoryEvent event){
        inventoryNum=inventoryNum-event.getInventoryNum();
        recordLog(event);
        return true;
    }

    private Boolean plusInventoryNum(InventoryEvent event){
        inventoryNum=inventoryNum+event.getInventoryNum();
        recordLog(event);
        return true;
    }

    private void recordLog(DomainEvent event){
        DomainDispatch.sendEvent(event);
    }
}
