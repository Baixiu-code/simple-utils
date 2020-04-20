package com.craftsman.sample.domain.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainEvent implements Serializable {

    private static final long serialVersionUID = 9000488318777569980L;

    private Long eventId;

    private String eventAction;

    private String eventActionCode;

}
