public class TestePilha {

	public static void main(String[] args) {
		
		Pilha<Integer> pilhaMatricula = new Pilha<>();
		int[] digitos = { 7, 9, 3, 5, 2 };
		
		System.out.println("Teste preliminar da pilha com os digitos da matricula 793527, sem repeticao:");
		for (int digito : digitos) {
			pilhaMatricula.empilhar(digito);
		}
		
		System.out.println(pilhaMatricula);
		System.out.println("Topo atual: " + pilhaMatricula.consultarTopo());
		System.out.println("Desempilhado: " + pilhaMatricula.desempilhar());
		System.out.println("Pilha apos desempilhar:");
		System.out.println(pilhaMatricula);
		
		System.out.println("Subpilha com os 2 primeiros itens do topo:");
		System.out.println(pilhaMatricula.subPilha(2));
	}
}
