package controllers;

import static spark.SparkBase.staticFileLocation;

public class Controller {

    public static void main(String[] args) {

        staticFileLocation("/public");

    }

}
