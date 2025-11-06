import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.NumberFormat;
import java.util.Locale;

public class POSApp extends JFrame implements ActionListener {

    // --- Komponen GUI ---
    private JTable productTable, cartTable;
    private DefaultTableModel productModel, cartModel;
    private JButton addToCartButton, checkoutButton, printButton;
    private JTextField qtyField, paymentField;
    private JLabel totalLabel, selectedProductLabel;
    private JTextArea receiptArea;

    // --- Data ---
    private double currentTotal = 0.0;
    private NumberFormat currencyFormatter;

    /**
     * Konstruktor utama untuk inisialisasi GUI.
     */
    public POSApp() {
        // Inisialisasi formatter mata uang (Rupiah)
        currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        // 1. Pengaturan JFrame Utama
        setTitle("POIN Off-Sales - Java Swing");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Tampilkan di tengah layar

        // 2. Membuat Menu Bar
        initMenuBar();

        // 3. Mengatur Layout Utama
        setLayout(new GridLayout(1, 2, 10, 10));

        // 4. Membuat dan Menambahkan Panel
        add(createLeftPanel());
        add(createRightPanel());

        // 5. Menambahkan listener untuk seleksi tabel produk
        productTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && productTable.getSelectedRow() != -1) {
                // Ambil nama produk yang dipilih
                String selectedName = productModel.getValueAt(productTable.getSelectedRow(), 1).toString();
                selectedProductLabel.setText("Pilih: " + selectedName);
            }
        });
    }

    /**
     * Membuat Menu Bar (File, Help).
     */
    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");

        // (Opsional) Tambah item menu
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0)); // Tutup aplikasi
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }

    /**
     * Membuat panel kiri (Daftar Produk dan tombol Add to Cart).
     * @return JPanel yang sudah diisi komponen.
     */
    private JPanel createLeftPanel() {
        JPanel leftPanel = new JPanel(new BorderLayout(5, 5));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        leftPanel.add(new JLabel("Produk", JLabel.CENTER), BorderLayout.NORTH);

        // Data untuk tabel produk (sesuai gambar)
        String[] productColumns = {"ID", "Nama Produk", "Harga (Rp)"};
        Object[][] productData = {
                {"P001", "Air Mineral 600ml", 5000.0},
                {"P002", "Kopi Sachet", 5500.0},
                {"P003", "Roti Boy", 8000.0},
                {"P004", "Snack Keripik", 6000.0},
                {"P005", "Minuman Botol", 12000.0}
        };

        // Buat model tabel agar tidak bisa diedit
        productModel = new DefaultTableModel(productData, productColumns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        productTable = new JTable(productModel);
        leftPanel.add(new JScrollPane(productTable), BorderLayout.CENTER);

        // Panel bawah untuk "Add to Cart"
        JPanel bottomPanel = new JPanel(new BorderLayout());
        selectedProductLabel = new JLabel("Pilih produk dari tabel di atas");
        selectedProductLabel.setFont(new Font("SansSerif", Font.ITALIC, 12));
        bottomPanel.add(selectedProductLabel, BorderLayout.NORTH);
        
        JPanel actionPanel = new JPanel(new FlowLayout());
        actionPanel.add(new JLabel("Qty:"));
        qtyField = new JTextField("1", 5); // Default Qty 1, lebar 5 karakter
        actionPanel.add(qtyField);
        
        addToCartButton = new JButton("Add to Cart");
        addToCartButton.addActionListener(this); // Tambah listener
        actionPanel.add(addToCartButton);
        
        bottomPanel.add(actionPanel, BorderLayout.CENTER);

        leftPanel.add(bottomPanel, BorderLayout.SOUTH);
        return leftPanel;
    }

    /**
     * Membuat panel kanan (Keranjang, Total, Bayar, Struk).
     * @return JPanel yang sudah diisi komponen.
     */
    private JPanel createRightPanel() {
        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel atas untuk keranjang
        JPanel cartPanel = new JPanel(new BorderLayout());
        cartPanel.add(new JLabel("Keranjang", JLabel.CENTER), BorderLayout.NORTH);

        String[] cartColumns = {"ID", "Nama Produk", "Qty", "Harga", "Subtotal"};
        cartModel = new DefaultTableModel(null, cartColumns); // Awalnya kosong
        cartTable = new JTable(cartModel);
        
        // Buat JScrollPane lebih tinggi
        JScrollPane cartScrollPane = new JScrollPane(cartTable);
        cartScrollPane.setPreferredSize(new Dimension(400, 200)); // Atur tinggi
        
        cartPanel.add(cartScrollPane, BorderLayout.CENTER);
        rightPanel.add(cartPanel, BorderLayout.NORTH); // Taruh keranjang di ATAS

        // Panel bawah untuk checkout dan struk
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS)); // Layout vertikal

        // Panel untuk Total, Bayar, Tombol
        JPanel paymentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        totalLabel = new JLabel("Total: Rp0.00");
        totalLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        paymentPanel.add(totalLabel);

        paymentPanel.add(new JLabel("Bayar:"));
        paymentField = new JTextField(10);
        paymentPanel.add(paymentField);

        checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(this);
        paymentPanel.add(checkoutButton);

        printButton = new JButton("Cetak");
        printButton.addActionListener(this);
        paymentPanel.add(printButton);
        
        southPanel.add(paymentPanel);

        // Area untuk Struk
        southPanel.add(new JLabel("Struk:"));
        receiptArea = new JTextArea(10, 40);
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Font monospaced agar rapi
        southPanel.add(new JScrollPane(receiptArea));

        rightPanel.add(southPanel, BorderLayout.CENTER); // Taruh panel checkout di TENGAH/BAWAH
        return rightPanel;
    }

    /**
     * Menangani semua event klik tombol.
     * @param e ActionEvent yang terjadi.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToCartButton) {
            addItemToCart();
        } else if (e.getSource() == checkoutButton) {
            performCheckout();
        } else if (e.getSource() == printButton) {
            printReceipt();
        }
    }

    /**
     * Logika untuk tombol "Add to Cart".
     */
    private void addItemToCart() {
        int selectedRow = productTable.getSelectedRow();

        // 1. Validasi: Pastikan produk sudah dipilih
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                    "Silakan pilih produk dari tabel terlebih dahulu.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // 2. Validasi: Pastikan Qty adalah angka positif
            int qty = Integer.parseInt(qtyField.getText());
            if (qty <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Kuantitas (Qty) harus lebih dari 0.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 3. Ambil data dari tabel produk
            String id = productModel.getValueAt(selectedRow, 0).toString();
            String name = productModel.getValueAt(selectedRow, 1).toString();
            double price = (Double) productModel.getValueAt(selectedRow, 2);
            double subtotal = price * qty;

            // 4. Tambahkan ke tabel keranjang
            cartModel.addRow(new Object[]{id, name, qty, price, subtotal});

            // 5. Update total
            currentTotal += subtotal;
            updateTotalLabel();
            
            // 6. Reset Qty field
            qtyField.setText("1");
            productTable.clearSelection();
            selectedProductLabel.setText("Pilih produk dari tabel di atas");

        } catch (NumberFormatException ex) {
            // Tangkap jika Qty bukan angka
            JOptionPane.showMessageDialog(this,
                    "Kuantitas (Qty) harus berupa angka.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Logika untuk tombol "Checkout".
     */
    private void performCheckout() {
        // 1. Validasi: Pastikan ada barang di keranjang
        if (cartModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Keranjang masih kosong.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // 2. Validasi: Pastikan jumlah bayar adalah angka
            double payment = Double.parseDouble(paymentField.getText());
            
            // 3. Validasi: Pastikan uang bayar cukup
            if (payment < currentTotal) {
                JOptionPane.showMessageDialog(this,
                        "Jumlah uang bayar tidak mencukupi.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 4. Hitung kembalian
            double change = payment - currentTotal;

            // 5. Buat Struk
            generateReceipt(payment, change);
            
            // 6. Reset
            cartModel.setRowCount(0); // Kosongkan keranjang
            currentTotal = 0.0;
            updateTotalLabel();
            paymentField.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Jumlah bayar harus berupa angka.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Membuat teks struk dan menampilkannya di JTextArea.
     * @param payment Jumlah uang yang dibayar.
     * @param change Jumlah kembalian.
     */
    private void generateReceipt(double payment, double change) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("===== POIN OFF-SALES =====\n");
        sb.append("Toko: Dèmo Toko\n");
        sb.append("==========================\n");
        // Header Tabel Struk
        sb.append(String.format("%-5s %-15s %-3s %-10s\n", "ID", "Nama", "Qty", "Subtotal"));
        sb.append("--------------------------\n");

        // Loop isi keranjang
        for (int i = 0; i < cartModel.getRowCount(); i++) {
            String id = cartModel.getValueAt(i, 0).toString();
            String name = cartModel.getValueAt(i, 1).toString();
            int qty = (Integer) cartModel.getValueAt(i, 2);
            double sub = (Double) cartModel.getValueAt(i, 4);

            // Batasi nama agar tidak merusak layout
            if (name.length() > 15) name = name.substring(0, 14) + ".";

            sb.append(String.format("%-5s %-15s %-3d %-10s\n",
                    id, name, qty, currencyFormatter.format(sub)));
        }

        sb.append("==========================\n");
        sb.append(String.format("TOTAL       : %s\n", currencyFormatter.format(currentTotal)));
        sb.append(String.format("BAYAR       : %s\n", currencyFormatter.format(payment)));
        sb.append(String.format("KEMBALI     : %s\n", currencyFormatter.format(change)));
        sb.append("\nTerima kasih, Silakan kunjungi kembali.\n");

        receiptArea.setText(sb.toString());
    }

    /**
     * Logika untuk tombol "Cetak".
     */
    private void printReceipt() {
        try {
            // 1. Validasi: Pastikan struk tidak kosong
            if (receiptArea.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Struk masih kosong, lakukan checkout terlebih dahulu.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // 2. Panggil fungsi print bawaan JTextArea
            boolean complete = receiptArea.print();
            if (complete) {
                JOptionPane.showMessageDialog(this,
                        "Mencetak...", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Proses cetak dibatalkan.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this,
                    "Gagal mencetak: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Helper untuk update label total.
     */
    private void updateTotalLabel() {
        totalLabel.setText("Total: " + currencyFormatter.format(currentTotal));
    }

    /**
     * Main method untuk menjalankan aplikasi.
     */
    public static void main(String[] args) {
        // Menjalankan GUI di Event Dispatch Thread (Best Practice Swing)
        SwingUtilities.invokeLater(() -> {
            new POSApp().setVisible(true);
        });
    }
}