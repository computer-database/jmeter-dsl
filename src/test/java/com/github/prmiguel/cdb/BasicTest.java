package com.github.prmiguel.cdb;

import org.junit.jupiter.api.Test;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

import java.io.IOException;

import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

public class BasicTest {

    @Test
    public void testsdf() throws IOException {
        TestPlanStats stats = testPlan(
                httpDefaults().url("http://computer-database.gatling.io").path("/computers"),
                threadGroup(4, 1,
                        Computers.list(),
                        Computers.search("macbook"),
                        Computers.open("6"),
                        Computers.list(),
                        Computers.page("1"),
                        Computers.page("2"),
                        Computers.page("3"),
                        Computers.openNewForm(),
                        Computers.create("Alienware", "2022-12-12" , "2023-12-12" , "5"),
                        Computers.list(),
                        jtlWriter("target/jmeter/results", "basic.jtl")
                )
        ).run();
    }

}
