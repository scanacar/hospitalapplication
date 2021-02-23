public interface Examination {
    // Examination interface, contains cost, addoperation and printoperations functions
    int cost();
    Examination addoperation(Examination examination);
    String printoperations();
}
