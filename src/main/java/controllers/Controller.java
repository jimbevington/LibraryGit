package controllers;

import models.Book;

import static spark.SparkBase.staticFileLocation;

public class Controller {

    public static void main(String[] args) {

        staticFileLocation("/public");

        BookController bookController = new BookController();
        BorrowerController borrowerController = new BorrowerController();

    }

}
