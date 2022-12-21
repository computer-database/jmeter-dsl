package com.github.prmiguel.cdb;

import us.abstracta.jmeter.javadsl.http.DslHttpSampler;

import static us.abstracta.jmeter.javadsl.JmeterDsl.httpSampler;

public class Computers {

    public static DslHttpSampler list() {
        return httpSampler((String) null);
    }

    public static DslHttpSampler search(String computerName) {
        return httpSampler((String) null)
                .param("f", computerName);
    }

    public static DslHttpSampler open(String computerId) {
        return httpSampler("/computers/" + computerId);
    }

    public static DslHttpSampler page(String page) {
        return httpSampler("/computers")
                .param("p", page)
                .param("n", "10")
                .param("s", "name")
                .param("d", "asc");
    }

    public static DslHttpSampler openNewForm() {
        return httpSampler("/computers/new");
    }

    public static DslHttpSampler create(String name, String introduced, String discontinued, String company) {
        return httpSampler("/computers")
                .method("POST")
                .param("name", name)
                .param("introduced", introduced)
                .param("discontinued", discontinued)
                .param("company", company);
    }
}
