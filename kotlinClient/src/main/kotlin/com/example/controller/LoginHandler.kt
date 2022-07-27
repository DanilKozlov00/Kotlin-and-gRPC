package com.example.com.example.controller

import io.vertx.core.Handler
import io.vertx.ext.web.RoutingContext

class LoginHandler : Handler<RoutingContext> {
    override fun handle(event: RoutingContext) {
        event.response().sendFile("src/main/webapp/login.jsp")
    }
}