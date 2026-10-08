import java.util.Date;

// =========================
// Loan Class
// =========================
class Loan {

    private double interestRate;
    private int years;
    private double amount;
    private Date createdDate;

    public Loan() {
        this.interestRate = 2.5;
        this.years = 1;
        this.amount = 1000;
        this.createdDate = new Date();
    }

    public Loan(double rate, int years, double amount) {
        this.interestRate = rate;
        this.years = years;
        this.amount = amount;
        this.createdDate = new Date();
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getYears() {
        return years;
    }

    public double getAmount() {
        return amount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setInterestRate(double rate) {
        interestRate = rate;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double monthlyPayment() {
        double monthlyRate = interestRate / 1200;
        int months = years * 12;

        return (amount * monthlyRate) /
                (1 - (1 / Math.pow(1 + monthlyRate, months)));
    }

    public double totalPayment() {
        return monthlyPayment() * years * 12;
    }
}


// =========================
// BMI Class
// =========================
class BMI {

    private String personName;
    private int personAge;
    private double personWeight;
    private double personHeight;

    public BMI(String name, int age, double weight, double height) {
        personName = name;
        personAge = age;
        personWeight = weight;
        personHeight = height;
    }

    public BMI(String name, double weight, double height) {
        personName = name;
        personAge = 20;
        personWeight = weight;
        personHeight = height;
    }

    public double calculateBMI() {
        return (personWeight * 703) /
                (personHeight * personHeight);
    }

    public String checkStatus() {

        double value = calculateBMI();

        if (value < 18.5)
            return "Underweight";

        if (value < 25)
            return "Normal";

        if (value < 30)
            return "Overweight";

        return "Obese";
    }

    public String getName() {
        return personName;
    }

    public int getAge() {
        return personAge;
    }

    public double getWeight() {
        return personWeight;
    }

    public double getHeight() {
        return personHeight;
    }
}


// =========================
// Course Class
// =========================
class Course {

    private String title;
    private String[] studentList;
    private int totalStudents;

    public Course(String title) {
        this.title = title;
        studentList = new String[100];
        totalStudents = 0;
    }

    public String getTitle() {
        return title;
    }

    public void addStudent(String name) {

        if (totalStudents == studentList.length) {

            String[] temp = new String[studentList.length * 2];

            System.arraycopy(
                    studentList,
                    0,
                    temp,
                    0,
                    studentList.length
            );

            studentList = temp;
        }

        studentList[totalStudents] = name;
        totalStudents++;
    }

    public void removeStudent(String name) {

        int position = -1;

        for (int i = 0; i < totalStudents; i++) {
            if (studentList[i].equals(name)) {
                position = i;
                break;
            }
        }

        if (position != -1) {

            for (int i = position; i < totalStudents - 1; i++) {
                studentList[i] = studentList[i + 1];
            }

            studentList[totalStudents - 1] = null;
            totalStudents--;
        }
    }

    public String[] getStudentList() {
        return studentList;
    }

    public int getTotalStudents() {
        return totalStudents;
    }
}


// =========================
// Main Program
// =========================
class Test {

    public static void main(String[] args) {

        // Loan example
        System.out.println("******** LOAN INFORMATION ********");

        Loan myLoan = new Loan(3.5, 5, 25000);

        System.out.println("Interest Rate: " +
                myLoan.getInterestRate());

        System.out.println("Loan Period: " +
                myLoan.getYears() + " years");

        System.out.println("Amount: $" +
                myLoan.getAmount());

        System.out.println("Created Date: " +
                myLoan.getCreatedDate());

        System.out.printf("Monthly Payment: %.2f%n",
                myLoan.monthlyPayment());

        System.out.printf("Total Payment: %.2f%n",
                myLoan.totalPayment());


        // BMI example
        System.out.println("\n******** BMI INFORMATION ********");

        BMI person = new BMI("Ahmed", 25, 165, 70);

        System.out.println("Person: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Weight: " + person.getWeight());
        System.out.println("Height: " + person.getHeight());

        System.out.printf("BMI Value: %.2f%n",
                person.calculateBMI());

        System.out.println("Category: " +
                person.checkStatus());


        // Course example
        System.out.println("\n******** COURSE INFORMATION ********");

        Course javaClass = new Course("Java Programming");

        javaClass.addStudent("Mohamed");
        javaClass.addStudent("Omar");
        javaClass.addStudent("Ali");

        System.out.println("Course: " +
                javaClass.getTitle());

        System.out.println("Total Students: " +
                javaClass.getTotalStudents());

        System.out.println("Student List:");

        String[] names = javaClass.getStudentList();

        for (int i = 0; i < javaClass.getTotalStudents(); i++) {
            System.out.println((i + 1) + ". " + names[i]);
        }


        // Remove Omar
        javaClass.removeStudent("Omar");

        System.out.println("\nAfter Removing Omar:");

        System.out.println("Total Students: " +
                javaClass.getTotalStudents());

        for (int i = 0; i < javaClass.getTotalStudents(); i++) {
            System.out.println((i + 1) + ". " +
                    javaClass.getStudentList()[i]);
        }
    }
}
