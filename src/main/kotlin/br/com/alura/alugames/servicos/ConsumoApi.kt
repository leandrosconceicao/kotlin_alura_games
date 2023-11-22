package br.com.alura.alugames.servicos

import br.com.alura.alugames.modelo.InfoJogo
import com.google.gson.Gson
import io.github.cdimascio.dotenv.dotenv
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    private val dotenv = dotenv()
    fun buscaJogo(id: String): InfoJogo? {
        val link = dotenv["LINK"]
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("$link$id"))
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        if (response.statusCode() > 399) {
            return null
        }

        val json = response.body()

        val gson = Gson()

        var meuInfoJogo: InfoJogo? = null

        val result = kotlin.runCatching {
            val data = gson.fromJson(json, InfoJogo::class.java)
            meuInfoJogo = data
        }

        result.onFailure {
            meuInfoJogo = null
        }

        return meuInfoJogo
    }
}