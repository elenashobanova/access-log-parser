package OOP;

class Point3D extends Point {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        String res = "{" + getX() + ";" + getY() + ";" + z + "}";
        return res;
    }
}
