Guarda en primes los números primos menores o iguales a MAX.
Para saber si p es un número primo, hacer: if (!marked[p])

static int MAX = 1000000;
static int SQRT = 1000;
static ArrayList<Integer> primes = new ArrayList<Integer>();
static boolean marked[] = new boolean[MAX+1];

static void sieve() {
	marked[1] = true;
	primes.add(2);
	for (int i = 4; i <= MAX; i += 2) marked[i] = true;
	int i = 3;
	for (; i <= SQRT; i += 2) if (!marked[i]) {
		primes.add(i);
		for (int j = i*i; j <= MAX; j += i*2) marked[j] = true;
	}
	for (; i <= MAX; i += 2) if (!marked[i]) primes.add(i);
}
