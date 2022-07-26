package com.example.com.example.controller

import io.vertx.core.Handler
import io.vertx.ext.web.RoutingContext

class IndexHandler : Handler<RoutingContext> {
    override fun handle(event: RoutingContext) {
        event.response().sendFile("src/main/webapp/index.jsp")
    }
}