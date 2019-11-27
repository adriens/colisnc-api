/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.colisnc.api.service;

import com.adriens.colisnc.api.model.StepsCounter;
import com.adriens.github.colisnc.colisnc.ColisCrawler;
import com.adriens.github.colisnc.colisnc.ColisDataRow;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author 3004SAL
 */

@Service
public class ColisService {
    private final Logger log = LoggerFactory.getLogger(ColisService.class);
    //private ColisCrawler wrap;
    
    public List<ColisDataRow> getColisRows(String itemId) throws Exception {
        ArrayList<ColisDataRow> out;
        out = ColisCrawler.getColisRows(itemId);
        return out;
    }
    
    public ColisDataRow getLatestRow(String itemId) throws Exception {
        return ColisCrawler.getLatest(itemId);
    }
    public ColisDataRow getOldestRow(String itemId) throws Exception {
        return ColisCrawler.getOldest(itemId);
    }
    
    public StepsCounter getNbSteps(String itemId) throws Exception {
        return new StepsCounter(ColisCrawler.getColisRows(itemId).size());
    }

    public ArrayList<ColisDataRow> getLatestStatusForColisList(List<String> itemsId) throws Exception {
        return ColisCrawler.getLatestStatusForColisList(itemsId);
    }

}
