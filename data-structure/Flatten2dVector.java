public class Vector2D implements Iterator<Integer> {
    //TODO use iterator
    private int currIndex = 0;
    private ArrayList<Integer> list;
    public Vector2D(List<List<Integer>> vec2d) {
        list = new ArrayList<Integer>();
        for (List<Integer> l : vec2d) {
            for (Integer i : l) {
                list.add(i);
            }
        }
    }

    @Override
    public Integer next() {
        if(currIndex == list.size()) {
            return 0;
        }
        return list.get(currIndex++);
    }

    @Override
    public boolean hasNext() {
        return currIndex < list.size();
    }

    @Override
    public void remove() {

    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
