
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CoffeeManagementGUI {

    private JFrame frame;
    private ArrayList<Coffee> coffeeList;
    private JTextArea coffeeTextArea;
    private double totalPrice = 0.0;

    public CoffeeManagementGUI() {
        coffeeList = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Set fullscreen
        frame.setUndecorated(true); // Remove window decorations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("Coffee Management System");
        titleLabel.setBounds(120, 10, 200, 20);
        frame.getContentPane().add(titleLabel);

        // Adding default coffee choices with prices
        coffeeList.add(new Coffee("Affogato", 3.5));
        coffeeList.add(new Coffee("Irish Coffee", 4.0));
        coffeeList.add(new Coffee("Macchiato", 3.0));
        coffeeList.add(new Coffee("Flat White", 3.5));
        coffeeList.add(new Coffee("Cappuccino", 3.0));
        coffeeList.add(new Coffee("Americano", 2.5));
        coffeeList.add(new Coffee("Mocha", 4.0));
        coffeeList.add(new Coffee("Black Coffee", 2.0));
        coffeeList.add(new Coffee("Latte", 3.0));
        coffeeList.add(new Coffee("Espresso", 2.5));

        JButton addCoffeeButton = new JButton("Add Coffee");
        addCoffeeButton.setBounds(50, 50, 120, 30);
        addCoffeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCoffee();
            }
        });
        frame.getContentPane().add(addCoffeeButton);

        JButton viewCoffeeButton = new JButton("View Coffees");
        viewCoffeeButton.setBounds(200, 50, 120, 30);
        viewCoffeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewCoffees();
            }
        });
        frame.getContentPane().add(viewCoffeeButton);

        JButton deleteCoffeeButton = new JButton("Delete Coffee");
        deleteCoffeeButton.setBounds(50, 100, 120, 30);
        deleteCoffeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteCoffee();
            }
        });
        frame.getContentPane().add(deleteCoffeeButton);

        JButton editCoffeeButton = new JButton("Edit Coffee");
        editCoffeeButton.setBounds(200, 100, 120, 30);
        editCoffeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editCoffee();
            }
        });
        frame.getContentPane().add(editCoffeeButton);

        JButton placeOrderButton = new JButton("Place Order");
        placeOrderButton.setBounds(140, 150, 120, 30);
        placeOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                placeOrder();
            }
        });
        frame.getContentPane().add(placeOrderButton);

        coffeeTextArea = new JTextArea();
        coffeeTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(coffeeTextArea);
        scrollPane.setBounds(50, 200, 350, 100);
        frame.getContentPane().add(scrollPane);

        JButton downloadPDFButton = new JButton("Download PDF");
        downloadPDFButton.setBounds(140, 320, 150, 30);
        downloadPDFButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                downloadPDF();
            }
        });
        frame.getContentPane().add(downloadPDFButton);

        JButton calculateTotalButton = new JButton("Calculate Total");
        calculateTotalButton.setBounds(300, 150, 150, 30);
        calculateTotalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });
        frame.getContentPane().add(calculateTotalButton);

        frame.setVisible(true);
    }

    private void addCoffee() {
        String[] choices = new String[coffeeList.size()];
        for (int i = 0; i < coffeeList.size(); i++) {
            choices[i] = coffeeList.get(i).getName();
        }
        String selectedCoffee = (String) JOptionPane.showInputDialog(frame, "Choose coffee:", "Add Coffee", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        if (selectedCoffee != null) {
            coffeeTextArea.append(selectedCoffee + "\n");
        }
    }

    private void viewCoffees() {
        coffeeTextArea.setText("   ");
        for (Coffee coffee : coffeeList) {
            coffeeTextArea.append(coffee.getName() + " - $" + coffee.getPrice() + "\n");
        }
    }

    private void deleteCoffee() {
        String[] choices = new String[coffeeList.size()];
        for (int i = 0; i < coffeeList.size(); i++) {
            choices[i] = coffeeList.get(i).getName();
        }
        String selectedCoffee = (String) JOptionPane.showInputDialog(frame, "Select coffee to delete:", "Delete Coffee", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        if (selectedCoffee != null) {
            for (int i = 0; i < coffeeList.size(); i++) {
                if (coffeeList.get(i).getName().equals(selectedCoffee)) {
                    coffeeList.remove(i);
                    break;
                }
            }
            JOptionPane.showMessageDialog(frame, "Coffee deleted successfully!");
        }
    }

    private void editCoffee() {
        String[] choices = new String[coffeeList.size()];
        for (int i = 0; i < coffeeList.size(); i++) {
            choices[i] = coffeeList.get(i).getName();
        }
        String selectedCoffee = (String) JOptionPane.showInputDialog(frame, "Select coffee to edit:", "Edit Coffee", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        if (selectedCoffee != null) {
            String newPriceStr = JOptionPane.showInputDialog(frame, "Enter new price for coffee (in $):", coffeeList.get(0).getPrice());
            try {
                double newPrice = Double.parseDouble(newPriceStr);
                for (Coffee coffee : coffeeList) {
                    if (coffee.getName().equals(selectedCoffee)) {
                        coffee.setPrice(newPrice);
                        break;
                    }
                }
                JOptionPane.showMessageDialog(frame, "Coffee price edited successfully!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid price format. Please enter a valid number.");
            }
        }
    }

    private void placeOrder() {
        JOptionPane.showMessageDialog(frame, "Order placed successfully!");
    }

    private void downloadPDF() {
        try {
            File file = new File("CoffeeList.pdf");
            FileWriter writer = new FileWriter(file);
            writer.write("Coffee List:\n");
            for (Coffee coffee : coffeeList) {
                writer.write(coffee.getName() + " - $" + coffee.getPrice() + "\n");
            }
            writer.close();
            JOptionPane.showMessageDialog(frame, "PDF downloaded successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Error occurred while downloading PDF.");
            ex.printStackTrace();
        }
    }

    private void calculateTotal() {
        totalPrice = 0.0;
        for (Coffee coffee : coffeeList) {
            totalPrice += coffee.getPrice();
        }
        JOptionPane.showMessageDialog(frame, "Total Price: $" + totalPrice);
    }

    public static void main(String[] args) {
        new CoffeeManagementGUI();
    }
}

class Coffee {

    private String name;
    private double price;

    public Coffee(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
