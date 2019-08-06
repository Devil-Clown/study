package com.example.demo.utils;

import java.util.List;

public abstract class ZKBalance {
    public volatile static List<String> SERVICE_LIST;
    public abstract String chooseServiceHost();
}

