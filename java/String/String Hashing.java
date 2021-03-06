Estructura para realizar operaciones de hashing. 

static class Hash {
	char[] s;
	int[] h;
	int[] pot;
	int p = 265; //Número pseudo-aleatorio base del polinomio (mayor al tamaño del lenguaje)
	long MOD = 1000000009; //Número primo grande
	
	public Hash(String _s) {
		h = new int[_s.length() + 1];
		pot = new int[_s.length() + 1];
		s = _s.toCharArray(); pot[0] = 1;
		for(int i = 1; i <= s.length; i++) {
			h[i] = (int)(((long)h[i - 1] * p + s[i - 1]) % MOD);
			pot[i] = (int)(((long)pot[i - 1] * p) % MOD);
		}
	}
	int hashValue(int i, int j) {
		int ans = (int)(h[j] - (long) h[i] * pot[j - i] % MOD);
		return (ans >= 0) ? ans : (int)(ans + MOD);
	}
}