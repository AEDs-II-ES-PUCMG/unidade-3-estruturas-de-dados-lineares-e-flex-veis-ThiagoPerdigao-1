public class TesteFila {

	public static void main(String[] args) {
		
		Fila<Character> filaNome = new Fila<>();
		String nome = "Thiago Perdigao";
		
		System.out.println("Teste preliminar da fila com o primeiro e segundo nome:");
		for (int i = 0; i < nome.length(); i++) {
			filaNome.enfileirar(nome.charAt(i));
		}
		
		filaNome.imprimir();
		
		System.out.println("Ocorrencias do caractere 'i': " + filaNome.contarOcorrencias('i'));
		System.out.println("Primeiro caractere da fila: " + filaNome.consultarPrimeiro());
		System.out.println("Caractere desenfileirado: " + filaNome.desenfileirar());
		System.out.println("Fila apos desenfileirar:");
		filaNome.imprimir();
		
		System.out.println("Lote com os 5 primeiros caracteres restantes:");
		Fila<Character> lote = filaNome.extrairLote(5);
		lote.imprimir();
		
		System.out.println("Fila original apos extrair o lote:");
		filaNome.imprimir();

		System.out.println("Lote solicitando mais itens do que ainda existem na fila:");
		Fila<Character> loteFinal = filaNome.extrairLote(50);
		loteFinal.imprimir();
		
		System.out.println("Fila original apos extrair todos os itens disponiveis:");
		filaNome.imprimir();
	}
}
