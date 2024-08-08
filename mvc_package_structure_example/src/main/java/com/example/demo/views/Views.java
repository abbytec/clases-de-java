package com.example.demo.views;

public class Views {
    public interface Public {
    }

    public interface Private {
    }

    public interface All extends Public, Private {
    }
}
