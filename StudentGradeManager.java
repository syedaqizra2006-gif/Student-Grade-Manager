import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentGradeManager extends JFrame {

    // ===================== COLORS =====================

    private static final Color NAVY = new Color(15, 23, 42);
    private static final Color BLUE = new Color(37, 99, 235);
    private static final Color LIGHT_BLUE = new Color(239, 246, 255);
    private static final Color BACKGROUND = new Color(248, 250, 252);
    private static final Color WHITE = Color.WHITE;
    private static final Color TEXT = new Color(30, 41, 59);
    private static final Color GRAY = new Color(100, 116, 139);
    private static final Color BORDER = new Color(226, 232, 240);
    private static final Color GREEN = new Color(22, 163, 74);
    private static final Color RED = new Color(220, 38, 38);
    private static final Color ORANGE = new Color(234, 88, 12);

    // ===================== DATA =====================

    // ArrayList is used to store all student records.
    private final ArrayList<Student> students =
            new ArrayList<>();

    // ===================== GUI COMPONENTS =====================

    private JTextField nameField;
    private JTextField marksField;

    private JTable studentTable;
    private DefaultTableModel tableModel;

    private JLabel countValue;
    private JLabel averageValue;
    private JLabel highestValue;
    private JLabel lowestValue;

    private JLabel summaryLabel;

    // ===================== CONSTRUCTOR =====================

    public StudentGradeManager() {

        setTitle("Student Grade Manager");

        setSize(1150, 720);

        setMinimumSize(
                new Dimension(950, 600)
        );

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        createGUI();
    }

    // ===================== CREATE GUI =====================

    private void createGUI() {

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.setBackground(BACKGROUND);

        // HEADER
        mainPanel.add(
                createHeader(),
                BorderLayout.NORTH
        );

        // MAIN CONTENT
        JPanel content =
                new JPanel(new BorderLayout(18, 18));

        content.setOpaque(false);

        content.setBorder(
                BorderFactory.createEmptyBorder(
                        18, 20, 18, 20
                )
        );

        // LEFT SIDE
        JPanel leftPanel =
                new JPanel(new BorderLayout(15, 15));

        leftPanel.setOpaque(false);

        leftPanel.add(
                createInputPanel(),
                BorderLayout.NORTH
        );

        leftPanel.add(
                createTablePanel(),
                BorderLayout.CENTER
        );

        content.add(
                leftPanel,
                BorderLayout.CENTER
        );

        // RIGHT SIDE
        content.add(
                createStatisticsPanel(),
                BorderLayout.EAST
        );

        mainPanel.add(
                content,
                BorderLayout.CENTER
        );

        // FOOTER
        mainPanel.add(
                createFooter(),
                BorderLayout.SOUTH
        );

        setContentPane(mainPanel);
    }

    // ===================== HEADER =====================

    private JPanel createHeader() {

        JPanel header =
                new JPanel(new BorderLayout());

        header.setBackground(NAVY);

        header.setBorder(
                BorderFactory.createEmptyBorder(
                        22, 28, 22, 28
                )
        );

        JPanel titlePanel =
                new JPanel();

        titlePanel.setOpaque(false);

        titlePanel.setLayout(
                new BoxLayout(
                        titlePanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel title =
                new JLabel("Student Grade Manager");

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        28
                )
        );

        title.setForeground(WHITE);

        JLabel subtitle =
                new JLabel(
                        "Input • Manage • Analyze • Report"
                );

        subtitle.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        14
                )
        );

        subtitle.setForeground(
                new Color(203, 213, 225)
        );

        titlePanel.add(title);

        titlePanel.add(
                Box.createVerticalStrut(5)
        );

        titlePanel.add(subtitle);

        header.add(
                titlePanel,
                BorderLayout.WEST
        );

        JLabel javaLabel =
                new JLabel("JAVA  |  GUI");

        javaLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12
                )
        );

        javaLabel.setForeground(WHITE);

        javaLabel.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(
                                new Color(
                                        96, 165, 250
                                ),
                                1,
                                true
                        ),
                        BorderFactory.createEmptyBorder(
                                8, 12, 8, 12
                        )
                )
        );

        header.add(
                javaLabel,
                BorderLayout.EAST
        );

        return header;
    }

    // ===================== INPUT PANEL =====================

    private JPanel createInputPanel() {

        JPanel panel =
                createCardPanel();

        panel.setLayout(
                new BorderLayout()
        );

        JPanel heading =
                new JPanel();

        heading.setOpaque(false);

        heading.setLayout(
                new BoxLayout(
                        heading,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel title =
                new JLabel("Add Student");

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        18
                )
        );

        title.setForeground(TEXT);

        JLabel description =
                new JLabel(
                        "Enter student details and marks out of 100."
                );

        description.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12
                )
        );

        description.setForeground(GRAY);

        heading.add(title);

        heading.add(
                Box.createVerticalStrut(3)
        );

        heading.add(description);

        panel.add(
                heading,
                BorderLayout.NORTH
        );

        JPanel form =
                new JPanel(new GridBagLayout());

        form.setOpaque(false);

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(12, 5, 3, 8);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        // NAME LABEL
        JLabel nameLabel =
                createLabel("Student Name");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;

        form.add(nameLabel, gbc);

        // NAME FIELD
        nameField =
                createTextField(
                        "Enter student name"
                );

        gbc.gridx = 1;
        gbc.weightx = 1;

        form.add(nameField, gbc);

        // MARKS LABEL
        JLabel marksLabel =
                createLabel("Marks");

        gbc.gridx = 2;
        gbc.weightx = 0;

        form.add(marksLabel, gbc);

        // MARKS FIELD
        marksField =
                createTextField(
                        "0 - 100"
                );

        gbc.gridx = 3;
        gbc.weightx = 0.5;

        form.add(marksField, gbc);

        // ADD BUTTON
        JButton addButton =
                createButton(
                        "＋  Add Student",
                        BLUE
                );

        gbc.gridx = 4;
        gbc.weightx = 0;

        gbc.insets =
                new Insets(12, 12, 3, 5);

        form.add(addButton, gbc);

        // CLEAR BUTTON
        JButton clearButton =
                createButton(
                        "Clear",
                        NAVY
                );

        gbc.gridx = 5;

        form.add(clearButton, gbc);

        panel.add(
                form,
                BorderLayout.CENTER
        );

        // BUTTON ACTIONS
        addButton.addActionListener(
                e -> addStudent()
        );

        clearButton.addActionListener(
                e -> clearFields()
        );

        // ENTER KEY
        nameField.addActionListener(
                e -> marksField.requestFocus()
        );

        marksField.addActionListener(
                e -> addStudent()
        );

        return panel;
    }

    // ===================== TABLE PANEL =====================

    private JPanel createTablePanel() {

        JPanel panel =
                createCardPanel();

        panel.setLayout(
                new BorderLayout()
        );

        JPanel titlePanel =
                new JPanel(new BorderLayout());

        titlePanel.setOpaque(false);

        JLabel title =
                new JLabel(
                        "Student Summary Report"
                );

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        18
                )
        );

        title.setForeground(TEXT);

        JLabel info =
                new JLabel("All Records");

        info.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12
                )
        );

        info.setForeground(GRAY);

        titlePanel.add(
                title,
                BorderLayout.WEST
        );

        titlePanel.add(
                info,
                BorderLayout.EAST
        );

        titlePanel.setBorder(
                BorderFactory.createEmptyBorder(
                        2, 2, 12, 2
                )
        );

        panel.add(
                titlePanel,
                BorderLayout.NORTH
        );

        // TABLE COLUMNS
        String[] columns = {
                "No.",
                "Student Name",
                "Score",
                "Grade",
                "Performance"
        };

        tableModel =
                new DefaultTableModel(
                        columns,
                        0
                ) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column
                    ) {
                        return false;
                    }
                };

        studentTable =
                new JTable(tableModel);

        configureTable();

        JScrollPane scrollPane =
                new JScrollPane(studentTable);

        scrollPane.setBorder(
                new LineBorder(BORDER)
        );

        panel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        return panel;
    }

    // ===================== TABLE DESIGN =====================

    private void configureTable() {

        studentTable.setRowHeight(38);

        studentTable.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13
                )
        );

        studentTable.setForeground(TEXT);

        studentTable.setBackground(WHITE);

        studentTable.setGridColor(
                new Color(
                        241, 245, 249
                )
        );

        studentTable.setShowVerticalLines(false);

        studentTable.setSelectionBackground(
                LIGHT_BLUE
        );

        studentTable.setSelectionForeground(
                TEXT
        );

        studentTable.setIntercellSpacing(
                new Dimension(0, 1)
        );

        JTableHeader header =
                studentTable.getTableHeader();

        header.setPreferredSize(
                new Dimension(0, 40)
        );

        header.setBackground(NAVY);

        header.setForeground(WHITE);

        header.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        // COLUMN WIDTHS
        TableColumnModel columns =
                studentTable.getColumnModel();

        columns.getColumn(0)
                .setPreferredWidth(45);

        columns.getColumn(1)
                .setPreferredWidth(180);

        columns.getColumn(2)
                .setPreferredWidth(90);

        columns.getColumn(3)
                .setPreferredWidth(80);

        columns.getColumn(4)
                .setPreferredWidth(160);

        // CENTER ALIGNMENT
        DefaultTableCellRenderer center =
                new DefaultTableCellRenderer();

        center.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        columns.getColumn(0)
                .setCellRenderer(center);

        columns.getColumn(2)
                .setCellRenderer(center);

        columns.getColumn(3)
                .setCellRenderer(center);

        studentTable.setDefaultRenderer(
                Object.class,
                new GradeTableRenderer()
        );
    }

    // ===================== TABLE RENDERER =====================

    private class GradeTableRenderer
            extends DefaultTableCellRenderer {

        @Override
        public Component
        getTableCellRendererComponent(
                JTable table,
                Object value,
                boolean selected,
                boolean focus,
                int row,
                int column
        ) {

            Component component =
                    super.getTableCellRendererComponent(
                            table,
                            value,
                            selected,
                            focus,
                            row,
                            column
                    );

            if (!selected) {

                if (row % 2 == 0) {
                    component.setBackground(
                            WHITE
                    );
                } else {
                    component.setBackground(
                            new Color(
                                    248, 250, 252
                            )
                    );
                }
            }

            setBorder(
                    BorderFactory.createEmptyBorder(
                            0, 8, 0, 8
                    )
            );

            // COLOR GRADE
            if (column == 3) {

                String grade =
                        String.valueOf(value);

                if (grade.equals("A+")
                        || grade.equals("A")) {

                    setForeground(GREEN);

                } else if (
                        grade.equals("B")
                                || grade.equals("C")
                ) {

                    setForeground(BLUE);

                } else {

                    setForeground(RED);
                }

            } else {

                setForeground(TEXT);
            }

            return component;
        }
    }

    // ===================== STATISTICS PANEL =====================

    private JPanel createStatisticsPanel() {

        JPanel panel =
                new JPanel();

        panel.setPreferredSize(
                new Dimension(245, 0)
        );

        panel.setBackground(NAVY);

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS
                )
        );

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        22, 18, 20, 18
                )
        );

        JLabel title =
                new JLabel("CLASS OVERVIEW");

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        17
                )
        );

        title.setForeground(WHITE);

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        panel.add(title);

        panel.add(
                Box.createVerticalStrut(20)
        );

        // STATISTICS
        countValue =
                createStatisticCard(
                        "TOTAL STUDENTS",
                        "0"
                );

        averageValue =
                createStatisticCard(
                        "CLASS AVERAGE",
                        "0.00"
                );

        highestValue =
                createStatisticCard(
                        "HIGHEST SCORE",
                        "0.00"
                );

        lowestValue =
                createStatisticCard(
                        "LOWEST SCORE",
                        "0.00"
                );

        panel.add(countValue);

        panel.add(
                Box.createVerticalStrut(10)
        );

        panel.add(averageValue);

        panel.add(
                Box.createVerticalStrut(10)
        );

        panel.add(highestValue);

        panel.add(
                Box.createVerticalStrut(10)
        );

        panel.add(lowestValue);

        panel.add(
                Box.createVerticalStrut(15)
        );

        // DELETE BUTTON
        JButton deleteButton =
                createButton(
                        "Delete Selected",
                        RED
                );

        deleteButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        deleteButton.addActionListener(
                e -> deleteSelectedStudent()
        );

        panel.add(
                Box.createVerticalGlue()
        );

        panel.add(deleteButton);

        return panel;
    }

    // ===================== STATISTIC CARD =====================

    private JLabel createStatisticCard(
            String heading,
            String value
    ) {

        JLabel label =
                new JLabel();

        label.setOpaque(true);

        label.setBackground(
                new Color(
                        30, 41, 59
                )
        );

        label.setForeground(WHITE);

        label.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        label.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        label.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        72
                )
        );

        label.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(
                                new Color(
                                        71, 85, 105
                                ),
                                1,
                                true
                        ),
                        BorderFactory.createEmptyBorder(
                                8, 5, 8, 5
                        )
                )
        );

        setStatistic(
                label,
                heading,
                value
        );

        return label;
    }

    // ===================== UPDATE STATISTICS =====================

    private void updateStatistics() {

        // NO STUDENTS
        if (students.isEmpty()) {

            setStatistic(
                    countValue,
                    "TOTAL STUDENTS",
                    "0"
            );

            setStatistic(
                    averageValue,
                    "CLASS AVERAGE",
                    "0.00"
            );

            setStatistic(
                    highestValue,
                    "HIGHEST SCORE",
                    "0.00"
            );

            setStatistic(
                    lowestValue,
                    "LOWEST SCORE",
                    "0.00"
            );

            return;
        }

        double total = 0;

        double highest =
                students.get(0).marks;

        double lowest =
                students.get(0).marks;

        // Calculate total, highest and lowest.
        for (Student student : students) {

            total += student.marks;

            if (student.marks > highest) {
                highest = student.marks;
            }

            if (student.marks < lowest) {
                lowest = student.marks;
            }
        }

        // Calculate average.
        double average =
                total / students.size();

        setStatistic(
                countValue,
                "TOTAL STUDENTS",
                String.valueOf(
                        students.size()
                )
        );

        setStatistic(
                averageValue,
                "CLASS AVERAGE",
                String.format(
                        "%.2f",
                        average
                )
        );

        setStatistic(
                highestValue,
                "HIGHEST SCORE",
                String.format(
                        "%.2f",
                        highest
                )
        );

        setStatistic(
                lowestValue,
                "LOWEST SCORE",
                String.format(
                        "%.2f",
                        lowest
                )
        );
    }

    // ===================== SET STATISTIC =====================

    private void setStatistic(
            JLabel label,
            String heading,
            String value
    ) {

        label.setText(
                "<html>"
                        + "<div style='text-align:center'>"
                        + "<span style='font-size:10px;"
                        + "color:#cbd5e1'>"
                        + heading
                        + "</span>"
                        + "<br>"
                        + "<span style='font-size:21px;"
                        + "font-weight:bold'>"
                        + value
                        + "</span>"
                        + "</div>"
                        + "</html>"
        );
    }

    // ===================== ADD STUDENT =====================

    private void addStudent() {

        String name =
                nameField.getText().trim();

        String marksText =
                marksField.getText().trim();

        // CHECK EMPTY FIELDS
        if (name.isEmpty()
                || marksText.isEmpty()) {

            showMessage(
                    "Please enter both student name and marks.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // CHECK NAME
        if (!name.matches(
                "[a-zA-Z][a-zA-Z .'-]*"
        )) {

            showMessage(
                    "Please enter a valid student name.",
                    "Invalid Name",
                    JOptionPane.WARNING_MESSAGE
            );

            nameField.requestFocus();

            return;
        }

        double marks;

        // CONVERT MARKS
        try {

            marks =
                    Double.parseDouble(
                            marksText
                    );

        } catch (NumberFormatException e) {

            showMessage(
                    "Marks must be a valid number.",
                    "Invalid Marks",
                    JOptionPane.ERROR_MESSAGE
            );

            marksField.requestFocus();

            return;
        }

        // CHECK MARK RANGE
        if (marks < 0 || marks > 100) {

            showMessage(
                    "Marks must be between 0 and 100.",
                    "Invalid Marks",
                    JOptionPane.WARNING_MESSAGE
            );

            marksField.requestFocus();

            return;
        }

        // CREATE STUDENT OBJECT
        Student student =
                new Student(
                        name,
                        marks
                );

        // STORE IN ARRAYLIST
        students.add(student);

        // UPDATE DISPLAY
        updateTable();

        updateStatistics();

        // UPDATE SUMMARY
        summaryLabel.setText(
                "✓ " + name
                        + " added successfully."
        );

        summaryLabel.setForeground(
                GREEN
        );

        // CLEAR INPUT
        clearFields();
    }

    // ===================== UPDATE TABLE =====================

    private void updateTable() {

        tableModel.setRowCount(0);

        for (int i = 0;
             i < students.size();
             i++) {

            Student student =
                    students.get(i);

            tableModel.addRow(
                    new Object[]{
                            i + 1,
                            student.name,
                            String.format(
                                    "%.2f",
                                    student.marks
                            ),
                            student.getGrade(),
                            student.getPerformance()
                    }
            );
        }
    }

    // ===================== DELETE STUDENT =====================

    private void deleteSelectedStudent() {

        int selectedRow =
                studentTable.getSelectedRow();

        if (selectedRow == -1) {

            showMessage(
                    "Please select a student from the table.",
                    "No Student Selected",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String studentName =
                students.get(
                        selectedRow
                ).name;

        int choice =
                JOptionPane.showConfirmDialog(
                        this,
                        "Delete " + studentName
                                + "'s record?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

        if (choice ==
                JOptionPane.YES_OPTION) {

            students.remove(
                    selectedRow
            );

            updateTable();

            updateStatistics();

            summaryLabel.setText(
                    "✓ " + studentName
                            + " removed."
            );

            summaryLabel.setForeground(
                    ORANGE
            );
        }
    }

    // ===================== CLEAR FIELDS =====================

    private void clearFields() {

        nameField.setText("");

        marksField.setText("");

        nameField.requestFocus();

        summaryLabel.setText(
                "Ready to add a new student."
        );

        summaryLabel.setForeground(
                GRAY
        );
    }

    // ===================== CARD PANEL =====================

    private JPanel createCardPanel() {

        JPanel panel =
                new JPanel();

        panel.setBackground(WHITE);

        panel.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(
                                BORDER,
                                1,
                                true
                        ),
                        BorderFactory.createEmptyBorder(
                                15, 16, 15, 16
                        )
                )
        );

        return panel;
    }

    // ===================== FORM LABEL =====================

    private JLabel createLabel(
            String text
    ) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        label.setForeground(TEXT);

        return label;
    }

    // ===================== TEXT FIELD =====================

    private JTextField createTextField(
            String tooltip
    ) {

        JTextField field =
                new JTextField();

        field.setPreferredSize(
                new Dimension(
                        150,
                        38
                )
        );

        field.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13
                )
        );

        field.setToolTipText(tooltip);

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(
                                new Color(
                                        203, 213, 225
                                ),
                                1,
                                true
                        ),
                        BorderFactory.createEmptyBorder(
                                5, 10, 5, 10
                        )
                )
        );

        return field;
    }

    // ===================== BUTTON =====================

    private JButton createButton(
            String text,
            Color color
    ) {

        JButton button =
                new JButton(text);

        button.setPreferredSize(
                new Dimension(
                        140,
                        38
                )
        );

        button.setBackground(color);

        button.setForeground(WHITE);

        button.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12
                )
        );

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        return button;
    }

    // ===================== FOOTER =====================

    private JPanel createFooter() {

        JPanel footer =
                new JPanel(
                        new BorderLayout()
                );

        footer.setBackground(WHITE);

        footer.setBorder(
                BorderFactory.createCompoundBorder(
                        new MatteBorder(
                                1, 0, 0, 0,
                                BORDER
                        ),
                        BorderFactory.createEmptyBorder(
                                8, 20, 8, 20
                        )
                )
        );

        summaryLabel =
                new JLabel(
                        "Ready to add a new student."
                );

        summaryLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12
                )
        );

        summaryLabel.setForeground(GRAY);

        JLabel footerText =
                new JLabel(
                        "Student Grade Manager"
                );

        footerText.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11
                )
        );

        footerText.setForeground(GRAY);

        footer.add(
                summaryLabel,
                BorderLayout.WEST
        );

        footer.add(
                footerText,
                BorderLayout.EAST
        );

        return footer;
    }

    // ===================== MESSAGE BOX =====================

    private void showMessage(
            String message,
            String title,
            int type
    ) {

        JOptionPane.showMessageDialog(
                this,
                message,
                title,
                type
        );
    }

    // ===================== STUDENT CLASS =====================

    static class Student {

        String name;
        double marks;

        Student(
                String name,
                double marks
        ) {

            this.name = name;
            this.marks = marks;
        }

        // Determine grade.
        String getGrade() {

            if (marks >= 90)
                return "A+";

            if (marks >= 80)
                return "A";

            if (marks >= 70)
                return "B";

            if (marks >= 60)
                return "C";

            if (marks >= 50)
                return "D";

            return "F";
        }

        // Determine performance.
        String getPerformance() {

            if (marks >= 90)
                return "Excellent";

            if (marks >= 80)
                return "Very Good";

            if (marks >= 70)
                return "Good";

            if (marks >= 60)
                return "Average";

            if (marks >= 50)
                return "Needs Improvement";

            return "Fail";
        }
    }

    // ===================== MAIN METHOD =====================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(() -> {

            try {

                UIManager.setLookAndFeel(
                        UIManager
                                .getSystemLookAndFeelClassName()
                );

            } catch (Exception ignored) {
            }

            StudentGradeManager app =
                    new StudentGradeManager();

            app.setVisible(true);
        });
    }
}