package VideoCodeAlong;

public class StudenHashTable {

    //Instance data
    private Student[] hashTable;

    public StudenHashTable(int size){
        hashTable = new Student[size];
    }

    public void addStundent(Student student){
        int count = 0;
        int hashCode = findHashCode(student);
        int hashlocation =hashCode;
        while (hashTable[hashlocation] != null && count <= hashTable.length){
            hashlocation++;
            count++;
            hashlocation = hashlocation % hashTable.length;
        }

        hashTable[hashlocation] = student;
    }

    public Student getStudent(int studentId){
        int count =0;
        int hashLocation = findHashCode(studentId);
             while (hashTable[hashLocation] != null && count <= hashTable.length) {
                 if (hashTable[hashLocation].getId() == studentId) {
                     return hashTable[hashLocation];
                 } else {
                     hashLocation++;
                     count++;
                     hashLocation = hashLocation % hashTable.length;
                 }
             }
             return null;
    }
    private int findHashCode(Student student){
        return findHashCode(student.getId());
    }

    private int findHashCode(int studentId ){
        int hashCode = studentId % hashTable.length;
        return hashCode;
    }


}
