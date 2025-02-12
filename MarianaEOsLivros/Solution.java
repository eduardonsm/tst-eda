public int particiona(int[] v, int ini, int fim) {

	int i = ini + 1;
	int j = fim;
	int pivot = v[ini];

	while (i <= j) {

		// andando com i para frente. pára quando encontrar um valor maior que o pivot
		while (i <= j && v[i] <= pivot)
			i++;

		// andando com j para trás. pára quando encontrar um valor menor ou igual ao pivot
		while(i <= j && A[j] > pivot)
                j = j - 1;
         
        // se i não encontrou j, troca
        if (i < j)
        	swap(v, i, j);

	}

	swap(v, ini, j);
	return j;
}
