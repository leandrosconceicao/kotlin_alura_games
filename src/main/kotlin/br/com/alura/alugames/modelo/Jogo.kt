package br.com.alura.alugames.modelo

data class Jogo(val titulo: String, val capa: String) {
    var descricao:String? = ""

    override fun toString(): String {
        return "Meu Titulo: $titulo\nCapa: $capa\nDescrição: $descricao"
    }
}