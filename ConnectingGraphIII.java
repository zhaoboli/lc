public class ConnectingGraph3 {

    private int[] father;
    private int componentCt;

    public ConnectingGraph3(int n) {
        this.componentCt = n;
        this.father = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            father[i] = i;
        }
    }

    public int find(int number) {
        if (father[number] == number) {
            return number;
        }
        return father[number] = find(father[number]);
    }
   
    public void connect(int a, int b) {
        if (father[find(a)] == father[find(b)]) {
            return;
        }
        father[find(a)] = father[find(b)];
        componentCt--;
    }


    public int query() {
        return componentCt;
    }
}
