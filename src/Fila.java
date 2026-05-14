import java.util.NoSuchElementException;

public class Fila<E> {

	private Celula<E> frente;
	private Celula<E> tras;
	private int quantidade;

	public Fila() {
		Celula<E> sentinela = new Celula<>();
		frente = sentinela;
		tras = sentinela;
		quantidade = 0;
	}

	public boolean vazia() {
		return frente == tras;
	}

	public void enfileirar(E item) {
		Celula<E> novaCelula = new Celula<>(item);
		tras.setProximo(novaCelula);
		tras = tras.getProximo();
		quantidade++;
	}

	public E desenfileirar() {
		E item = consultarPrimeiro();
		Celula<E> primeiro = frente.getProximo();
		
		frente.setProximo(primeiro.getProximo());
		primeiro.setProximo(null);
		
		if (primeiro == tras) {
			tras = frente;
		}
		
		quantidade--;
		return item;
	}

	public E consultarPrimeiro() {
		if (vazia()) {
			throw new NoSuchElementException("Nao ha nenhum item na fila!");
		}

		return frente.getProximo().getItem();
	}

	public E consultarFrente() {
		return consultarPrimeiro();
	}

	public void imprimir() {
		Celula<E> aux;
		
		if (vazia()) {
			System.out.println("A fila esta vazia!");
		} else {
			aux = frente.getProximo();
			while (aux != null) {
				System.out.println(aux.getItem());
				aux = aux.getProximo();
			}
		}
	}

	public int contarOcorrencias(E item) {
		int ocorrencias = 0;
		Celula<E> aux = frente.getProximo();
		
		while (aux != null) {
			if ((item == null && aux.getItem() == null) || (item != null && item.equals(aux.getItem()))) {
				ocorrencias++;
			}
			aux = aux.getProximo();
		}
		
		return ocorrencias;
	}

	public Fila<E> extrairLote(int numItens) {
		Fila<E> lote = new Fila<>();
		int itensExtraidos = 0;
		
		while (!vazia() && itensExtraidos < numItens) {
			lote.enfileirar(desenfileirar());
			itensExtraidos++;
		}
		
		return lote;
	}

	public int tamanho() {
		return quantidade;
	}

	@Override
	public String toString() {
		StringBuilder dados = new StringBuilder();
		Celula<E> atual = frente.getProximo();

		while (atual != null) {
			dados.append(atual.getItem()).append(System.lineSeparator());
			atual = atual.getProximo();
		}

		return dados.toString();
	}
}
