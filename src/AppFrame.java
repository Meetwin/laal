import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.AbstractBorder;

public class AppFrame extends JFrame implements ActionListener {
    private JLabel startLabel;
    private JLabel stopLabel;
    private JLabel routeLabel;
    private JButton findRouteButton;
    private JButton clearButton;
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel resultPanel;
    private JComboBox<String> startComboBox;
    private JComboBox<String> endComboBox;
    private JTextArea resultArea;
    private JScrollPane scrollPane;
    private Graph graph;
    private Map<String, Nodes> locationNodes;

    // Modern color palette
    private static final Color DARK_BG = new Color(26, 26, 46);
    private static final Color CARD_BG = new Color(35, 35, 55);
    private static final Color ACCENT_BLUE = new Color(79, 172, 254);
    private static final Color ACCENT_GREEN = new Color(34, 197, 94);
    private static final Color ACCENT_RED = new Color(239, 68, 68);
    private static final Color TEXT_PRIMARY = new Color(248, 250, 252);
    private static final Color TEXT_SECONDARY = new Color(148, 163, 184);
    private static final Color BORDER_COLOR = new Color(51, 65, 85);

    public AppFrame() {
        initializeGraph();
        setupUI();
    }

    private void initializeGraph() {
        graph = new Graph(true);
        locationNodes = new HashMap<>();

        Nodes engineeringSchool = new Nodes(0, "Engineering School");
        Nodes csDept = new Nodes(1, "CS Department");
        Nodes lawFaculty = new Nodes(2, "Law Faculty");
        Nodes jqb = new Nodes(3, "JQB");
        Nodes mainGate = new Nodes(4, "Main Gate");
        Nodes performingArts = new Nodes(5, "School of Performing Arts");
        Nodes mathDept = new Nodes(6, "Math Department");
        Nodes balmeLibrary = new Nodes(7, "Balme Library");
        Nodes ugcs = new Nodes(8, "UGCS");
        Nodes businessSchool = new Nodes(9, "Business School");
        Nodes voltaHall = new Nodes(10, "Volta Hall");
        Nodes commonwealth = new Nodes(11, "Commonwealth");
        Nodes greatHall = new Nodes(12, "Great Hall");
        Nodes akuafoHall = new Nodes(13, "Akuafo Hall");
        Nodes legonHall = new Nodes(14, "Legon Hall");
        Nodes bushCanteen = new Nodes(15, "Bush Canteen");
        Nodes sarbahPark = new Nodes(16, "Sarbah Park");
        Nodes fireStation = new Nodes(17, "Fire Station");
        Nodes bankingSquare = new Nodes(18, "Banking Square");
        Nodes nightMarket = new Nodes(19, "Night Market");
        Nodes basicSchool = new Nodes(20, "Basic School");
        Nodes diasporaHalls = new Nodes(21, "Diaspora Halls");

        locationNodes.put("Engineering School", engineeringSchool);
        locationNodes.put("CS Department", csDept);
        locationNodes.put("Law Faculty", lawFaculty);
        locationNodes.put("JQB", jqb);
        locationNodes.put("Main Gate", mainGate);
        locationNodes.put("School of Performing Arts", performingArts);
        locationNodes.put("Math Department", mathDept);
        locationNodes.put("Balme Library", balmeLibrary);
        locationNodes.put("UGCS", ugcs);
        locationNodes.put("Business School", businessSchool);
        locationNodes.put("Volta Hall", voltaHall);
        locationNodes.put("Commonwealth", commonwealth);
        locationNodes.put("Great Hall", greatHall);
        locationNodes.put("Akuafo Hall", akuafoHall);
        locationNodes.put("Legon Hall", legonHall);
        locationNodes.put("Bush Canteen", bushCanteen);
        locationNodes.put("Sarbah Park", sarbahPark);
        locationNodes.put("Fire Station", fireStation);
        locationNodes.put("Banking Square", bankingSquare);
        locationNodes.put("Night Market", nightMarket);
        locationNodes.put("Basic School", basicSchool);
        locationNodes.put("Diaspora Halls", diasporaHalls);

        addEdgesToGraph();
    }

