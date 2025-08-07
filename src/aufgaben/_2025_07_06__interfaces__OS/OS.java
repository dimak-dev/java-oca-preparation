package aufgaben._2025_07_06__interfaces__OS;

class OS implements /*CustomDescComparable,*/ CustomVersionComparable, Comparable<OS> {
    private final String name;
    private final int version;

    public OS(String name, int version) {
        this.name = name;
        this.version = version;
    }

    @Override
    public String toString() {
        return "OS Hash: " + String.format("%8s", Integer.toString(this.hashCode(), 16)) + " | Name: " + String.format("%10s", name) + " | Version: " + String.format("%4d", version);
    }

    @Override
    public int customCompareVersionTo(CustomVersionComparable o) {
        return this.version - ((OS) o).version;
    }

//    @Override
//    public int customDescCompareTo(CustomDescComparable o) {
//        var nameCompare = ((OS) o).name.compareTo(this.name);
//        if (nameCompare == 0) return -this.version + ((OS) o).version;
//        return nameCompare;
//    }

    @Override
    public int compareTo(OS o) {
        var nameCompare = this.name.compareTo(o.name);
        if (nameCompare == 0) return this.version - o.version;
        return nameCompare;
    }
}
