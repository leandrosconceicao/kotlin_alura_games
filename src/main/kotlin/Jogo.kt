data class Jogo(val titulo: String, val capa: String) {
    val descricao = ""

    override fun toString(): String {
        return "Meu Jogo - Titulo: $titulo, Capa: $capa - Descrição: $descricao"
    }
}