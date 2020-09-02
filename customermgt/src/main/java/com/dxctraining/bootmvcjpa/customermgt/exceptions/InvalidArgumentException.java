package com.dxctraining.bootmvcjpa.customermgt.exceptions;

public class InvalidArgumentException extends RuntimeException{

    public InvalidArgumentException(String msg){
        super(msg);
    }

}