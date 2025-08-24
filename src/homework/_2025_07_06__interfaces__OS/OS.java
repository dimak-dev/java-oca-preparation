package homework._2025_07_06__interfaces__OS;

class OS implements /*CustomDescComparable,*/ CustomVersionComparable, Comparable<OS> {
    private final String name;
    private final int version;

    public OS(String name, int version) {
        this.name = name;
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    @Override
    public String toString() {
        String hash = Integer.toString(this.hashCode(), 16);
        return String.format("OS Hash: %-8s | Name: %-10s | Version: %-4d", hash, name, version);
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
        int nameCompare = this.name.compareTo(o.name);
        if (nameCompare == 0) return this.version - o.version;
        return nameCompare;
    }
}
