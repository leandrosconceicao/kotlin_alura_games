package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.servicos.ConsumoApi
import java.util.*

fun main() {
    println("Digite um código de jogo para buscar")
    val scan = Scanner(System.`in`)

    val leitura = scan.nextLine()

    val buscaApi = ConsumoApi()

    val meuInfoJogo = buscaApi.buscaJogo(leitura)

    if (meuInfoJogo == null) {
        println("Jogo inexistente. Tente outro id.")
        return
    }

    val meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)

    println("Deseja inserir uma descrição personalizada? S/N")
    val opcao = scan.nextLine()
    if (opcao.equals("s", true)) {
        println("Insira a descrição personalizada para o jogo:")
        val descricaoPersonalizada = scan.nextLine()
        meuJogo.descricao = descricaoPersonalizada
    } else {
        meuJogo.descricao = meuJogo.titulo
    }
    println(meuJogo)
}