    private void addEdgesToGraph() {
        graph.addEdge(locationNodes.get("Engineering School"), locationNodes.get("CS Department"), 270.12);
        graph.addEdge(locationNodes.get("Engineering School"), locationNodes.get("Law Faculty"), 420.88);
        graph.addEdge(locationNodes.get("Engineering School"), locationNodes.get("JQB"), 502.43);
        graph.addEdge(locationNodes.get("CS Department"), locationNodes.get("Law Faculty"), 346.45);
        graph.addEdge(locationNodes.get("Law Faculty"), locationNodes.get("JQB"), 289.39);
        graph.addEdge(locationNodes.get("CS Department"), locationNodes.get("Math Department"), 208.65);
        graph.addEdge(locationNodes.get("Math Department"), locationNodes.get("UGCS"), 653.88);
        graph.addEdge(locationNodes.get("UGCS"), locationNodes.get("Business School"), 407.81);
        graph.addEdge(locationNodes.get("Business School"), locationNodes.get("Volta Hall"), 346.82);
        graph.addEdge(locationNodes.get("Volta Hall"), locationNodes.get("Commonwealth"), 536.69);
        graph.addEdge(locationNodes.get("Commonwealth"), locationNodes.get("Great Hall"), 586.81);
        graph.addEdge(locationNodes.get("Main Gate"), locationNodes.get("School of Performing Arts"), 50.00);
        graph.addEdge(locationNodes.get("School of Performing Arts"), locationNodes.get("Balme Library"), 992.04);
        graph.addEdge(locationNodes.get("UGCS"), locationNodes.get("Balme Library"), 269.71);
        graph.addEdge(locationNodes.get("Balme Library"), locationNodes.get("Akuafo Hall"), 316.59);
        graph.addEdge(locationNodes.get("Balme Library"), locationNodes.get("Commonwealth"), 520);
        graph.addEdge(locationNodes.get("School of Performing Arts"), locationNodes.get("Akuafo Hall"), 701.74);
        graph.addEdge(locationNodes.get("Balme Library"), locationNodes.get("Legon Hall"), 586.81);
        graph.addEdge(locationNodes.get("Legon Hall"), locationNodes.get("Akuafo Hall"), 100);
        graph.addEdge(locationNodes.get("Legon Hall"), locationNodes.get("Basic School"), 1015.00);
        graph.addEdge(locationNodes.get("Legon Hall"), locationNodes.get("Sarbah Park"), 500.00);
        graph.addEdge(locationNodes.get("Akuafo Hall"), locationNodes.get("Sarbah Park"), 200.00);
        graph.addEdge(locationNodes.get("Basic School"), locationNodes.get("Night Market"), 591.36);
        graph.addEdge(locationNodes.get("Night Market"), locationNodes.get("Diaspora Halls"), 645.28);
        graph.addEdge(locationNodes.get("Night Market"), locationNodes.get("Banking Square"), 957.14);
        graph.addEdge(locationNodes.get("Bush Canteen"), locationNodes.get("Fire Station"), 122.85);
        graph.addEdge(locationNodes.get("Fire Station"), locationNodes.get("Banking Square"), 957.14);
        
        graph.addEdge(locationNodes.get("Main Gate"), locationNodes.get("Engineering School"), 800.00);
        graph.addEdge(locationNodes.get("Main Gate"), locationNodes.get("JQB"), 750.00);
        graph.addEdge(locationNodes.get("JQB"), locationNodes.get("Math Department"), 400.00);
        graph.addEdge(locationNodes.get("Great Hall"), locationNodes.get("Akuafo Hall"), 300.00);
        graph.addEdge(locationNodes.get("Great Hall"), locationNodes.get("Legon Hall"), 400.00);
        graph.addEdge(locationNodes.get("Sarbah Park"), locationNodes.get("Bush Canteen"), 350.00);
        graph.addEdge(locationNodes.get("Diaspora Halls"), locationNodes.get("Basic School"), 800.00);
        graph.addEdge(locationNodes.get("Banking Square"), locationNodes.get("Bush Canteen"), 600.00);
    }

