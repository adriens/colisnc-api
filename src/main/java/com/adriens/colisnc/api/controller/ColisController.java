/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.colisnc.api.controller;

import com.adriens.colisnc.api.model.StepsCounter;
import com.adriens.colisnc.api.service.ColisService;
import com.adriens.github.colisnc.colisnc.ColisDataRow;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author 3004SAL
 */
@RestController
public class ColisController {
    @Autowired
    private ColisService colisService;
    
    private final Logger log = LoggerFactory.getLogger(ColisController.class);
    
    @GetMapping("/colis/{itemId}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<ColisDataRow> getColisRows(@PathVariable String itemId) throws Exception {
        try{
            return colisService.getColisRows(itemId);
        }
        catch(Exception ex){
            log.error("Impossible de récupérer les détails du colis <"+ itemId + ">");
            throw ex;
        }
    }
    
    @GetMapping("/colis/{itemId}/latest")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ColisDataRow getLatest(@PathVariable String itemId) throws Exception {
        try{
            return colisService.getLatestRow(itemId);
        }
        catch(Exception ex){
            log.error("Impossible de récupérer les derniers détails du colis <"+ itemId + ">");
            throw ex;
        }
    }
    
    @GetMapping("/colis/{itemId}/count")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public StepsCounter getNbSteps(@PathVariable String itemId) throws Exception {
        try{
            return colisService.getNbSteps(itemId);
        }
        catch(Exception ex){
            log.error("Impossible de récupérer les derniers détails du colis <"+ itemId + ">");
            throw ex;
        }
    }

    @PostMapping("/colis/list/latest")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ArrayList<ColisDataRow> getLastStatusFromColisList(@RequestBody List<String> itemsId) throws Exception {
        try{
            return colisService.getLatestStatusForColisList(itemsId);
        }
        catch(Exception ex){
            log.error("Impossible de récupérer les derniers états pour les colis de la liste : <"+ itemsId.toString() + ">");
            throw ex;
        }
    }
    

}
