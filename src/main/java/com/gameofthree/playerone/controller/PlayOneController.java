package com.gameofthree.playerone.controller;

import com.gameofthree.playerone.model.Result;
import com.gameofthree.playerone.service.PlayerOneService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayOneController {
    private static final Logger logger = LogManager.getLogger(PlayOneController.class);

    @Autowired
    private PlayerOneService playerOneService;

    @GetMapping("/v1/players/player-one/{number}/{message}")
    public ResponseEntity<Result> gameBegin(@PathVariable int number, @PathVariable String message){
        logger.debug("PlayOneController : {}", () -> number);
        Result result = playerOneService.playNumber(number, message);
       return ResponseEntity.ok(result);
    }
}