    private void setupUI() {
        frame = new JFrame("UG Navigate - Smart Campus Navigation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(DARK_BG);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        mainPanel.setBackground(DARK_BG);

        JPanel headerPanel = createHeaderPanel();
        JPanel inputPanel = createInputPanel();
        resultPanel = createResultPanel();

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.WEST);
        mainPanel.add(resultPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(DARK_BG);
        
        JLabel titleLabel = new JLabel("🗺️ UG NAVIGATE");
        titleLabel.setFont(new Font("SF Pro Display", Font.BOLD, 32));
        titleLabel.setForeground(TEXT_PRIMARY);
        
        JLabel subtitleLabel = new JLabel("Intelligent Campus Route Optimization");
        subtitleLabel.setFont(new Font("SF Pro Text", Font.PLAIN, 16));
        subtitleLabel.setForeground(TEXT_SECONDARY);
        
        JPanel titleContainer = new JPanel(new BorderLayout());
        titleContainer.setBackground(DARK_BG);
        titleContainer.add(titleLabel, BorderLayout.CENTER);
        titleContainer.add(subtitleLabel, BorderLayout.SOUTH);
        
        panel.add(titleContainer);
        return panel;
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(CARD_BG);
        panel.setBorder(new ModernBorder());
        panel.setPreferredSize(new Dimension(350, 500));

        // Title section
        JPanel titleSection = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titleSection.setBackground(CARD_BG);
        JLabel sectionTitle = new JLabel("🎯 Route Configuration");
        sectionTitle.setFont(new Font("SF Pro Display", Font.BOLD, 18));
        sectionTitle.setForeground(TEXT_PRIMARY);
        titleSection.add(sectionTitle);
        panel.add(titleSection);
        
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        String[] locations = {"Select a location", "Engineering School", "CS Department", "Math Department", 
                             "Law Faculty", "JQB", "Main Gate", "School of Performing Arts", "Balme Library", 
                             "UGCS", "Business School", "Volta Hall", "Commonwealth", "Great Hall", 
                             "Akuafo Hall", "Legon Hall", "Bush Canteen", "Sarbah Park", "Fire Station", 
                             "Banking Square", "Night Market", "Basic School", "Diaspora Halls"};
        
        String[] accessibilityTypes = {"Standard", "Wheelchair", "Elderly", "Visually Impaired", "Mobility Impaired"};

        // Starting location
        JPanel startPanel = createInputField("📍 Starting Location", locations);
        startComboBox = (JComboBox<String>) startPanel.getComponent(1);
        panel.add(startPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Destination
        JPanel endPanel = createInputField("🎯 Destination", locations);
        endComboBox = (JComboBox<String>) endPanel.getComponent(1);
        panel.add(endPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Accessibility
        JPanel accessibilityPanel = createInputField("♿ Accessibility Type", accessibilityTypes);
        panel.add(accessibilityPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Time selection
        String[] timeOptions = {"Current Time", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM"};
        JPanel timePanel = createInputField("⏰ Departure Time", timeOptions);
        panel.add(timePanel);
        panel.add(Box.createRigidArea(new Dimension(0, 25)));

        // Action buttons
        JPanel buttonPanel = createButtonPanel();
        panel.add(buttonPanel);

        return panel;
    }

    private JPanel createInputField(String labelText, String[] options) {
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
        fieldPanel.setBackground(CARD_BG);
        fieldPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("SF Pro Text", Font.PLAIN, 14));
        label.setForeground(TEXT_PRIMARY);
        label.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 0));

        JComboBox<String> comboBox = new JComboBox<>(options);
        styleComboBox(comboBox);

        fieldPanel.add(label);
        fieldPanel.add(comboBox);

        return fieldPanel;
    }

    private void styleComboBox(JComboBox<String> comboBox) {
        comboBox.setPreferredSize(new Dimension(300, 40));
        comboBox.setMaximumSize(new Dimension(300, 40));
        comboBox.setBackground(DARK_BG);
        comboBox.setForeground(TEXT_PRIMARY);
        comboBox.setFont(new Font("SF Pro Text", Font.PLAIN, 13));
        comboBox.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_COLOR, 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        comboBox.setFocusable(false);
        
        // Custom renderer for dropdown items
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setBackground(isSelected ? ACCENT_BLUE : DARK_BG);
                setForeground(TEXT_PRIMARY);
                setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
                return this;
            }
        });
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(CARD_BG);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        findRouteButton = createModernButton("🚀 Find Optimal Route", ACCENT_GREEN);
        clearButton = createModernButton("🗑️ Clear Results", ACCENT_RED);

