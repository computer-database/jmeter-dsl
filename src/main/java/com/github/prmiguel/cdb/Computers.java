package com.github.prmiguel.cdb;

import us.abstracta.jmeter.javadsl.http.DslHttpSampler;

import static us.abstracta.jmeter.javadsl.JmeterDsl.httpSampler;

public class Computers {

    public static DslHttpSampler list() {
        return httpSampler("A user arrives at the application", (String) null);
    }

    public static DslHttpSampler search(String computerName) {
        return httpSampler("The user searches for", (String) null)
                .param("f", computerName);
    }

    public static DslHttpSampler open(String computerId) {
        return httpSampler("The user opens one of the related models", "/computers/" + computerId);
    }

    public static DslHttpSampler home() {
        return httpSampler("The user goes back to home page", (String) null);
    }

    public static DslHttpSampler page(String page) {
        return httpSampler("The user iterates through page " + page, "/computers")
                .param("p", page)
                .param("n", "10")
                .param("s", "name")
                .param("d", "asc");
    }

    public static DslHttpSampler openNewForm() {
        return httpSampler("The user opens the new model form", "/computers/new");
    }

    public static DslHttpSampler create(String name, String introduced, String discontinued, String company) {
        return httpSampler("The user creates a new model", "/computers")
                .method("POST")
                .param("name", name)
                .param("introduced", introduced)
                .param("discontinued", discontinued)
                .param("company", company);
    }
}
