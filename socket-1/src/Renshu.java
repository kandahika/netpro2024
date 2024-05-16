class Renshu {

    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }

    public int sumUpToN(int n){
    int sum=0;
        for(int i=1; i<=n; i++){
    sum+=i;
        }return sum;
    }

    public int sumFromPtoQ(int p, int q){
        int sum1=0;
        if(p>q){
            return-1;
        }
            for(int i=p; i<=q; i++){
        sum1+=i;
            }return sum1;
        }

        public int sumFromArrayIndex(int[] a, int index){
        if(index>=a.length){
            return-1;
        }
        int sum=0;
            for(int i=index; i<a.length; i++){
        sum+=a[i];
            }return sum;
        }

        public int selectMaxValue(int[] a){
        
            int max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
        
            return max;
        }

        public int selectMinValue(int[] a){
        
            int min = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] < min) {
                    min = a[i];
                }
            }
        
            return min;
        }

        public int selectMaxIndex(int[] a){
            int maxIndex = 0;
            int maxValue = a[0];
        
            for (int i = 1; i < a.length; i++) {
                if (a[i] > maxValue) {
                    maxValue = a[i];
                    maxIndex = i;
                }
            }
        
            return maxIndex;
        }
        
        public int selectMinIndex(int[] a){
            int minIndex = 0;
            int minValue = a[0];
        
            for (int i = 1; i < a.length; i++) {
                if (a[i] < minValue) {
                    minValue = a[i];
                    minIndex = i;
                }
            }
        
            return minIndex;
        }
        public void swapArrayElements(int[] p, int i, int j){
        
            int temp = p[i];
            p[i] = p[j];
            p[j] = temp;
        }
        public static boolean swapTwoArrays(int[] a, int[] b) {
            if (a == null || b == null || a.length != b.length) {
                return false;
            }
        
            for (int i = 0; i < a.length; i++) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
            return true;
        }
        
    
}