        findRouteButton.addActionListener(this);
        clearButton.addActionListener(this);
        
        buttonPanel.add(findRouteButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(clearButton);

        addButtonHoverEffects();

        return buttonPanel;
    }

    private JButton createModernButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("SF Pro Text", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        button.setPreferredSize(new Dimension(300, 45));
        button.setMaximumSize(new Dimension(300, 45));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Rounded corners effect
        button.setOpaque(true);
        button.setBorderPainted(false);
        
        return button;
    }

    private JPanel createResultPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(CARD_BG);
        panel.setBorder(new ModernBorder());

        // Header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(CARD_BG);
        JLabel headerLabel = new JLabel("📊 Route Analysis Dashboard");
        headerLabel.setFont(new Font("SF Pro Display", Font.BOLD, 18));
        headerLabel.setForeground(TEXT_PRIMARY);
        headerPanel.add(headerLabel);
        panel.add(headerPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setBackground(DARK_BG);
        resultArea.setForeground(TEXT_PRIMARY);
        resultArea.setCaretColor(TEXT_PRIMARY);
        resultArea.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        scrollPane = new JScrollPane(resultArea);
        scrollPane.setBackground(DARK_BG);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setBackground(CARD_BG);
        scrollPane.getHorizontalScrollBar().setBackground(CARD_BG);
        
        // Style scrollbars
        scrollPane.getVerticalScrollBar().setUI(new ModernScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new ModernScrollBarUI());

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // Custom border class for modern look
    private class ModernBorder extends AbstractBorder {
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(BORDER_COLOR);
            g2.setStroke(new BasicStroke(1));
            g2.drawRoundRect(x, y, width - 1, height - 1, 12, 12);
            g2.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(20, 20, 20, 20);
        }
    }

    // Custom scrollbar UI
    private class ModernScrollBarUI extends javax.swing.plaf.basic.BasicScrollBarUI {
        @Override
        protected void configureScrollBarColors() {
            this.thumbColor = BORDER_COLOR;
            this.trackColor = CARD_BG;
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            return button;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == findRouteButton) {
            findRoute();
        } else if (e.getSource() == clearButton) {
            clearResults();
        }
    }

