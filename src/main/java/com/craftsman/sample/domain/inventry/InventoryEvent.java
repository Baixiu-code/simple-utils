package com.craftsman.sample.domain.inventry;

import com.craftsman.sample.domain.common.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryEvent extends DomainEvent {

    private Integer inventoryNum;

    private Integer userId;

}
