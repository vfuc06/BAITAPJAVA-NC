package Ex7_1;
public class Customer {
    private String name;
    private boolean isMember = false;
    private String memberType = "";
    private double serviceExpense;
    private double productExpense;
    public Customer(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setMember(boolean member) {
        this.isMember = member;
    }
    public boolean isMember() {
        return isMember;
    }
    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }
    @Override
    public String toString() {
        return "Customer Name: " + name + ", Membership: " + memberType + ", Service Expense: " + serviceExpense + ", Product Expense: " + productExpense;
    }
}

