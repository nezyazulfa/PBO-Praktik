// We specify that a Salesperson is comparable to another Salesperson.
public class Salesperson implements Comparable<Salesperson> {
    private String firstName, lastName;
    private int totalSales;

    // Constructor remains the same
    public Salesperson(String first, String last, int sales) {
        firstName = first;
        lastName = last;
        totalSales = sales;
    }

    // toString() remains the same
    public String toString() {
        return lastName + ", " + firstName + "\t" + totalSales;
    }

    // equals() remains the same
    public boolean equals(Object other) {
        if (!(other instanceof Salesperson)) {
            return false;
        }
        Salesperson otherSalesperson = (Salesperson) other;
        return lastName.equals(otherSalesperson.getLastName()) &&
               firstName.equals(otherSalesperson.getFirstName());
    }

    // The compareTo method now takes a Salesperson directly, no casting needed.
    public int compareTo(Salesperson other) {
        // Sort by sales first (ascending)
        if (this.totalSales != other.getSales()) {
            return this.totalSales - other.getSales();
        }
        
        // If sales are equal, sort by last name
        int lastNameComparison = this.lastName.compareTo(other.getLastName());
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }

        // If last names are also equal, sort by first name
        return this.firstName.compareTo(other.getFirstName());
    }

    // Accessor methods remain the same
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSales() {
        return totalSales;
    }
}