    private void findRoute() {
        try {
            String startLocation = startComboBox.getSelectedItem().toString();
            String endLocation = endComboBox.getSelectedItem().toString();

            if (startLocation.equals("Select a location") || endLocation.equals("Select a location")) {
                showModernDialog("Please select both starting and destination locations.", 
                 "Selection Required", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (startLocation.equals(endLocation)) {
                showModernDialog("Starting and destination locations must be different.", 
                     "Invalid Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Nodes startNode = locationNodes.get(startLocation);
            Nodes endNode = locationNodes.get(endLocation);

            if (startNode == null || endNode == null) {
                showModernDialog("Invalid location selected.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            RouteOptimizer.RouteAnalysis analysis = RouteOptimizer.findOptimalRoutes(graph, startNode, endNode, new ArrayList<>());
            displayResults(analysis, startLocation, endLocation);

        } catch (Exception ex) {
            showModernDialog("An error occurred while finding the route: " + ex.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void showModernDialog(String message, String title, int messageType) {
        UIManager.put("OptionPane.background", CARD_BG);
        UIManager.put("Panel.background", CARD_BG);
        UIManager.put("OptionPane.messageForeground", TEXT_PRIMARY);
        JOptionPane.showMessageDialog(frame, message, title, messageType);
    }

    private void displayResults(RouteOptimizer.RouteAnalysis analysis, String startLocation, String endLocation) {
        StringBuilder result = new StringBuilder();
        result.append("╭─────────────────────────────────────────────────────────╮\n");
        result.append("│              🗺️  UG CAMPUS ROUTE ANALYSIS               │\n");
        result.append("╰─────────────────────────────────────────────────────────╯\n\n");
        result.append("🚀 FROM: ").append(startLocation).append("\n");
        result.append("🎯 TO: ").append(endLocation).append("\n");
        result.append("⏰ ANALYSIS TIME: ").append(java.time.LocalTime.now().toString()).append("\n\n");

        if (analysis.optimalRoute != null) {
            result.append("╭─ 🌟 OPTIMAL ROUTE ─────────────────────────────────────╮\n");
            result.append("│ Algorithm: ").append(analysis.optimalRoute.algorithm).append("\n");
            result.append("│ Path: ").append(String.join(" → ", analysis.optimalRoute.path)).append("\n");
            result.append("│ Distance: ").append(String.format("%.2f", analysis.optimalRoute.distance)).append(" meters\n");
            result.append("│ Base Time: ").append(String.format("%.1f", analysis.optimalRoute.time)).append(" seconds\n");
            result.append("│ Base Time: ").append(String.format("%.1f", analysis.optimalRoute.time / 60)).append(" minutes\n");
            result.append("╰─────────────────────────────────────────────────────────╯\n\n");
            
            TrafficSimulator.TimeBasedRoute trafficRoute = TrafficSimulator.optimizeForTime(
                analysis.optimalRoute.path, analysis.optimalRoute.distance, analysis.optimalRoute.time, 
                java.time.LocalTime.now());
            result.append("🚦 TRAFFIC-ADJUSTED TIME: ").append(String.format("%.1f", trafficRoute.trafficAdjustedTime)).append(" seconds\n");
            result.append("💡 RECOMMENDATION: ").append(trafficRoute.recommendedTime).append("\n\n");
            
            WeatherIntegration.WeatherAdjustedRoute weatherRoute = WeatherIntegration.adjustRouteForWeather(
                analysis.optimalRoute.path, analysis.optimalRoute.distance, analysis.optimalRoute.time);
            result.append("🌤️ WEATHER-ADJUSTED TIME: ").append(String.format("%.1f", weatherRoute.weatherAdjustedTime)).append(" seconds\n");
            result.append("🌡️ WEATHER IMPACT: ").append(weatherRoute.weatherImpact).append("\n\n");
            
            AccessibilityFeatures.AccessibilityRoute accessibleRoute = AccessibilityFeatures.createAccessibleRoute(
                analysis.optimalRoute.path, analysis.optimalRoute.distance, analysis.optimalRoute.time, "standard");
            result.append("♿ ACCESSIBILITY-ADJUSTED TIME: ").append(String.format("%.1f", accessibleRoute.time)).append(" seconds\n");
            result.append("📊 ACCESSIBILITY SCORE: ").append(String.format("%.2f", accessibleRoute.accessibilityScore)).append("\n\n");
        } else {
            result.append("❌ No route found between the selected locations.\n\n");
        }

        if (!analysis.routes.isEmpty()) {
            result.append("╭─ 🔄 ALTERNATIVE ROUTES ───────────────────────────────╮\n");
            for (int i = 0; i < Math.min(3, analysis.routes.size()); i++) {
                SortingAlgorithms.Route route = analysis.routes.get(i);
                result.append("│ ").append(i + 1).append(". ").append(route.algorithm).append(":\n");
                result.append("│    Path: ").append(String.join(" → ", route.path)).append("\n");
                result.append("│    Distance: ").append(String.format("%.2f", route.distance)).append("m\n");
                result.append("│    Time: ").append(String.format("%.1f", route.time)).append("s\n");
                if (i < Math.min(3, analysis.routes.size()) - 1) result.append("│\n");
            }
            result.append("╰─────────────────────────────────────────────────────────╯\n\n");
        }

        if (!analysis.algorithmPerformance.isEmpty()) {
            result.append("⚡ ALGORITHM PERFORMANCE ANALYSIS:\n");
            for (Map.Entry<String, Double> entry : analysis.algorithmPerformance.entrySet()) {
                result.append("• ").append(entry.getKey()).append(": ").append(entry.getValue()).append("ms\n");
            }
            result.append("\n");
        }

        if (analysis.optimalRoute != null) {
            result.append("🌤️ WEATHER ANALYSIS:\n");
            result.append(WeatherIntegration.generateWeatherReport(analysis.optimalRoute.path));
            
            result.append("♿ ACCESSIBILITY FEATURES:\n");
            AccessibilityFeatures.AccessibilityRoute accessibleRoute = AccessibilityFeatures.createAccessibleRoute(
                analysis.optimalRoute.path, analysis.optimalRoute.distance, analysis.optimalRoute.time, "standard");
            for (String feature : accessibleRoute.features) {
                result.append("• ").append(feature).append("\n");
            }
            result.append("\n");
            
            result.append("🚦 TRAFFIC ANALYSIS:\n");
            result.append(TrafficSimulator.generateTrafficReport(analysis.optimalRoute.path, java.time.LocalTime.now()));
        }

        result.append("🏛️ CAMPUS LANDMARKS & FACILITIES:\n");
        if (analysis.optimalRoute != null) {
            for (String location : analysis.optimalRoute.path) {
                if (location.contains("Library")) {
                    result.append("📚 ").append(location).append(" (Study Area)\n");
                } else if (location.contains("Canteen")) {
                    result.append("🍽️ ").append(location).append(" (Food & Refreshments)\n");
                } else if (location.contains("Park")) {
                    result.append("🌳 ").append(location).append(" (Recreation Area)\n");
                } else if (location.contains("Bank")) {
                    result.append("🏦 ").append(location).append(" (Financial Services)\n");
                } else if (location.contains("Market")) {
                    result.append("🛒 ").append(location).append(" (Shopping Area)\n");
                } else if (location.contains("Station")) {
                    result.append("🚒 ").append(location).append(" (Emergency Services)\n");
                } else if (location.contains("Hall")) {
                    result.append("🏠 ").append(location).append(" (Student Accommodation)\n");
                } else if (location.contains("School") || location.contains("Department")) {
                    result.append("🎓 ").append(location).append(" (Academic Building)\n");
                }
            }
        }

        result.append("\n💡 SMART RECOMMENDATIONS:\n");
        if (analysis.optimalRoute != null) {
            List<String> weatherRecs = WeatherIntegration.getWeatherRecommendations(analysis.optimalRoute.path);
            List<String> accessibilityRecs = AccessibilityFeatures.getAccessibilityRecommendations(analysis.optimalRoute.path, "standard");
            
            for (String rec : weatherRecs) {
                result.append("• ").append(rec).append("\n");
            }
            for (String rec : accessibilityRecs) {
                result.append("• ").append(rec).append("\n");
            }
        }

        resultArea.setText(result.toString());
        resultArea.setCaretPosition(0);
    }

    private void clearResults() {
        resultArea.setText("");
        startComboBox.setSelectedIndex(0);
        endComboBox.setSelectedIndex(0);
    }
    
    private void addButtonHoverEffects() {
        findRouteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                findRouteButton.setBackground(new Color(22, 163, 74)); // Darker green
                findRouteButton.repaint();
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                findRouteButton.setBackground(ACCENT_GREEN);
                findRouteButton.repaint();
            }
        });
        
        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearButton.setBackground(new Color(220, 38, 38)); // Darker red
                clearButton.repaint();
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearButton.setBackground(ACCENT_RED);
                clearButton.repaint();
            }
        });
    }
}