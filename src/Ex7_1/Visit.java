package Ex7_1;
public class Visit {
    private Customer customer;
    private double totalServiceExpense;
    private double totalProductExpense;
    public Visit(Customer customer) {
        this.customer = customer;
    }
    public double getTotalExpense() {
        double serviceExpense = customer.getServiceExpense();
        double productExpense = customer.getProductExpense();
        double serviceDiscount = DiscountRate.getServiceDiscountRate(customer.getMemberType());
        double productDiscount = DiscountRate.getProductDiscountRate(customer.getMemberType());
        double discountedServiceExpense = serviceExpense - (serviceExpense * serviceDiscount);
        double discountedProductExpense = productExpense - (productExpense * productDiscount);
        return discountedServiceExpense + discountedProductExpense;
    }
    public void setServiceExpense(double expense) {
        customer.setServiceExpense(expense);
    }

    public void setProductExpense(double expense) {
        customer.setProductExpense(expense);
    }

    @Override
    public String toString() {
        return "Visit details for " + customer.getName() + " [Service Expense: " + customer.getServiceExpense() +
                ", Product Expense: " + customer.getProductExpense() + ", Total Expense: " + getTotalExpense() + "]";
    }
}
