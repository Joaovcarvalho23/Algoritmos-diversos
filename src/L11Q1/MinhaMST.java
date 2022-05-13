package L11Q1;

public class MinhaMST {
    private  int verticesDoGrafo = 5;

    public int verticeComMenorChave(int valorChave[], Boolean conjuntoMST[]){
        int minimo = Integer.MAX_VALUE;
        int menorIndice = -1;

        for(int vertice = 0; vertice < verticesDoGrafo; vertice++){
            if(conjuntoMST[vertice] == false && valorChave[vertice] < minimo){
                minimo = valorChave[vertice];
                menorIndice = vertice;
            }
        }
        return menorIndice;
    }

    public void metodoPrim(int grafo[][]){

        int chave[] = new int[verticesDoGrafo];//armazenar a MST construída
        int pai[] = new int[verticesDoGrafo];

        Boolean conjuntoMST[] = new Boolean[verticesDoGrafo];

        for(int i = 0; i < verticesDoGrafo; i++){
            chave[i] = Integer.MAX_VALUE;
            conjuntoMST[i] = false;
        }
        pai[0] = -1;
        chave[0] = 0;

        for(int contador = 0; contador < verticesDoGrafo - 1; contador++){
            int u = verticeComMenorChave(chave, conjuntoMST);
            conjuntoMST[u] = true;

            for(int v = 0; v < verticesDoGrafo; v++){
                if(grafo[u][v] != 0 && conjuntoMST[v] == false && grafo[u][v] < chave[v]){
                    pai[v] = u;
                    chave[v] = grafo[u][v];
                }
            }
            imprimirMST(pai, grafo);
        }
    }

    public void imprimirMST(int pai[], int grafo[][]) {
        System.out.println("Aresta \tPeso da aresta");
        for(int i = 1; i < verticesDoGrafo; i++){
            System.out.println(pai[i] + " <-> " + i + "|\t\t" + grafo[i][pai[i]]);
        }
    }

    public static void main(String[] args){
        MinhaMST arvore = new MinhaMST();
        int meuGrafo[][] = new int[][] {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 }
        };
        arvore.metodoPrim(meuGrafo);
    }
}
