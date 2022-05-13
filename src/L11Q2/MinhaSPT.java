package L11Q2;

public class MinhaSPT {
    private int verticesDoGrafo = 9;

    public int distanciaMinima(int distancia[], Boolean conjuntoSPT[]){
        int indiceMin = -1;
        int valorMin = Integer.MAX_VALUE;

        for(int v = 0; v < verticesDoGrafo; v++){
            if(conjuntoSPT[v] == false && distancia[v] <= valorMin){
                indiceMin = v;
                valorMin = distancia[v];
            }
        }
        return indiceMin;
    }

    public void metodoDijkstra(int grafo[][], int buscaMenorCaminho){
        int distancia[] = new int[verticesDoGrafo];
        Boolean conjuntoSPT[] = new Boolean[verticesDoGrafo];

        for(int j = 0; j < verticesDoGrafo; j++){
            distancia[j] = Integer.MAX_VALUE;
            conjuntoSPT[j] = false;
        }

        distancia[buscaMenorCaminho] = 0;

        for(int contador = 0; contador < verticesDoGrafo - 1; contador++){
            int u = distanciaMinima(distancia, conjuntoSPT);

            conjuntoSPT[u] = true;

            for(int v = 0; v < verticesDoGrafo; v++){
                if(!conjuntoSPT[v] && grafo[u][v] != 0 && distancia[u] != Integer.MAX_VALUE && distancia[u] + grafo[u][v] < distancia[v]){
                    distancia[v] = distancia[u] + grafo[u][v];
                }
            }
        }
        imprimirSPT(distancia);
    }

    public void imprimirSPT(int distancia[]) {
        System.out.println("Vértice \t Distância da busca");
        for(int i = 0; i < verticesDoGrafo; i++){
            System.out.println(i + "\t\t\t\t\t" + distancia[i]);
        }
    }

    public static void main(String[] args){
        int meuGrafo[][] = new int[][]{
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        };

        MinhaSPT t = new MinhaSPT();
        t.metodoDijkstra(meuGrafo, 0);
    }
}
