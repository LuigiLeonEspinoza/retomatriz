package com.matriz.reto.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.matriz.reto.entities.Rotation;
import com.matriz.reto.services.IRotationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Rotation")
@RequiredArgsConstructor
public class RotationController {

    private static final Logger logger = LoggerFactory.getLogger(RotationController.class);
    private final IRotationService rotationService;

    @PostMapping()
    public ResponseEntity saveClient(@RequestBody Rotation rotation){
        try {
            return new ResponseEntity(rotationService.rotateInPlace90Degrees(rotation), HttpStatus.OK);
        }catch (Exception e){
            logger.error("ERROR:  " + e.getMessage());
            return new ResponseEntity( e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

}
