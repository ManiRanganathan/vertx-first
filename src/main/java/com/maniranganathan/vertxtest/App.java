package com.maniranganathan.vertxtest;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

/**
 * Hello world!
 *
 */
public class App
{

    public static void main(String[] args) {
        // Create the Vert.x instance
        Vertx vertx = Vertx.vertx();

        // Create a router
        Router router = Router.router(vertx);
        router.get("/").handler(rc -> rc.response().end("Hello"));
        router.get("/:name").handler(rc -> rc.response().end("Hello " + rc.pathParam("name")));

        // Start the HTTP server.
        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(8080);
    }
}