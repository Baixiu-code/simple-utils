package com.craftsman.util.scheduler;

import java.util.Map;

/**
 * Created by frog.w on 2017/3/4.
 */
public interface Task {
    void doTask(Map<Object, Object> param);
}
