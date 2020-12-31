package com.hz.subject;

import com.hz.observice.Human;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hz
 * @create 2020-12-30
 */
public interface HMovie {
     List<Human> humanList = new ArrayList<>();
     void addObserve(Human human);
     void removeObserve(Human human);
     void play();
}
