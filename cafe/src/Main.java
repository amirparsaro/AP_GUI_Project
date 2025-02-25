// سلام! آدرس فولدر assets تون رو توی خط 173 بذارین

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main {
    public static JButton imageButtonRenderer(ImageIcon img, JPanel panel, int block, int viewPortWidth, int heightBlock) {
        Image scaledImage = img.getImage().getScaledInstance(2 * block, 2 * block, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JButton button = new JButton(scaledIcon);
        button.setBounds(viewPortWidth / 2 - block, heightBlock * block, 2 * block, 2 * block);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        panel.add(button);
        return button;
    }

    public static void labelRenderer(JLabel label, JPanel panel, int viewPortWidth,
                                     int block, int heightBlock, Font font) {
        label.setFont(font);
        label.setSize(label.getPreferredSize());
        label.setForeground(new Color(61, 44, 30));
        int labelWidth = label.getWidth();
        int labelHeight = label.getHeight();
        label.setBounds(viewPortWidth / 2 - labelWidth / 2, block * heightBlock, labelWidth + 100, labelHeight);
        panel.add(label);
    }

    public static JButton[] itemPanelRenderer(JPanel panel, JPanel parentPanel, int viewPortWidth, int block, int heightBlock, String imagePath,
                                              String label, String price, Font font, Font buttonFont, String filePath, int itemAmount) {
        panel.setLayout(null);
        panel.setBounds(10, heightBlock * block, viewPortWidth - 30, (int) (2.5 * block));
        panel.setBackground(new Color(234, 215, 187));

        JLabel itemLabel = new JLabel(label);
        itemLabel.setSize(itemLabel.getPreferredSize());
        itemLabel.setFont(font);
        int labelWidth = itemLabel.getWidth();
        int labelHeight = itemLabel.getHeight();
        itemLabel.setBounds(viewPortWidth - labelWidth - 100 - 30, 20, labelWidth + 100, labelHeight + 10);

        ImageIcon img = new ImageIcon(imagePath);
        Image scaledImage = img.getImage().getScaledInstance(2 * block, 2 * block, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel itemIcon = new JLabel(scaledIcon);
        itemIcon.setBounds(15, 15, 2 * block, 2 * block);

        JLabel itemPrice = new JLabel(price);
        itemPrice.setSize(itemLabel.getPreferredSize());
        itemPrice.setFont(font);
        int priceWidth = itemPrice.getWidth();
        int priceHeight = itemPrice.getHeight();
        itemPrice.setBounds(viewPortWidth - priceWidth / 2 - 70, 50, priceWidth + 100, priceHeight + 10);

        ImageIcon imgAdd = new ImageIcon(filePath + "/plus.png");
        Image scaledImageAdd = imgAdd.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIconAdd = new ImageIcon(scaledImageAdd);
        JButton addButton = new JButton(scaledIconAdd);
        addButton.setBounds(viewPortWidth - 50 - 40, 90, 50, 35);
        addButton.setBackground(new Color(139, 94, 59));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(buttonFont);
        addButton.setBorderPainted(false);
        addButton.setFocusPainted(false);
        panel.add(addButton);

        ImageIcon imgMinus = new ImageIcon(filePath + "/minus.png");
        Image scaledImageMinus = imgMinus.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIconMinus = new ImageIcon(scaledImageMinus);
        JButton subtractButton = new JButton(scaledIconMinus);
        subtractButton.setBounds(viewPortWidth - 110 - 40, 90, 50, 35);
        subtractButton.setBackground(new Color(139, 94, 59));
        subtractButton.setForeground(Color.WHITE);
        subtractButton.setFont(buttonFont);
        subtractButton.setBorderPainted(false);
        subtractButton.setFocusPainted(false);
        panel.add(subtractButton);

        panel.add(itemPrice);
        panel.add(itemIcon);
        panel.add(itemLabel);
        parentPanel.add(panel);

        JButton[] changeAmountButtons = new JButton[2];
        changeAmountButtons[0] = addButton;
        changeAmountButtons[1] = subtractButton;
        return changeAmountButtons;
    }

    public static void itemCartPanelRenderer(JPanel panel, JPanel parentPanel, int viewPortWidth, int block,
                                             int heightBlock, String imagePath, String label, String price, Font font, Font buttonFont, int itemNum, int amount) {
        panel.setLayout(null);
        if (itemNum % 2 == 0) {
            panel.setBounds(10, heightBlock, viewPortWidth / 2 - 30, (int) (2.5 * block) - 10);
        } else {
            panel.setBounds(viewPortWidth / 2 + 10, heightBlock, viewPortWidth / 2 - 30, (int) (2.5 * block) - 10);
        }
        panel.setBackground(new Color(234, 215, 187));

        JLabel itemLabel = new JLabel(label);
        itemLabel.setSize(itemLabel.getPreferredSize());
        itemLabel.setFont(font);
        int labelWidth = itemLabel.getPreferredSize().width;
        int labelHeight = itemLabel.getPreferredSize().height;
        itemLabel.setBounds((viewPortWidth / 2 - 30) / 2 - labelWidth / 2, (int) (block * 3 - 140), labelWidth * 3, labelHeight + 100);

        ImageIcon img = new ImageIcon(imagePath);
        Image scaledImage = img.getImage().getScaledInstance(block, block, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel itemIcon = new JLabel(scaledIcon);
        itemIcon.setBounds((viewPortWidth / 2 - 30) / 2 - block / 2, 10, block, block);

        JLabel itemPrice = new JLabel(price + " ت");
        itemPrice.setSize(itemLabel.getPreferredSize());
        itemPrice.setFont(font);
        int priceWidth = itemPrice.getPreferredSize().width;
        int priceHeight = itemPrice.getPreferredSize().height;
        itemPrice.setBounds((viewPortWidth / 2 - 30 - priceWidth) / 2 - 70, (int) (block * 3 - 115), priceWidth * 3, priceHeight + 100);

        JLabel itemAmount = new JLabel("تعداد: " + amount);
        itemAmount.setSize(itemLabel.getPreferredSize());
        itemAmount.setFont(font);
        int amountWidth = itemAmount.getPreferredSize().width;
        int amountHeight = itemAmount.getPreferredSize().height;
        itemAmount.setBounds((viewPortWidth / 2 - 30 - amountWidth) / 2 + 70, (int) (block * 3 - 115), amountWidth * 3, amountHeight + 100);

        panel.add(itemPrice);
        panel.add(itemIcon);
        panel.add(itemLabel);
        panel.add(itemAmount);
        parentPanel.add(panel);
    }

    public static JButton returnButtonRenderer(int viewPortWidth, int viewPortHeight, Font font) {
        JButton returnButton = new JButton("صفحه اصلی");
        returnButton.setBounds(viewPortWidth - 130, viewPortHeight - 100, 100, 50);
        returnButton.setBackground(new Color(139, 94, 59));
        returnButton.setForeground(Color.WHITE);
        returnButton.setFont(font);
        returnButton.setBorderPainted(false);
        returnButton.setFocusPainted(false);
        return returnButton;
    }

    public static JButton orderButtonRenderer(int viewPortWidth, int viewPortHeight, Font font) {
        JButton returnButton = new JButton("ثبت سفارش");
        returnButton.setBounds(20, viewPortHeight - 100, 100, 50);
        returnButton.setBackground(new Color(139, 94, 59));
        returnButton.setForeground(Color.WHITE);
        returnButton.setFont(font);
        returnButton.setBorderPainted(false);
        returnButton.setFocusPainted(false);
        return returnButton;
    }

    public static void totalPriceLabelRenderer(JPanel panel, JLabel label, Font font, int viewPortWidth) {
        label.setFont(font);
        label.setSize(label.getPreferredSize());
        label.setForeground(new Color(61, 44, 30));
        int labelWidth = (int) label.getPreferredSize().getWidth();
        int labelHeight = (int) label.getPreferredSize().getHeight();
        label.setBounds(viewPortWidth / 2 - labelWidth / 2, 800 - labelHeight - 75, labelWidth + 100, labelHeight + 10);
        panel.add(label);
    }

    public static void main(String[] args) {
        int[] itemAmount = new int[9];
        JButton[][] cartBtns = new JButton[9][2];
        String filePath = "E:\\java\\tamrin2\\manuela_de_la_cafeiano\\cafe\\assets"; // آدرس فولدر assets تون رو اینجا بذارین
        File yekanFontFile = new File(filePath + "/Yekan.ttf");
        Font yekanFont36;
        try {
            yekanFont36 = Font.createFont(Font.TRUETYPE_FONT, yekanFontFile).deriveFont(36.0f);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        Font yekanFont24;
        try {
            yekanFont24 = Font.createFont(Font.TRUETYPE_FONT, yekanFontFile).deriveFont(24.0f);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        Font yekanFont12;
        try {
            yekanFont12 = Font.createFont(Font.TRUETYPE_FONT, yekanFontFile).deriveFont(12.0f);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        Color bgColor = new Color(250, 243, 224);

        // // Menu Frame & Panels
        int height = 800, width = 600;
        int block = height / 15;
        JFrame menuFrame = new JFrame("Cafe menu");
        menuFrame.setSize(new Dimension(width, height));
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setResizable(false);
        menuFrame.setLayout(null);

        JPanel menuPanel = new JPanel();
        menuFrame.add(menuPanel);
        menuPanel.setLayout(null);
        menuPanel.setBounds(0, 0, width, height);
        menuPanel.setBackground(bgColor);

        // Menu Frame Labels
        JLabel menuLabel = new JLabel("منوی کافه");
        labelRenderer(menuLabel, menuPanel, width, block, 1, yekanFont36);
        JLabel foodLabel = new JLabel("غذا ها");
        labelRenderer(foodLabel, menuPanel, width, block, 5, yekanFont36);
        JLabel beverageLabel = new JLabel("نوشیدنی ها");
        labelRenderer(beverageLabel, menuPanel, width, block, 9, yekanFont36);
        JLabel dessertLabel = new JLabel("دسر ها");
        labelRenderer(dessertLabel, menuPanel, width, block, 13, yekanFont36);

        // Menu Frame buttons
        ImageIcon foodIcon = new ImageIcon("E:/java/tamrin2/manuela_de_la_cafeiano/cafe/assets/food.png");
        JButton foodButton = imageButtonRenderer(foodIcon, menuPanel, block, width, 3);
        ImageIcon beverageIcon = new ImageIcon("E:/java/tamrin2/manuela_de_la_cafeiano/cafe/assets/beverage.png");
        JButton beverageButton = imageButtonRenderer(beverageIcon, menuPanel, block, width, 7);
        ImageIcon dessertIcon = new ImageIcon("E:/java/tamrin2/manuela_de_la_cafeiano/cafe/assets/dessert.png");
        JButton dessertButton = imageButtonRenderer(dessertIcon, menuPanel, block, width, 11);

        ImageIcon shoppingCartImg = new ImageIcon(filePath + "/shopping-cart.png");
        Image scaledCartImg = shoppingCartImg.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledCartIcon = new ImageIcon(scaledCartImg);
        JButton cartButton = new JButton(scaledCartIcon);
        cartButton.setBounds(25, 50, 70, 70);
        cartButton.setBackground(new Color(216, 187, 140));
        cartButton.setForeground(Color.WHITE);
        cartButton.setFont(yekanFont24);
        cartButton.setBorderPainted(false);
        cartButton.setFocusPainted(false);
        menuPanel.add(cartButton);


        // // Food Menu Frame & Panels
        JFrame foodFrame = new JFrame("food menu");
        foodFrame.setSize(new Dimension(width, height));
        foodFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        foodFrame.setResizable(false);
        foodFrame.setLayout(null);

        JPanel foodPanel = new JPanel();
        foodFrame.add(foodPanel);
        foodPanel.setLayout(null);
        foodPanel.setBounds(0, 0, width, height);
        foodPanel.setBackground(bgColor);
        foodFrame.add(foodPanel);

        JLabel foodMainLabel = new JLabel("غذا ها");
        labelRenderer(foodMainLabel, foodPanel, width, block, 1, yekanFont36);

        // Item Panels
        JPanel foodItem1Panel = new JPanel();
        cartBtns[0] = itemPanelRenderer(foodItem1Panel, foodPanel, width, block, 3, filePath + "/SirSteakPizza.png",
                "پیتزا سیر و استیک", "370,000 ت", yekanFont24, yekanFont12, filePath, itemAmount[0]);
        JPanel foodItem2Panel = new JPanel();
        cartBtns[1] = itemPanelRenderer(foodItem2Panel, foodPanel, width, block, 6, filePath + "/makhsoosPizza.jpeg",
                "پیتزا مخصوص کافه", "340,000 ت", yekanFont24, yekanFont12, filePath, itemAmount[1]);
        JPanel foodItem3Panel = new JPanel();
        cartBtns[2] = itemPanelRenderer(foodItem3Panel, foodPanel, width, block, 9, filePath + "/burger.jpg",
                "برگر                           ", "250,000 ت", yekanFont24, yekanFont12, filePath, itemAmount[2]);
        JButton returnButtonFood = returnButtonRenderer(width, height, yekanFont12);
        foodPanel.add(returnButtonFood);


        // // Beverage Menu Frame & Panels
        JFrame beverageFrame = new JFrame("beverage menu");
        beverageFrame.setSize(new Dimension(width, height));
        beverageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        beverageFrame.setResizable(false);
        beverageFrame.setLayout(null);

        JPanel beveragePanel = new JPanel();
        beverageFrame.add(beveragePanel);
        beveragePanel.setLayout(null);
        beveragePanel.setBounds(0, 0, width, height);
        beveragePanel.setBackground(bgColor);
        beverageFrame.add(beveragePanel);

        JLabel beverageMainLabel = new JLabel("نوشیدنی ها");
        labelRenderer(beverageMainLabel, beveragePanel, width, block, 1, yekanFont36);

        // Item Panels
        JPanel beverageItem1Panel = new JPanel();
        cartBtns[3] = itemPanelRenderer(beverageItem1Panel, beveragePanel, width, block, 3, filePath + "/espresso.jpg",
                "اسپرسو                     ", "80,000 ت    ", yekanFont24, yekanFont12, filePath, itemAmount[3]);
        JPanel beverageItem2Panel = new JPanel();
        cartBtns[4] = itemPanelRenderer(beverageItem2Panel, beveragePanel, width, block, 6, filePath + "/latte.jpg",
                "لاته                           ", "110,000 ت", yekanFont24, yekanFont12, filePath, itemAmount[4]);
        JPanel beverageItem3Panel = new JPanel();
        cartBtns[5] = itemPanelRenderer(beverageItem3Panel, beveragePanel, width, block, 9, filePath + "/hot chocolate.jpg",
                "هات چاکلت             ", "100,000 ت", yekanFont24, yekanFont12, filePath, itemAmount[5]);
        JButton returnButtonBeverage = returnButtonRenderer(width, height, yekanFont12);
        beveragePanel.add(returnButtonBeverage);


        // // Dessert Menu Frame & Panels
        JFrame dessertFrame = new JFrame("dessert menu");
        dessertFrame.setSize(new Dimension(width, height));
        dessertFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dessertFrame.setResizable(false);
        dessertFrame.setLayout(null);

        JPanel dessertPanel = new JPanel();
        dessertFrame.add(dessertPanel);
        dessertPanel.setLayout(null);
        dessertPanel.setBounds(0, 0, width, height);
        dessertPanel.setBackground(bgColor);
        dessertFrame.add(dessertPanel);

        JLabel dessertMainLabel = new JLabel("دسر ها");
        labelRenderer(dessertMainLabel, dessertPanel, width, block, 1, yekanFont36);

        // Item Panels
        JPanel dessertItem1Panel = new JPanel();
        cartBtns[6] = itemPanelRenderer(dessertItem1Panel, dessertPanel, width, block, 3, filePath + "/chocolate.jpg",
                "کیک شکلاتی              ", "140,000 ت", yekanFont24, yekanFont12, filePath, itemAmount[6]);
        JPanel dessertItem2Panel = new JPanel();
        cartBtns[7] = itemPanelRenderer(dessertItem2Panel, dessertPanel, width, block, 6, filePath + "/vanilla.jpg",
                "کیک وانیلی             ", "120,000 ت", yekanFont24, yekanFont12, filePath, itemAmount[7]);
        JPanel dessertItem3Panel = new JPanel();
        cartBtns[8] = itemPanelRenderer(dessertItem3Panel, dessertPanel, width, block, 9, filePath + "/croissant.jpg",
                "کروسان                    ", "160,000 ت", yekanFont24, yekanFont12, filePath, itemAmount[8]);
        JButton returnButtonDessert = returnButtonRenderer(width, height, yekanFont12);
        dessertPanel.add(returnButtonDessert);


        // // Shopping Cart Frame, Panels & Functionalities
        JFrame cartFrame = new JFrame("Shopping Cart");
        cartFrame.setSize(new Dimension(width, height));
        cartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cartFrame.setResizable(false);
        cartFrame.setLayout(null);

        JPanel cartPanel = new JPanel();
        cartFrame.add(cartPanel);
        cartPanel.setLayout(null);
        cartPanel.setBounds(0, 0, width, height);
        cartPanel.setBackground(bgColor);

        JButton returnButtonCart = returnButtonRenderer(width, height, yekanFont12);
        cartPanel.add(returnButtonCart);

        String[] itemLabels = {"پیتزا سیر و استیک", "پیتزا مخصوص کافه", "برگر", "اسپرسو", "لاته", "هات چاکلت",
                "کیک شکلاتی", "کیک وانیلی", "کروسان"};
        String[] itemPaths = {"/SirSteakPizza.png", "/makhsoosPizza.jpeg", "/burger.jpg", "/espresso.jpg", "/latte.jpg",
                "/hot chocolate.jpg", "/chocolate.jpg", "/vanilla.jpg", "/croissant.jpg"};
        String[] itemPrices = {"370000", "340000", "250000", "80000", "110000", "100000", "140000", "120000", "160000"};
        JPanel[] itemCartPanels = new JPanel[9];
        for (int i = 0; i < 9; i++) {
            itemCartPanels[i] = new JPanel();
        }
        int k = 0;
        for (int i = 0; i < 9; i++) {
            if (itemAmount[i] > 0) {
                itemCartPanelRenderer(itemCartPanels[i], cartPanel, width, block, (int) (10 + ((int) k / 2) * block * 2.5), filePath + itemPaths[i], itemLabels[i],
                        itemPrices[i], yekanFont24, yekanFont12, i, itemAmount[i]);
                k++;
            }
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Integer.parseInt(itemPrices[i]) * itemAmount[i];
        }
        JLabel totalPriceLabel = new JLabel("مجموع: " + String.valueOf(sum) + " تومان");
        totalPriceLabelRenderer(cartPanel, totalPriceLabel, yekanFont24, width);

        JButton[] orderButtonCart = {orderButtonRenderer(width, height, yekanFont12)};
        cartPanel.add(orderButtonCart[0]);

        // Events
        foodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                foodFrame.setVisible(true);
            }
        });

        beverageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                beverageFrame.setVisible(true);
            }
        });

        dessertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                dessertFrame.setVisible(true);
            }
        });

        returnButtonFood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foodFrame.setVisible(false);
                menuFrame.setVisible(true);
            }
        });

        returnButtonBeverage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                beverageFrame.setVisible(false);
                menuFrame.setVisible(true);
            }
        });

        returnButtonDessert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dessertFrame.setVisible(false);
                menuFrame.setVisible(true);
            }
        });

        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                cartFrame.setVisible(true);
            }
        });

        returnButtonCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(true);
                cartFrame.setVisible(false);
            }
        });

        // action listeners for adding and subtracting items from the cart
        for (int i = 0; i < 9; i++) {
            final int finalI = i;
            cartBtns[i][0].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    itemAmount[finalI] += 1;

                    cartPanel.removeAll();
                    for (int j = 0; j < 9; j++) {
                        itemCartPanels[j].removeAll();
                    }
                    int k = 0;
                    int[] itemTimesSetInCart = new int[9];
                    for (int j = 0; j < 9; j++) {
                        if (itemAmount[j] > 0 && itemTimesSetInCart[j] == 0) {
                            itemCartPanelRenderer(itemCartPanels[j], cartPanel, width, block, (int) (10 + ((int) k / 2) * block * 2.5), filePath + itemPaths[j], itemLabels[j],
                                    itemPrices[j], yekanFont24, yekanFont12, k, itemAmount[j]);
                            itemTimesSetInCart[j]++;
                            k++;
                        }
                    }

                    cartPanel.revalidate();
                    cartPanel.repaint();
                    cartPanel.add(returnButtonCart);

                    int sum = 0;
                    for (int l = 0; l < 9; l++) {
                        sum += Integer.parseInt(itemPrices[l]) * itemAmount[l];
                    }
                    JLabel totalPriceLabel = new JLabel("مجموع: " + sum + " تومان");
                    totalPriceLabelRenderer(cartPanel, totalPriceLabel, yekanFont24, width);
                    orderButtonCart[0] = orderButtonRenderer(width, height, yekanFont12);
                    cartPanel.add(orderButtonCart[0]);

                    orderButtonCart[0].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            for (int i = 0; i < 9; i++) {
                                itemAmount[i] = 0;
                            }

                            cartPanel.removeAll();
                            cartPanel.revalidate();
                            cartPanel.repaint();
                            cartPanel.add(returnButtonCart);

                            int sum = 0;
                            JLabel totalPriceLabel = new JLabel("مجموع: " + sum + " تومان");
                            totalPriceLabelRenderer(cartPanel, totalPriceLabel, yekanFont24, width);
                            orderButtonCart[0] = orderButtonRenderer(width, height, yekanFont12);
                            cartPanel.add(orderButtonCart[0]);
                        }
                    });
                }
            });
        }

        for (int i = 0; i < 9; i++) {
            final int finalI = i;
            cartBtns[i][1].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (itemAmount[finalI] > 0)
                        itemAmount[finalI]--;

                    cartPanel.removeAll();
                    for (int j = 0; j < 9; j++) {
                        itemCartPanels[j].removeAll();
                    }
                    int k = 0;
                    int[] itemTimesSetInCart = new int[9];
                    for (int j = 0; j < 9; j++) {
                        if (itemAmount[j] > 0 && itemTimesSetInCart[j] == 0) {
                            itemCartPanelRenderer(itemCartPanels[j], cartPanel, width, block, (int) (10 + ((int) k / 2) * block * 2.5), filePath + itemPaths[j], itemLabels[j],
                                    itemPrices[j], yekanFont24, yekanFont12, k, itemAmount[j]);
                            itemTimesSetInCart[j]++;
                            k++;
                        }
                    }

                    cartPanel.revalidate();
                    cartPanel.repaint();
                    cartPanel.add(returnButtonCart);

                    int sum = 0;
                    for (int l = 0; l < 9; l++) {
                        sum += Integer.parseInt(itemPrices[l]) * itemAmount[l];
                    }
                    JLabel totalPriceLabel = new JLabel("مجموع: " + sum + " تومان");
                    totalPriceLabelRenderer(cartPanel, totalPriceLabel, yekanFont24, width);
                    orderButtonCart[0] = orderButtonRenderer(width, height, yekanFont12);
                    cartPanel.add(orderButtonCart[0]);

                    orderButtonCart[0].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            for (int i = 0; i < 9; i++) {
                                itemAmount[i] = 0;
                            }

                            cartPanel.removeAll();
                            cartPanel.revalidate();
                            cartPanel.repaint();
                            cartPanel.add(returnButtonCart);

                            int sum = 0;
                            JLabel totalPriceLabel = new JLabel("مجموع: " + sum + " تومان");
                            totalPriceLabelRenderer(cartPanel, totalPriceLabel, yekanFont24, width);
                            orderButtonCart[0] = orderButtonRenderer(width, height, yekanFont12);
                            cartPanel.add(orderButtonCart[0]);
                        }
                    });
                }
            });
        }

        orderButtonCart[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    itemAmount[i] = 0;
                }

                cartPanel.removeAll();
                cartPanel.revalidate();
                cartPanel.repaint();
                cartPanel.add(returnButtonCart);

                int sum = 0;
                JLabel totalPriceLabel = new JLabel("مجموع: " + String.valueOf(sum) + " تومان");
                totalPriceLabelRenderer(cartPanel, totalPriceLabel, yekanFont24, width);
                orderButtonCart[0] = orderButtonRenderer(width, height, yekanFont12);
                cartPanel.add(orderButtonCart[0]);
            }
        });

        menuFrame.setVisible(true);
    }
}