package com.t1gerok.calculator.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
public class EmptyResponse {
    public EmptyResponse() {
    }
}
