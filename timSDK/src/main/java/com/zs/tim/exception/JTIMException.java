package com.zs.tim.exception;

/**
 * base exception for this projects
 */
public class JTIMException extends Throwable{
    public JTIMException(){}
    public JTIMException(String msg){
        super(msg);
    }

    public JTIMException(String msg, Throwable throwable){
        super(msg, throwable);
    }

    public JTIMException(Throwable throwable){
        super(throwable);
    }
}
