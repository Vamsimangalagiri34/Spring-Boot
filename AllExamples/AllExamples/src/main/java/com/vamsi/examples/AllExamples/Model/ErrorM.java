package com.vamsi.examples.AllExamples.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
//@Entity
public class ErrorM {


    int ErrorStatus;
    String ErrorMsg;

    public int getErrorStatus() {
        return ErrorStatus;
    }

    public void setErrorStatus(int errorStatus) {
        ErrorStatus = errorStatus;
    }

    public String getErrorMsg() {
        return ErrorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        ErrorMsg = errorMsg;
    }

    public ErrorM(int errorStatus, String errorMsg) {
        ErrorStatus = errorStatus;
        ErrorMsg = errorMsg;
    }

    public ErrorM() {
    }

    @Override
    public String toString() {
        return "ErrorM{" +
                "ErrorStatus=" + ErrorStatus +
                ", ErrorMsg='" + ErrorMsg + '\'' +
                '}';
    }


}
