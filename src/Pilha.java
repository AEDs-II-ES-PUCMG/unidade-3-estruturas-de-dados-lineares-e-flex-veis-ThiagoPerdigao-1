import java.util.NoSuchElementException;

public class Pilha<E> {

	private Celula<E> topo;
	private Celula<E> fundo;

	public Pilha() {

		Celula<E> sentinela = new Celula<E>();
		fundo = sentinela;
		topo = sentinela;

	}

	public boolean vazia() {
		return fundo == topo;
	}

	public void empilhar(E item) {

		topo = new Celula<E>(item, topo);
	}

	public E desempilhar() {

		E desempilhado = consultarTopo();
		topo = topo.getProximo();
		return desempilhado;

	}

	public E consultarTopo() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return topo.getItem();

	}

	public int tamanho() {
		
		int quantidade = 0;
		Celula<E> atual = topo;
		
		while (atual != fundo) {
			quantidade++;
			atual = atual.getProximo();
		}
		
		return quantidade;
	}

	/**
	 * Cria e devolve uma nova pilha contendo os primeiros numItens elementos
	 * do topo da pilha atual.
	 * 
	 * Os elementos são mantidos na mesma ordem em que estavam na pilha original.
	 * Caso a pilha atual possua menos elementos do que o valor especificado,
	 * uma exceção será lançada.
	 *
	 * @param numItens o número de itens a serem copiados da pilha original.
	 * @return uma nova instância de Pilha<E> contendo os numItens primeiros elementos.
	 * @throws IllegalArgumentException se a pilha não contém numItens elementos.
	 */
	public Pilha<E> subPilha(int numItens) {
		
		if (numItens < 0) {
			throw new IllegalArgumentException("O numero de itens deve ser positivo.");
		}
		
		Pilha<E> pilhaAuxiliar = new Pilha<>();
		Pilha<E> subPilha = new Pilha<>();
		Celula<E> atual = topo;
		int itensCopiados = 0;
		
		while (atual != fundo && itensCopiados < numItens) {
			pilhaAuxiliar.empilhar(atual.getItem());
			atual = atual.getProximo();
			itensCopiados++;
		}
		
		if (itensCopiados < numItens) {
			throw new IllegalArgumentException("A pilha nao contem a quantidade de itens solicitada.");
		}
		
		while (!pilhaAuxiliar.vazia()) {
			subPilha.empilhar(pilhaAuxiliar.desempilhar());
		}
		
		return subPilha;
	}

	@Override
	public String toString() {
		
		StringBuilder dados = new StringBuilder();
		Celula<E> atual = topo;
		
		while (atual != fundo) {
			dados.append(atual.getItem()).append(System.lineSeparator());
			atual = atual.getProximo();
		}
		
		return dados.toString();
	}
}
